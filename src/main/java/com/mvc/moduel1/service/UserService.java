package com.mvc.moduel1.service;

import com.mvc.moduel1.model.User;

public interface UserService {
	/**
	 * 登录验证
	 * @param user
	 * @return
	 */
	public User authentication(User user);
	
	public User selectByUsername(String userName);
}
