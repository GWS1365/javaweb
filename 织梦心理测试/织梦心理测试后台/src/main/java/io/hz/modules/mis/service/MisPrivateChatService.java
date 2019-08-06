package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisPrivateChatEntity;

import java.util.Map;

public interface MisPrivateChatService extends IService<MisPrivateChatEntity> {
    PageUtils MyqueryPage(Map<String, Object> params);

}
