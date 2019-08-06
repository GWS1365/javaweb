package io.hz.modules.mis.service;

import com.baomidou.mybatisplus.service.IService;
import io.hz.common.base.PageUtils;
import io.hz.modules.mis.entity.MisNoteEntity;

import java.util.List;
import java.util.Map;

public interface MisNoteService extends IService<MisNoteEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MisNoteEntity> selectByuid(Integer uid);
}
