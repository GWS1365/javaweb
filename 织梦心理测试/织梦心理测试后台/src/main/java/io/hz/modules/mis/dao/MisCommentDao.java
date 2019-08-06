package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisCommentEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisCommentDao extends BaseMapper<MisCommentEntity> {
    @Select("select a.id,a.createtime,a.content,a.testunderstand,a.testexact,a.testpractical,b.name as uname,c.title as tname from mis_comment a,mis_user b,mis_test c where a.uid = b.id and a.tid=c.id and b.name like '%${uname}%' and c.title like '%${tname}%' order by ${sidx} ${order}")
    List<MisCommentEntity> Myquery(Pagination page, Map<String ,Object> params);

}
