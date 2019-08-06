package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisTestEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

public interface MisTestDao extends BaseMapper<MisTestEntity> {

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid and title like '%${title}%' and a.name like '%${cname}%' order by ${sidx} ${order}")
    List<MisTestEntity> Myquery(Pagination page,Map<String ,Object> params);

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid and b.cid like '%${cid}%' ")
    List<MisTestEntity> getTestByCid(@Param(value = "cid") Integer cid);

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid ")
    List<MisTestEntity> getAllTest();
}
