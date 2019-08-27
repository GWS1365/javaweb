package com.io.tmall_springboot.service;

import com.io.tmall_springboot.dao.OrderDAO;
import com.io.tmall_springboot.pojo.OrderItem;
import com.io.tmall_springboot.pojo.Order;
import com.io.tmall_springboot.pojo.User;
import com.io.tmall_springboot.util.Page4Navigator;
import com.io.tmall_springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "orderItems")
public class OrderService {
    public static final String waitPay="waitPay";
    public static final String waitDelivery="waitDelivery";
    public static final String waitConfirm="waitConfirm";
    public static final String waitReview="waitReview";
    public static final String finish="finish";
    public static final String delete="delete";

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    OrderItemService orderItemService;

    @Cacheable(key = "'orders-page-'+#p0+'-'+#p1")
    public Page4Navigator<Order> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormJPA = orderDAO.findAll(pageable);
        return new Page4Navigator<>(pageFormJPA,navigatePages);
    }

    public void remoteOrderFromOrderItem(List<Order> orders){
        for(Order order:orders){
            remoteOrderFromOrderItem(order);
        }
    }

    public void remoteOrderFromOrderItem(Order order){
        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem : orderItems){
            orderItem.setOrder(null);
        }
    }

    @Cacheable(key = "'orders-one-'+#p0")
    public Order get(int id){
        return orderDAO.findById(id).get();
    }

    @CacheEvict(allEntries=true)
    public void update(Order bean){
        orderDAO.save(bean);
    }

    @CacheEvict(allEntries=true)
    public float add(Order order,List<OrderItem> ois){
        float total = 0;
        add(order);

        for(OrderItem oi :ois){
            oi.setOrder(order);
            orderItemService.update(oi);
            total += oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }

    @CacheEvict(allEntries=true)
    public void add(Order order){
        orderDAO.save(order);
    }

    public List<Order> listByUserWithoutDelete(User user){
        OrderService orderService = SpringContextUtil.getBean(OrderService.class);
        List<Order> orders = orderService.listByUserAndNotDeleted(user);
        orderItemService.fill(orders);
        return orders;
    }

    @Cacheable(key = "'orders-uid-'+#p0.id")
    public List<Order> listByUserAndNotDeleted(User user){
        return orderDAO.findByUserAndStatusNotOrderByIdDesc(user,OrderService.delete);
    }

    public void cacl(Order o){
        List<OrderItem> orderItems = o.getOrderItems();
        float total = 0;
        for(OrderItem orderItem:orderItems){
            total+=orderItem.getProduct().getPromotePrice()*orderItem.getNumber();
        }
        o.setTotal(total);
    }
}
