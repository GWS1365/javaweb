package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.dao.MisPrestore_resultDao;
import io.hz.modules.mis.entity.MisPrestore_resultEntity;
import io.hz.modules.mis.service.MisPrestore_resultService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisPrestore_resultServiceImpl extends ServiceImpl<MisPrestore_resultDao, MisPrestore_resultEntity> implements MisPrestore_resultService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String tname = (String) params.get("tname");
        if( tname==null){
            tname ="";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisPrestore_resultEntity> page = new Page<MisPrestore_resultEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }
}
