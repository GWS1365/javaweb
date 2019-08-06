package io.ht.modules.sys.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.ht.common.base.PageUtils;
import io.ht.common.base.R;
import io.ht.modules.sys.entity.SysUserEntity;
import io.ht.modules.sys.service.SysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 管理用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	
	/**
	 * 1.查询，根据参数获取所有用户列表
	 *
	 *
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysUserService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	/**
	 * 2.获取当前登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(HttpSession session){
		return R.ok().put("user",session.getAttribute("user"));
	}
	
	/**
	 * 3.修改登录用户密码
	 */
	@RequestMapping("/password")
	public R password(String password, String newPassword,HttpSession session){
		//更新密码
		boolean flag = sysUserService.updatePassword((SysUserEntity)session.getAttribute("user"), password, newPassword);
		if(!flag){
			return R.error("原密码不正确");
		}
		session.invalidate();
		return R.ok();
	}
	
	/**
	 * 4.根据ID获取用户信息
	 */
	@RequestMapping("/info/{userId}")

	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.selectById(userId);
		

		
		return R.ok().put("user", user);
	}
	
	/**
	 * 5.保存用户
	 */

	@RequestMapping("/save")

	public R save(@RequestBody SysUserEntity user){

		if(sysUserService.selectOne(new EntityWrapper<SysUserEntity>().eq("username", user.getUsername()))!=null)
		{
			return R.error("用户名不能重复");
		}
		

		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 6.修改用户
	 */

	@RequestMapping("/update")

	public R update(@RequestBody SysUserEntity user){

		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 7.删除用户
	 */

	@RequestMapping("/delete")

	public R delete(@RequestBody Long[] userIds,HttpSession session){
		//1.判断系统管理员
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		//2.判断当前用户
		SysUserEntity user=(SysUserEntity)session.getAttribute("user");
		if(ArrayUtils.contains(userIds,user.getUserId())){
			return R.error("当前用户不能删除");
		}

		sysUserService.delete(userIds);
		
		return R.ok();
	}
}
