package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisCategoryDao;
import io.hz.modules.mis.entity.MisCategoryEntity;
import io.hz.modules.mis.service.MisCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisCategoryServiceImpl extends ServiceImpl<MisCategoryDao, MisCategoryEntity> implements MisCategoryService {
    /**
     * 实现自定义方法
     *
     * new Query<MisStudentEntity>(params).getPage():分页信息
     *
     * Wrapper<T> wrapper：查询条件
     * new EntityWrapper
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        //where name like '%??% and age>19'
        Page<MisCategoryEntity> page = this.selectPage(
                new Query<MisCategoryEntity>(params).getPage(),
                new EntityWrapper<MisCategoryEntity>().like(StringUtils.isNotBlank(name), "name", name)
        );

        return new PageUtils(page);
    }
}
