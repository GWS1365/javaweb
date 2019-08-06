package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisTestEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface MisTestDao extends BaseMapper<MisTestEntity> {

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid and title like '%${title}%' and a.name like '%${cname}%'")
    List<MisTestEntity> Myquery(Pagination page,Map<String ,Object> params);

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid and b.cid like '%${cid}%' order by createtime desc")
    List<MisTestEntity> getTestByCid(@Param(value = "cid") Integer cid);

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime from mis_category a,mis_test b where a.id=b.cid")
    List<MisTestEntity> getAllTest();

    @Select("select a.name as cname , b.id,b.title,b.imgsrc,b.price,b.testnumber,b.testintroduce,b.createtime,b.cid from mis_category a,mis_test b where a.id=b.cid order by ${t} ${y} limit #{u}")
    List<MisTestEntity> getTestLimit(Map<String ,Object> params);

    @Select("select * from mis_test where title like '%${title}%' order by testnumber desc")
    List<MisTestEntity> Search(Map<String,Object> params);

    //根据cid查询c
    @Select("select  * from mis_test where cid = '${cid}' order by testnumber desc limit 2")
    List<MisTestEntity>selectBycid(@Param("cid")Integer cid);

    @Select("select  a.*,b.id as nid from mis_test a,mis_note b where b.tid = a.id and b.collect = 1 and b.uid = #{uid} order by a.id desc")
    List<MisTestEntity>selectCollectTest(Map<String ,Object> params);

    @Select("select * from mis_test order by createtime desc")
    List<MisTestEntity> getTests();

    @Select("select a.* from mis_test a,mis_reality_result b where b.status = 0 and b.tid = a.id and b.uid = #{uid}")
    List<MisTestEntity> getTestBut(Integer uid);
}
