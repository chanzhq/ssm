package com.mvc.moduel1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mvc.moduel1.dao.RoleMapper;
import com.mvc.moduel1.model.Role;
import com.mvc.moduel1.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectRolesByUserId(long userid) {
		return roleMapper.selectRolesByUserid(userid);
	}

}
