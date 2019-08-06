package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisPrestore_resultEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisPrestore_resultDao extends BaseMapper<MisPrestore_resultEntity> {
    @Select("select b.title as tname,a.id,a.result,a.details,a.maxscore,a.minscore from mis_prestore_result a,mis_test b where a.tid=b.id and b.title like '%${tname}%' order by ${sidx} ${order}")
    List<MisPrestore_resultEntity> Myquery(Pagination page, Map<String ,Object> params);
}
