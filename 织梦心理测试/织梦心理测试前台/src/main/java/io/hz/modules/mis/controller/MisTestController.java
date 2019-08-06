package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisTestEntity;
import io.hz.modules.mis.service.MisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("mis/mistest")
public class MisTestController {
    @Autowired
    private MisTestService misTestService;

    @RequestMapping("/listCollect")
    public R listCollect(@RequestParam Map<String,Object> params){
        return R.ok().put("e",misTestService.selectCollectTest(params));

    }
    //分页显示
    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params){
        PageUtils page = misTestService.MyqueryPage(params);
        return R.ok().put("page",page);
    }
    //搜索显示
    @RequestMapping("/list1")
   public R list1(@RequestBody Map<String,Object> params){
        return R.ok().put("misTest",misTestService.Search(params));
    }

    //根据cid显示
    @RequestMapping("/info1/{cid}")
    public R info1(@PathVariable("cid") Integer cid){
        return R.ok().put("misTest", misTestService.selectBycid(cid));
    }

    @RequestMapping("/listAll")
    public R list3(@RequestParam Map<String,Object> params){
        return R.ok().put("c",misTestService.getTestLimit(params));
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisTestEntity misTest = misTestService.selectById(id);

        return R.ok().put("misTest", misTest);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

    @RequestMapping("/getTestBut")
    public R getTestBut(@RequestParam("uid") Integer uid){
        return R.ok().put("j",misTestService.getTestBut(uid));
    }

    /**
     * RequestBody:参数
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MisTestEntity misTest){
        misTestService.insert(misTest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MisTestEntity misTest){
        misTestService.updateById(misTest);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        misTestService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/getTestByCid/{cid}")
    public R get(@PathVariable("cid") int cid){
        return R.ok().put("b",misTestService.getTestByCid(cid));
    }

    @RequestMapping("/list10")
    public R getAll(){
        return R.ok().put("misTest",misTestService.getAll());
    }

    @RequestMapping("/getTests")
    public R getTests(){return R.ok().put("h",misTestService.getTests());}
}
