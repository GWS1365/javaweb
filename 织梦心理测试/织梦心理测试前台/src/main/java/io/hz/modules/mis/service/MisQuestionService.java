package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisQuestionEntity;

import java.util.List;
import java.util.Map;

public interface MisQuestionService extends IService<MisQuestionEntity> {
    PageUtils queryPage(Map<String, Object> params);
    PageUtils MyqueryPage(Map<String,Object>params);

    List<MisQuestionEntity> getQuestionBytid(Map<String ,Object> params);
}
