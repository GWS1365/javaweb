package com.io.tmall_springboot.service;

import com.io.tmall_springboot.dao.ProductImageDAO;
import com.io.tmall_springboot.pojo.OrderItem;
import com.io.tmall_springboot.pojo.Product;
import com.io.tmall_springboot.pojo.ProductImage;
import com.io.tmall_springboot.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "productImages")
public class ProductImageService {
    public static final String type_single="single";
    public static final String type_detail="detail";

    @Autowired
    ProductImageDAO productImageDAO;

    @CacheEvict(allEntries = true)
    public void add(ProductImage bean){
        productImageDAO.save(bean);
    }

    @CacheEvict(allEntries = true)
    public void delete(int id){
        productImageDAO.deleteById(id);
    }

//    @Cacheable(key = "'productImages-one-'+#p0.id")
    public ProductImage get(int id){
        return productImageDAO.findById(id).get();
    }

    @Cacheable(key = "'productImages-single-pid-'+#p0.id")
    public List<ProductImage> listSingleProductImages(Product product){
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product,type_single);
    }

    @Cacheable(key = "'productImage-detail-pid-'+#p0.id")
    public List<ProductImage> listDetailProductImages(Product product){
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product,type_detail);
    }

    public void setFirstProductImage(Product product){
        ProductImageService productImageService = SpringContextUtil.getBean(ProductImageService.class);
        List<ProductImage> singleImage = productImageService.listSingleProductImages(product);
        if(!singleImage.isEmpty())
            product.setFirstProductImage(singleImage.get(0));
        else
            product.setFirstProductImage(new ProductImage());
    }
    public void setFirstProductImages(List<Product> products){
        for(Product product : products)
            setFirstProductImage(product);
    }

    public void setFirstProductImagesOnOrderItems(List<OrderItem> ois){
        for(OrderItem orderItem : ois){
            setFirstProductImage(orderItem.getProduct());
        }
    }
}
