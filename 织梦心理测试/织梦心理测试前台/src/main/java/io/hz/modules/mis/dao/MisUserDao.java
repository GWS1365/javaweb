package io.hz.modules.mis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.hz.modules.mis.entity.MisUserEntity;
import org.apache.ibatis.annotations.Select;

public interface MisUserDao extends BaseMapper<MisUserEntity> {

    @Select("select * from mis_user where openid = #{openid}")
    MisUserEntity getMisUserByOpenId(String openid);
}
