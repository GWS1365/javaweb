package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisTestEntity;

import java.util.List;
import java.util.Map;

public interface MisTestService extends IService<MisTestEntity> {
    PageUtils queryPage(Map<String, Object> params);

    PageUtils MyqueryPage(Map<String,Object>params);

    List<MisTestEntity> getTestByCid(Integer cid);

    List<MisTestEntity>getAll();
}
