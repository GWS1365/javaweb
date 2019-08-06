package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisOrderDao;
import io.hz.modules.mis.entity.MisOrderEntity;
import io.hz.modules.mis.entity.MisReality_resultEntity;
import io.hz.modules.mis.service.MisOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MisOrderServiceImpl extends ServiceImpl<MisOrderDao, MisOrderEntity> implements MisOrderService {

    @Autowired
    MisOrderDao misOrderDao;

    @Override
    public MisOrderEntity getOrderByUidTid(Map<String,Object> params){
        int uid = Integer.parseInt((String) params.get("uid"));
        params.put("uid", uid);
        int tid = Integer.parseInt((String) params.get("tid"));
        params.put("tid", tid);
        return misOrderDao.getOrderByUidTid(params);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String uname = (String) params.get("uname");
        String tname = (String) params.get("tname");
        if (uname == null || tname == null) {
            uname = "";
            tname = "";

        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisOrderEntity> page = new Page<MisOrderEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }

    @Override
    public List<MisOrderEntity> showList(Integer uid){
        return baseMapper.showList(uid);
    }
}
