package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisReality_resultEntity;
import io.hz.modules.mis.entity.MisTestEntity;
import io.hz.modules.mis.service.MisReality_resultService;
import io.hz.modules.mis.service.MisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("mis/misreality_result")
public class MisReality_resultController {
    @Autowired
    private MisReality_resultService misReality_resultService;

    @Autowired
    private MisTestService misTestService;
    /**
     * 列表
     *
     * {name:"张三",age:18,birthday:2018-8-8}
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misReality_resultService.queryPage(params);

        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
        /**
         * {"msg":"success","code":0,"page":{"totalCount":9,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":4,"name":"李三","age":18,"score":98.0},{"id":5,"name":"李六","age":21,"score":90.0},{"id":7,"name":"张三","age":20,"score":98.0},{"id":10,"name":"3333","age":333,"score":333.0},{"id":11,"name":"tet","age":100,"score":100.0},{"id":12,"name":"理想","age":3,"score":12.0},{"id":13,"name":"理想","age":3,"score":12.0},{"id":14,"name":"理想","age":3,"score":12.0},{"id":15,"name":"理想3333","age":3,"score":12.0}]}}
         */
    }

    @RequestMapping("/list1")
    public R list(){
        return R.ok().put("a",misReality_resultService.Myquery1());
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisReality_resultEntity misReality_result = misReality_resultService.selectById(id);

        return R.ok().put("misReality_result", misReality_result);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    @RequestMapping("/getResultByStatus")
    public R getResultByStatus() {
        return R.ok().put("j",misReality_resultService.getResultByStatus());
    }

    @RequestMapping("/add")
    public R add(@RequestParam Map<String,Object> params) {
        Date time = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        int uid = Integer.parseInt((String) params.get("uid"));
        int scoresum = Integer.parseInt((String) params.get("scoresum"));
        int tid = Integer.parseInt((String) params.get("tid"));
        int status = Integer.parseInt((String) params.get("status"));
        int pid = Integer.parseInt((String) params.get("pid"));
        params.put("uid", uid);
        params.put("tid", tid);
        if( misReality_resultService.getResultByTidUid(params)== null){
            MisReality_resultEntity misReality_resultEntity = new MisReality_resultEntity();
            misReality_resultEntity.setUid(uid);
            misReality_resultEntity.setPid(pid);
            misReality_resultEntity.setScoresum(scoresum);
            misReality_resultEntity.setTid(tid);
            misReality_resultEntity.setTesttime(dateFormat.format(time));
            misReality_resultEntity.setStatus(status);
            misReality_resultService.insert(misReality_resultEntity);
        }else {
            Integer id = misReality_resultService.getResultByTidUid(params).getId();
            MisReality_resultEntity m = new MisReality_resultEntity();
            m.setId(id);
            m.setUid(uid);
            m.setPid(pid);
            m.setScoresum(scoresum);
            m.setTid(tid);
            m.setTesttime(dateFormat.format(time));
            m.setStatus(status);
            misReality_resultService.updateById(m);
            MisTestEntity misTestEntity = new MisTestEntity();
            misTestEntity = misTestService.selectById(tid);
            int testNumber = misTestEntity.getTestnumber();
            misTestEntity.setTestnumber(testNumber+1);
            misTestService.updateById(misTestEntity);
        }
        return R.ok();
    }


    @RequestMapping("/infoResult/{uid}/{pid}/{tid}")
    public R infoResult(@PathVariable("uid")Integer uid,@PathVariable("pid") Integer pid,@PathVariable("tid") Integer tid){
        return R.ok().put("misResult",misReality_resultService.getResult(uid,pid,tid));
    }
}
