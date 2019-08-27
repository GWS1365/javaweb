package com.io.tmall_springboot.service;

import com.io.tmall_springboot.dao.OrderItemDAO;
import com.io.tmall_springboot.pojo.OrderItem;
import com.io.tmall_springboot.pojo.Order;
import com.io.tmall_springboot.pojo.Product;
import com.io.tmall_springboot.pojo.User;
import com.io.tmall_springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames="orderItems")
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ProductImageService productImageService;

    public void fill(List<Order> orders){
        for(Order order:orders){
            fill(order);
        }
    }
    public void fill(Order order){
        OrderItemService orderItemService = SpringContextUtil.getBean(OrderItemService.class);
        List<OrderItem> orderItems = orderItemService.listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for(OrderItem oi : orderItems){
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber += oi.getNumber();
            productImageService.setFirstProductImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    @Cacheable(key = "'orderItems-oid-'+#p0.id")
    public List<OrderItem> listByOrder(Order order){
        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }

    public int getSaleCount(Product product){
        OrderItemService orderItemService = SpringContextUtil.getBean(OrderItemService.class);
        List<OrderItem> ois = orderItemService.listByProduct(product);
        int result = 0;
        for(OrderItem oi :ois){
            if(null!=oi.getOrder()){
                if(null!=oi.getOrder()&&null!=oi.getOrder().getPayDate()){
                    result +=oi.getNumber();
                }
            }
        }
        return result;
    }

//    @Cacheable(key = "'orderItems-pid-'+#p0.id")
    public List<OrderItem> listByProduct(Product product){
        return orderItemDAO.findByProduct(product);
    }

    @Cacheable(key = "'orderItems-uid-'+#p0.id")
    public List<OrderItem> listByUser(User user){
        return orderItemDAO.findByUserAndOrderIsNull(user);
    }

    @CacheEvict(allEntries = true)
    public void update(OrderItem orderItem){
        orderItemDAO.save(orderItem);
    }

    @CacheEvict(allEntries = true)
    public void add(OrderItem orderItem){
        orderItemDAO.save(orderItem);
    }

//    @Cacheable(key = "'orderItems-one-'+#p0.id")
    public OrderItem get(int id){
        return orderItemDAO.findById(id).get();
    }

    @CacheEvict(allEntries = true)
    public void delete(int id){
        orderItemDAO.deleteById(id);
    }
}
