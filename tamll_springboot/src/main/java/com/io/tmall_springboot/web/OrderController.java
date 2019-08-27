package com.io.tmall_springboot.web;

import com.io.tmall_springboot.pojo.Order;
import com.io.tmall_springboot.service.OrderItemService;
import com.io.tmall_springboot.service.OrderService;
import com.io.tmall_springboot.util.Page4Navigator;
import com.io.tmall_springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("orders")
    public Page4Navigator<Order> list(@RequestParam(value = "start" ,defaultValue = "0") int start,
                                      @RequestParam(value = "size",defaultValue = "5")int size){
        start=start<0?0:start;
        Page4Navigator<Order> page = orderService.list(start,size,5);
        orderItemService.fill(page.getContent());
        orderService.remoteOrderFromOrderItem(page.getContent());
        return page;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object update(@PathVariable("oid") int oid){
        Order o = orderService.get(oid);
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return Result.success();
    }
}
