package com.mvc.moduel1.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.moduel1.model.User;
import com.mvc.moduel1.security.PermissionSign;
import com.mvc.moduel1.security.RoleSign;
import com.mvc.moduel1.service.UserService;

/**
 * @author czq
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 用户登入
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误");
				return "login";
			}
			subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
			// 验证成功在session中保存用户信息
			final User authUserInfo = userService.selectByUsername(user.getUsername());
			request.getSession().setAttribute("userinfo", authUserInfo);
		} catch (AuthenticationException e) {
			// 身份认证失败
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
		return "redirect:/";
	}

	/**
	 * 用户登出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.removeAttribute("userinfo");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	/**
     * 基于角色 标识的权限控制案例
     */
	@RequestMapping("/admin")
	@ResponseBody
	@RequiresPermissions(value=RoleSign.ADMIN)
	public String admin(){
        return "拥有admin角色,能访问";
	}
	/**
	 * 基于权限标识的权限控制案例
	 */
	@RequestMapping("create")
	@ResponseBody
	@RequiresPermissions(value=PermissionSign.USER_CREATE)
	public String create(){
		return "";
	}

}
