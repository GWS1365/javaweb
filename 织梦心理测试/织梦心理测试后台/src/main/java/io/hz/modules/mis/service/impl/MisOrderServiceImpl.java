package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.dao.MisOrderDao;
import io.hz.modules.mis.entity.MisOrderEntity;
import io.hz.modules.mis.service.MisOrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisOrderServiceImpl extends ServiceImpl<MisOrderDao, MisOrderEntity> implements MisOrderService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String uname = (String) params.get("uname");
        String tname = (String) params.get("tname");
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (sidx == "") {
            params.put("sidx", "id");
        }
        if(uname==null || tname==null){
            uname ="";
            tname ="";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisOrderEntity> page = new Page<MisOrderEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }
}
