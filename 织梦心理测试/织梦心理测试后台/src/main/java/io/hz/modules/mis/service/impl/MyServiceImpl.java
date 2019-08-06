package io.hz.modules.mis.service.impl;

import io.hz.modules.mis.dao.MyDao;
import io.hz.modules.mis.entity.ExportEntity;
import io.hz.modules.mis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private MyDao myDao;

    @Override
    public List<ExportEntity>select1(Map<String,Object>m){
        return myDao.select1(m);
    }
}
