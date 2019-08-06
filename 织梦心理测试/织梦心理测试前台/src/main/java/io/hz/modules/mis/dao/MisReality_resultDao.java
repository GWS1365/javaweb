package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.hz.modules.mis.entity.MisReality_resultEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface MisReality_resultDao extends BaseMapper<MisReality_resultEntity> {
    @Select("select a.id,a.testtime,a.status,a.scoresum,b.name as uname,c.title as tname ,d.result as presult from mis_reality_result a,mis_user b,mis_test c,mis_prestore_result d where a.uid=b.id and a.tid=c.id and a.pid = d.id and b.name like '%${uname}%' and c.title like '%${tname}%' order by '${sidx}' '${order}'")
    List<MisReality_resultEntity> Myquery(Pagination page,Map<String,Object> params);

    @Select("select a.id,a.testtime,a.status,a.scoresum,b.name as uname,c.title as tname ,d.result as presult from mis_reality_result a,mis_user b,mis_test c,mis_prestore_result d where a.uid=b.id and a.tid=c.id and a.pid = d.id ")
    List<MisReality_resultEntity> Myquery1();

    //查结果
    @Select("select a.*,d.nickname as uname,b.result as presult,b.details as pdetails,c.title as tname,c.imgsrc as timgsrc from mis_reality_result a ,mis_prestore_result b ,mis_test c ,mis_user d where a.pid=b.id and a.tid = c.id and a.uid = d.id and a.pid='${pid}' and a.uid='${uid}' and a.tid='${tid}'")
    List<MisReality_resultEntity>getResult(@Param("uid")Integer uid,@Param("pid")Integer pid,@Param("tid")Integer tid);

    @Select("select * from mis_reality_result where tid = #{tid} and uid = #{uid}")
    MisReality_resultEntity getResultByTidUid(Map<String,Object> params);

    @Select("select * from mis_reality_result where status = 0")
    List<MisReality_resultEntity> getResultByStatus();
}
