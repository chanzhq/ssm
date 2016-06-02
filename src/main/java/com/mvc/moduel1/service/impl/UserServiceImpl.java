package com.mvc.moduel1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mvc.moduel1.dao.UserMapper;
import com.mvc.moduel1.model.User;
import com.mvc.moduel1.model.UserExample;
import com.mvc.moduel1.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User authentication(User user) {
		UserExample exa = new UserExample();
		exa.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<User> list = userMapper.selectByExample(exa);
		if (CollectionUtils.isEmpty(list))
			return null;
		else
			return list.get(0);
	}

	@Override
	public User selectByUsername(String userName) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		List<User> list = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list))
			return null;
		else
			return list.get(0);
	}
}
