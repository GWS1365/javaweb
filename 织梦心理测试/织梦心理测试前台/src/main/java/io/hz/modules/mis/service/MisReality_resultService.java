package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisReality_resultEntity;

import java.util.List;
import java.util.Map;

public interface MisReality_resultService extends IService<MisReality_resultEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MisReality_resultEntity> Myquery1();

    List<MisReality_resultEntity>getResult(Integer uid,Integer pid,Integer tid);

    MisReality_resultEntity getResultByTidUid(Map<String,Object> params);

    List<MisReality_resultEntity> getResultByStatus();
}
