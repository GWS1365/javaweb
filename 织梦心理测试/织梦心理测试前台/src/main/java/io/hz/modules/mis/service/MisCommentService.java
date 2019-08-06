package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisCommentEntity;

import java.util.List;
import java.util.Map;

public interface MisCommentService extends IService<MisCommentEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MisCommentEntity>selectBytid(Integer tid);
}
