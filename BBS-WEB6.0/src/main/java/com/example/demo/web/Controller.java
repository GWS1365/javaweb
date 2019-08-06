package com.example.demo.web;

import com.example.demo.model.Product;
import com.example.demo.seivice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ProductService productService;

    @GetMapping(value="/admins/ggg")
    public List<Product> listProducts (){
        List<Product> products= this.productService.getProducts();
        return products;
    }
}
