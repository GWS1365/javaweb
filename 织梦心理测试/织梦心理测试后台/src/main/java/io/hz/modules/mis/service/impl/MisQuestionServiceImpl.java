package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisQuestionDao;
import io.hz.modules.mis.entity.MisQuestionEntity;
import io.hz.modules.mis.service.MisQuestionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisQuestionServiceImpl extends ServiceImpl<MisQuestionDao, MisQuestionEntity> implements MisQuestionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String question = (String) params.get("question");
        Page<MisQuestionEntity> page = this.selectPage(
                new Query<MisQuestionEntity>(params).getPage(),
                new EntityWrapper<MisQuestionEntity>().like(StringUtils.isNotBlank(question), "question", question)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        String question = (String) params.get("question");
        String tname = (String) params.get("tname");
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (sidx == "") {
            params.put("sidx", "id");
        }
        if(question==null || tname==null){
            question ="";
            tname ="";
        }
        Integer cur = Integer.valueOf(params.get("page").toString());
        Integer size = Integer.valueOf(params.get("limit").toString());
        Page<MisQuestionEntity> page = new Page<MisQuestionEntity>(cur, size);
        return new PageUtils(page.setRecords(baseMapper.Myquery(page, params)));
    }
}
