package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.dao.MisCommentDao;
import io.hz.modules.mis.entity.MisCommentEntity;
import io.hz.modules.mis.service.MisCommentService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MisCommentServiceImpl extends ServiceImpl<MisCommentDao, MisCommentEntity> implements MisCommentService {
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
        Page<MisCommentEntity> page = new Page<MisCommentEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }
}
