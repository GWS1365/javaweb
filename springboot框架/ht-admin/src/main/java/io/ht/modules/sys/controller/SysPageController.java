 
package io.ht.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图，页面跳转，已注册到springmvc RequestMappingHandlerMapping中，
 * 返回 freemaker解析完的html文件，根据名称去找
 * 
 * 访问路径总入口
 * 
 *  Mapped "{[/ || /index.html]}" onto  SysPageController.index()
 *  
 * Mapped "{[/main.html]}" onto  SysPageController.main()
 * 
 * Mapped "{[/modules/{module}/{url}.html]}" onto  SysPageController.module(java.lang.String,java.lang.String)
 * 
 * Mapped "{[/login.html]}" onto SysPageController.login()
 * 
 * Mapped "{[/404.html]}" onto SysPageController.notFound()
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {
	
	/**
	 * 前端访问路径跳转 controller,freemmaker渲染
	 * 如
	 * modules/sys/user.html
	 * module:sys
	 * url： user
	 * @param module
	 * @param url
	 * @return
	 */
	@RequestMapping("modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url){
		return "modules/" + module + "/" + url;
	}



	@RequestMapping("/test")
	public String test(){
		return "/pro/fenlei2";
	}
	/**
	 * 跳转index
	 * @return
	 */
	@RequestMapping(value = {"/", "index.html"})
	public String index(){
		return "index";
	}


	/**
	 * 跳转Login
	 * @return
	 */
	@RequestMapping("login.html")
	public String login(){
		return "login";
	}

	@RequestMapping("main.html")
	public String main(){
		return "main";
	}

	@RequestMapping("404.html")
	public String notFound(){
		return "404";
	}

}
