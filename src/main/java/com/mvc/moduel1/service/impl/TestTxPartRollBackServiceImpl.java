package com.mvc.moduel1.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.moduel1.dao.PermissionMapper;
import com.mvc.moduel1.dao.RoleMapper;
import com.mvc.moduel1.dao.UserMapper;
import com.mvc.moduel1.model.Permission;
import com.mvc.moduel1.model.Role;
import com.mvc.moduel1.model.User;

@Service("testTxPartRollBackService")
public class TestTxPartRollBackServiceImpl {
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private PermissionMapper permissionMapper;
	
	//这个不回滚
	public void userInsert() {
		User user = new User();
		user.setUsername("testuser1");
		System.out.println("user>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		userMapper.insert(user);
	}
	//回滚
	@Transactional
	public void roleInsert() {
		Role role = new Role();
		System.out.println("role>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		role.setRoleName("testrole1");
		roleMapper.insert(role);

	}
	//回滚	
	@Transactional
	public void permissionInsert() throws Exception{
		Permission permission = new Permission();
		System.out.println("permission>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		permission.setPermissionName("testpermission1");
		permissionMapper.insert(permission);
		throw new Exception("ssssssss");
	}
	
	public void testTxPartRollBack() throws Exception{
		userInsert();
		roleInsert();
		permissionInsert();
	}

}
