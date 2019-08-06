package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisOrderEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisOrderDao extends BaseMapper<MisOrderEntity> {
    @Select("select a.id,a.orderid,a.createtime,a.status,b.name as uname,c.title as tname from mis_order a,mis_user b,mis_test c where a.uid = b.id and a.tid=c.id and b.name like '%${uname}%' and c.title like '%${tname}%' order by ${sidx} ${order}")
    List<MisOrderEntity> Myquery(Pagination page, Map<String ,Object> params);
}
