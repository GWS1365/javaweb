package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisCategoryEntity;

import java.util.Map;


public interface MisCategoryService extends IService<MisCategoryEntity> {
    PageUtils queryPage(Map<String, Object> params);


}
