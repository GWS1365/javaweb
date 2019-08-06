package io.hz.modules.mis.service.impl;


import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;

import io.hz.modules.mis.dao.MisReality_resultDao;
import io.hz.modules.mis.entity.MisReality_resultEntity;
import io.hz.modules.mis.service.MisReality_resultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MisReality_resultServiceImpl extends ServiceImpl<MisReality_resultDao, MisReality_resultEntity> implements MisReality_resultService {
    @Autowired
    MisReality_resultDao misReality_resultDao;

    @Override
    public List<MisReality_resultEntity> getResultByStatus(){
        return misReality_resultDao.getResultByStatus();
    }
    @Override
    public MisReality_resultEntity getResultByTidUid(Map<String,Object> params){
        return misReality_resultDao.getResultByTidUid(params);
    }

    @Override
    public List<MisReality_resultEntity> Myquery1(){
        return baseMapper.Myquery1();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String uname = (String) params.get("uname");
        String tname = (String) params.get("tname");
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (sidx == "") {
            params.put("sidx", "id");
        }
        if (uname == null || tname == null) {
            uname = "";
            tname = "";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisReality_resultEntity> page = new Page<MisReality_resultEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }

    @Override
    public List<MisReality_resultEntity> getResult(Integer uid,Integer pid,Integer tid){
        return baseMapper.getResult(uid,pid,tid);
    }
}
