package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisNoteEntity;
import io.hz.modules.mis.service.MisNoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/misnote")
public class MisNoteController {
    @Autowired
    private MisNoteService misNoteService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misNoteService.queryPage(params);

        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
        /**
         * {"msg":"success","code":0,"page":{"totalCount":9,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":4,"name":"李三","age":18,"score":98.0},{"id":5,"name":"李六","age":21,"score":90.0},{"id":7,"name":"张三","age":20,"score":98.0},{"id":10,"name":"3333","age":333,"score":333.0},{"id":11,"name":"tet","age":100,"score":100.0},{"id":12,"name":"理想","age":3,"score":12.0},{"id":13,"name":"理想","age":3,"score":12.0},{"id":14,"name":"理想","age":3,"score":12.0},{"id":15,"name":"理想3333","age":3,"score":12.0}]}}
         */
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisNoteEntity misNote = misNoteService.selectById(id);

        return R.ok().put("misNote", misNote);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    //根据uid显示
    @RequestMapping("/info1/{uid}")
    public R info1(@PathVariable("uid") Integer uid){
        return R.ok().put("misNote", misNoteService.selectByuid(uid));
    }

    @RequestMapping("/save")
    public R save(@RequestBody MisNoteEntity misnote){
        misNoteService.insert(misnote);
        return R.ok();
    }
    @RequestMapping("/add")
    public R add(@RequestParam Map<String,Object>params){
        int uid = Integer.parseInt((String)params.get("uid"));
        int tid = Integer.parseInt((String)params.get("tid"));
        int collect = Integer.parseInt((String)params.get("collect"));
        MisNoteEntity misNoteEntity = new MisNoteEntity();
        misNoteEntity.setTid(tid);
        misNoteEntity.setUid(uid);
        misNoteEntity.setCollect(collect);
        misNoteEntity.setFootmark(0);
        misNoteEntity.setLike(0);
        misNoteService.insert(misNoteEntity);

        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misNoteService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
