package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisPrivateChatEntity;
import io.hz.modules.mis.entity.MisReality_resultEntity;

import java.util.List;
import java.util.Map;

public interface MisPrivateChatService extends IService<MisPrivateChatEntity> {
    PageUtils MyqueryPage(Map<String,Object>params);

}
