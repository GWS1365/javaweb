package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisUserEntity;

import java.util.Map;

public interface MisUserService extends IService<MisUserEntity> {
    PageUtils queryPage(Map<String, Object> params);

    MisUserEntity getMisUserByOpenId(String openid);
}
