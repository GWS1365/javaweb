package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisNoteDao;
import io.hz.modules.mis.entity.MisNoteEntity;
import io.hz.modules.mis.service.MisNoteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MisNoteServiceImpl extends ServiceImpl<MisNoteDao, MisNoteEntity> implements MisNoteService {
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
        Page<MisNoteEntity> page = new Page<MisNoteEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));

    }

    @Override
    public List<MisNoteEntity> selectByuid(Integer uid) {

        return baseMapper.selectBycid(uid);
    }
}
