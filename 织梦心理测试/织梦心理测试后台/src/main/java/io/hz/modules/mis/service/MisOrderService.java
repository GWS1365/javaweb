package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisOrderEntity;

import java.util.Map;

public interface MisOrderService extends IService<MisOrderEntity> {
    PageUtils queryPage(Map<String, Object> params);

}
