package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisCategoryEntity;
import io.hz.modules.mis.service.MisCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/miscategory")
public class MisCategoryController {
    @Autowired
    private MisCategoryService misCategoryService;

    /**
     * 列表
     *
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misCategoryService.queryPage(params);
        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisCategoryEntity misCategory = misCategoryService.selectById(id);

        return R.ok().put("misCategory", misCategory);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    /**
     * RequestBody:参数
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MisCategoryEntity misCategory){
        misCategoryService.insert(misCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MisCategoryEntity misCategory){
        misCategoryService.updateById(misCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misCategoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}
