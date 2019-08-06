package io.hz.modules.mis.controller;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisCommentEntity;
import io.hz.modules.mis.entity.MisPrivateChatEntity;
import io.hz.modules.mis.entity.MisReality_resultEntity;
import io.hz.modules.mis.service.MisCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
@RestController
@RequestMapping("mis/miscomment")
public class MisCommentController {
    @Autowired
    private MisCommentService misCommentService;
    /**
     * 列表
     *
     * {name:"张三",age:18,birthday:2018-8-8}
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misCommentService.queryPage(params);
        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
        /**
         * {"msg":"success","code":0,"page":{"totalCount":9,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":4,"name":"李三","age":18,"score":98.0},{"id":5,"name":"李六","age":21,"score":90.0},{"id":7,"name":"张三","age":20,"score":98.0},{"id":10,"name":"3333","age":333,"score":333.0},{"id":11,"name":"tet","age":100,"score":100.0},{"id":12,"name":"理想","age":3,"score":12.0},{"id":13,"name":"理想","age":3,"score":12.0},{"id":14,"name":"理想","age":3,"score":12.0},{"id":15,"name":"理想3333","age":3,"score":12.0}]}}
         */
    }

    //根据tid显示
    @RequestMapping("/info1/{tid}")
    public R list1(@PathVariable("tid") Integer tid){
        return R.ok().put("misComment", misCommentService.selectBytid(tid));
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisCommentEntity misComment = misCommentService.selectById(id);

        return R.ok().put("misComment", misComment);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    @RequestMapping("/add")
    public R add(@RequestParam Map<String,Object> params){
        String content = (String)params.get("content");
        int uid = Integer.parseInt((String) params.get("uid"));
        int tid = Integer.parseInt((String) params.get("tid"));
        int testunderstand = Integer.parseInt((String) params.get("testunderstand"));
        int testexact = Integer.parseInt((String) params.get("testexact"));
        int testpractical = Integer.parseInt((String) params.get("testpractical"));
        Date time = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        MisCommentEntity misCommentEntity = new MisCommentEntity();
        misCommentEntity.setTid(tid);
        misCommentEntity.setContent(content);
        misCommentEntity.setUid(uid);
        misCommentEntity.setTestunderstand(testunderstand);
        misCommentEntity.setTestexact(testexact);
        misCommentEntity.setTestpractical(testpractical);
        misCommentEntity.setCreatetime(dateFormat.format(time));
        misCommentService.insert(misCommentEntity);
        return R.ok();
    }
}
