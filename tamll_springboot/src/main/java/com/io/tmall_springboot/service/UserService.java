package com.io.tmall_springboot.service;

import com.io.tmall_springboot.dao.UserDAO;
import com.io.tmall_springboot.pojo.User;
import com.io.tmall_springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Cacheable(key = "'users-page-'+#p0+'-'+#p1")
    public Page4Navigator<User> list(int start,int size,int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormJPA = userDAO.findAll(pageable);
        return new Page4Navigator<>(pageFormJPA,navigatePages);
    }

    public boolean isExist(String name){
        User user = getByName(name);
        return null!=user;
    }

    @Cacheable(key = "'users-one-name-'+#p0")
    public User getByName(String name){
        return userDAO.findByName(name);
    }

    @CacheEvict(allEntries = true)
    public void add(User user){
        userDAO.save(user);
    }

    @Cacheable(key = "'users-one-name-'+#p0+'-'+#p1")
    public User get(String name,String password){
        return userDAO.getByNameAndPassword(name,password);
    }
}
