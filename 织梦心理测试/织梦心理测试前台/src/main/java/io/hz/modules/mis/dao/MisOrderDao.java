package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisOrderEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MisOrderDao extends BaseMapper<MisOrderEntity> {
    @Select("select a.id,a.orderid,a.createtime,a.status,b.name as uname,c.title as tname from mis_order a,mis_user b,mis_test c where a.uid = b.id and a.tid=c.id and b.name like '%${uname}%' and c.title like '%${tname}%'")
    List<MisOrderEntity> Myquery(Pagination page, Map<String ,Object> params);

    //显示订单
    @Select("select a.*,b.title as tname,b.imgsrc as timgsrc,b.price as tprice,b.cid as cid,c.pid as pid from mis_order a,mis_test b ,mis_reality_result c where a.uid= #{uid} and a.tid = b.id and b.id=c.tid")
    List<MisOrderEntity>showList(@Param(value = "uid") Integer uid);

    @Select("select * from mis_order where uid = #{uid} and tid = #{tid} ")
    MisOrderEntity getOrderByUidTid(Map<String,Object> params);
}
