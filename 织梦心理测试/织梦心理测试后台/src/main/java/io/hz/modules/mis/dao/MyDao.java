package io.hz.modules.mis.dao;

import io.hz.modules.mis.entity.ExportEntity;

import java.util.List;
import java.util.Map;

public interface MyDao {
    public List<ExportEntity> select1(Map<String,Object>m);
}
