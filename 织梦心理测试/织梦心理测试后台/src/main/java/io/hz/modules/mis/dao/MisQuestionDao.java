package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisQuestionEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisQuestionDao extends BaseMapper<MisQuestionEntity> {
    @Select("select b.title as tname,a.id,a.question,a.choicea,a.choiceb,a.choicec,a.choiced,a.choicee,a.choicef,a.choiceg,a.choiceh from mis_question a,mis_test b where a.tid=b.id and a.question like '%${question}%' and b.title like '%${tname}%' order by ${sidx} ${order}")
    List<MisQuestionEntity> Myquery(Pagination page, Map<String ,Object> params);
}
