package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.dao.MisPrivateChatDao;
import io.hz.modules.mis.entity.MisPrivateChatEntity;
import io.hz.modules.mis.service.MisPrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisPrivateChatServiceImpl extends ServiceImpl<MisPrivateChatDao, MisPrivateChatEntity> implements MisPrivateChatService {

    @Autowired
    MisPrivateChatDao misPrivateChatDao;

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        String uname = (String) params.get("uname");
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (sidx == "") {
            params.put("sidx", "id");
        }
        if (uname == null) {
            uname = "";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisPrivateChatEntity> page = new Page<MisPrivateChatEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page,params)));
    }
}
