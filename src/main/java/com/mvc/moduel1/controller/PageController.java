package com.mvc.moduel1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login")
	public String showLogin(){
		return "login";
	}
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}
	 /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
    	return "dashboard";
    }
}
