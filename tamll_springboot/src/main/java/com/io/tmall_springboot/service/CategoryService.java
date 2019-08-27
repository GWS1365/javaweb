package com.io.tmall_springboot.service;

import com.io.tmall_springboot.dao.CategoryDAO;
import com.io.tmall_springboot.pojo.Category;
import com.io.tmall_springboot.pojo.Product;
import com.io.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "categories")
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    @Cacheable(key="'categories-page-'+#p0+'-'+#p1")
    public Page4Navigator<Category> list(int start,int size,int navigatepageNums){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= new PageRequest(start,size,sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatepageNums);
    }

    @Cacheable(key = "'categories-all'")
    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    @CacheEvict(allEntries=true)
    //@CachePut(key="'categories-one-'+#p0")
    public void add(Category bean){
        categoryDAO.save(bean);
    }

    @CacheEvict(allEntries = true)
    //@CacheEvict(key="'categories-one-'+#p0")
    public void delete(int id){
        categoryDAO.deleteById(id);
    }

    @Cacheable(key="'categories-one-'+#p0")
    public Category get(int id){
        Category c = categoryDAO.findById(id).get();
        return c;
    }

    @CacheEvict(allEntries=true)
    public void update(Category bean){
        categoryDAO.save(bean);
    }

    public  void removeCategoryFromProduct(List<Category> cs){
        for(Category category : cs){
            removeCategoryFromProduct(category);
        }
    }

    public void removeCategoryFromProduct(Category category){
        List<Product> products = category.getProducts();
        if(null != products){
            for (Product product:products){
                product.setCategory(null);
            }
        }
        List<List<Product>> productsByRow = category.getProductsByRow();
        if(null!=productsByRow){
            for(List<Product> ps : productsByRow){
                for(Product product : products){
                    product.setCategory(null);
                }
            }
        }
    }
}
