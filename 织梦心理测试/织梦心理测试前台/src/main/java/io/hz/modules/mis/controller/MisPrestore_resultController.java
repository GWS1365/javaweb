package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisPrestore_resultEntity;
import io.hz.modules.mis.service.MisPrestore_resultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/misprestore_result")
public class MisPrestore_resultController {
    @Autowired
    private MisPrestore_resultService misPrestore_resultService;

    /**
     * 列表
     *
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misPrestore_resultService.queryPage(params);

        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisPrestore_resultEntity misPrestore_result = misPrestore_resultService.selectById(id);

        return R.ok().put("misPrestore_result", misPrestore_result);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    /**
     * RequestBody:参数
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MisPrestore_resultEntity misPrestore_result){
        misPrestore_resultService.insert(misPrestore_result);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MisPrestore_resultEntity misPrestore_result){
        misPrestore_resultService.updateById(misPrestore_result);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misPrestore_resultService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}
