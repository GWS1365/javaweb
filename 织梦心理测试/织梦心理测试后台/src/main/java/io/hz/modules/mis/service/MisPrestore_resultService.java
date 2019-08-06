package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisPrestore_resultEntity;

import java.util.Map;

public interface MisPrestore_resultService extends IService<MisPrestore_resultEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
