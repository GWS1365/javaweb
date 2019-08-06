package io.hz.modules.mis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;
import io.hz.modules.mis.dao.MisUserDao;
import io.hz.modules.mis.entity.MisUserEntity;
import io.hz.modules.mis.service.MisUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MisUserServiceImpl extends ServiceImpl<MisUserDao, MisUserEntity> implements MisUserService {
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
    @Autowired
    MisUserDao misUserDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        //where name like '%??% and age>19'
        Page<MisUserEntity> page = this.selectPage(
                new Query<MisUserEntity>(params).getPage(),
                new EntityWrapper<MisUserEntity>()
                        .like(StringUtils.isNotBlank(name), "name", name)
        );

        return new PageUtils(page);
    }

    @Override
    public MisUserEntity getMisUserByOpenId(String openid){
        return misUserDao.getMisUserByOpenId(openid);
    }
}
