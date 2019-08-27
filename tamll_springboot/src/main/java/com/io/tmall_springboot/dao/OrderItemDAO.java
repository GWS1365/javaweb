package com.io.tmall_springboot.dao;

import com.io.tmall_springboot.pojo.OrderItem;
import com.io.tmall_springboot.pojo.Order;
import com.io.tmall_springboot.pojo.Product;
import com.io.tmall_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
