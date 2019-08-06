 
package io.hz.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import io.hz.common.base.PageUtils;
import io.hz.modules.sys.entity.SysUserEntity;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService extends IService<SysUserEntity> {

	
	/**
	 * 分页查询用户
	 */
	PageUtils queryPage(Map<String, Object> params);
	

	
	/**
	 * 保存用户
	 */
	void save(SysUserEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);
	
	/**
	 * 删除用户
	 */
	void delete(Long[] userIds);

	/**
	 * 修改密码
	 * @param user_Id       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(SysUserEntity user, String password, String newPassword);

	/**
	 *  登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	SysUserEntity  login(String name,String pwd);
}
