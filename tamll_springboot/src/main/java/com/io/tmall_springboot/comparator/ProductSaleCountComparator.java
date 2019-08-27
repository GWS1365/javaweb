package com.io.tmall_springboot.comparator;

import com.io.tmall_springboot.pojo.Product;

import java.util.Comparator;

public class ProductSaleCountComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1,Product p2){
        return p2.getSaleCount()-p1.getSaleCount();
    }
}
