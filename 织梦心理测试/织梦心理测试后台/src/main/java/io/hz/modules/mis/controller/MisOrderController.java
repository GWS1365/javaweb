package io.hz.modules.mis.controller;

import io.hz.common.base.PageUtils;
import io.hz.common.base.R;
import io.hz.modules.mis.entity.MisOrderEntity;
import io.hz.modules.mis.service.MisOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("mis/misorder")
public class MisOrderController {

    @Autowired
    private MisOrderService misOrderService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = misOrderService.queryPage(params);

        //复杂的map，返回的json
        return R.ok().put("page", page);   //对应前台分页
        /**
         * {"msg":"success","code":0,"page":{"totalCount":9,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":4,"name":"李三","age":18,"score":98.0},{"id":5,"name":"李六","age":21,"score":90.0},{"id":7,"name":"张三","age":20,"score":98.0},{"id":10,"name":"3333","age":333,"score":333.0},{"id":11,"name":"tet","age":100,"score":100.0},{"id":12,"name":"理想","age":3,"score":12.0},{"id":13,"name":"理想","age":3,"score":12.0},{"id":14,"name":"理想","age":3,"score":12.0},{"id":15,"name":"理想3333","age":3,"score":12.0}]}}
         */
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        MisOrderEntity misOrder = misOrderService.selectById(id);

        return R.ok().put("misOrder", misOrder);
        //{"msg":"success","misStudent":{"id":4,"name":"李三","age":18,"score":98.0},"code":0}
    }

}
