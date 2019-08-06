package io.hz.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.hz.common.base.R;
import javax.servlet.http.HttpSession;

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

	/**
	 * 获取当前登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(HttpSession session){
		return R.ok().put("user",session.getAttribute("misUserEntity"));
	}
}
