package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisQuestionEntity;
import io.hz.modules.mis.service.MisQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/misquestion")
public class MisQuestionController {
    @Autowired
    private MisQuestionService misQuestionService;

    /**
     * 列表
     *
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misQuestionService.MyqueryPage(params);

        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisQuestionEntity misQuestion = misQuestionService.selectById(id);

        return R.ok().put("misQuestion", misQuestion);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    /**
     * RequestBody:参数
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MisQuestionEntity misQuestion){
        misQuestionService.insert(misQuestion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MisQuestionEntity misQuestion){
        misQuestionService.updateById(misQuestion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misQuestionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}
