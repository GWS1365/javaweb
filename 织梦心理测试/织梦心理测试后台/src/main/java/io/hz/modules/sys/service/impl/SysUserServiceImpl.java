
package io.hz.modules.sys.service.impl;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.hz.common.utils.MD5Util;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.hz.common.base.PageUtils;
import io.hz.common.base.Query;

import io.hz.modules.sys.dao.SysUserDao;

import io.hz.modules.sys.entity.SysUserEntity;

import io.hz.modules.sys.service.SysUserService;


/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {


    /**
     * 分页查询用户，根据姓名模糊匹配
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String) params.get("username");

        Page<SysUserEntity> page = this.selectPage(
                new Query<SysUserEntity>(params).getPage(),
                new EntityWrapper<SysUserEntity>()
                        .like(StringUtils.isNotBlank(username), "username", username)
        //username like '%%'
        );


        return new PageUtils(page);
    }

    /**
     * 添加用户
     */
    @Override
    public void save(SysUserEntity user) {

        user.setPassword(MD5Util.MD5Encode(user.getPassword()));
        this.insert(user);


    }

    /**
     * 更新用户
     */
    @Override
    public void update(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(MD5Util.MD5Encode(user.getPassword()));
        }
        this.updateById(user);


    }

    /**
     * 删除用户
     */
    @Override
    public void delete(Long[] userIds) {
        //删除用户
        baseMapper.deleteBatchIds(Arrays.asList(userIds));


    }

    /**
     * 修改密码
     */
    @Override
    public boolean updatePassword(SysUserEntity user, String password, String newPassword) {
        //原密码，加盐
        password = MD5Util.MD5Encode(password);
        //新密码，加盐
        newPassword = MD5Util.MD5Encode(newPassword);
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", user.getUserId()).eq("password", password));
    }

    /**
     * 登录
     */
    @Override
    public SysUserEntity login(String name, String pwd) {
        String password=MD5Util.MD5Encode(pwd);
        SysUserEntity result=this.selectOne(new EntityWrapper<SysUserEntity>().eq("username",name).and().eq("password",password));
        return result;
    }

}
