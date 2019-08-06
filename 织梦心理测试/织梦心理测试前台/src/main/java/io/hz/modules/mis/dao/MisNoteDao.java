package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisNoteEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MisNoteDao extends BaseMapper<MisNoteEntity> {
    @Select("select a.id,a.footmark,a.collect,a.like,b.name as uname,c.title as tname from mis_note a,mis_user b,mis_test c where a.uid = b.id and a.tid=c.id and b.name like '%${uname}%' and c.title like '%${tname}%'")
    List<MisNoteEntity> Myquery(Pagination page, Map<String ,Object> params);

    //根据cid查询c
    @Select("select  * from mis_note where uid = '${uid}'")
    List<MisNoteEntity>selectBycid(@Param("uid")Integer uid);

}
