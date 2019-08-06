 
package io.ht.modules.sys.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.ht.common.base.R;
import io.ht.modules.sys.entity.SysUserEntity;
import io.ht.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关,使用session
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
public class SysLoginController {
	
	/**
	 * 验证码生成器
	 */
	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 生成图片验证码，保存到 session
	 *
	 *  HttpSession session
	 */
	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpSession session)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        
        //保存到 session,KV，本session可以存到redis，也可以存到本内存
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);    //图片流
	}
	
	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha, HttpSession session) {
		
		//1.判定验证码
		String kaptcha = session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");    //R
		}

		//登录判断
		SysUserEntity user=sysUserService.login(username,password);
		if(user==null){
			return R.error("用户名或密码错误");
		}
		session.setAttribute("user",user);

		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.html";
	}
	
}
