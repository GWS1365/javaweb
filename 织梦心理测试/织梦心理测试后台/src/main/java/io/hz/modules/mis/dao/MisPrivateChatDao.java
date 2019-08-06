package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisPrivateChatEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisPrivateChatDao extends BaseMapper<MisPrivateChatEntity> {

    @Select("select a.id,a.contact,a.content,b.name as uname from mis_private_chat a,mis_user b where a.uid=b.id and b.name like '%${uname}%' order by ${sidx} ${order}")
    List<MisPrivateChatEntity> Myquery(Pagination page, Map<String, Object> params);
}
