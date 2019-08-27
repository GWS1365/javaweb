package com.io.tmall_springboot.dao;

import com.io.tmall_springboot.pojo.Product;
import com.io.tmall_springboot.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer> {
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product,String type);
}
