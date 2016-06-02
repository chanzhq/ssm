package com.mvc.moduel1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mvc.moduel1.dao.PermissionMapper;
import com.mvc.moduel1.model.Permission;
import com.mvc.moduel1.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> selectPermissionsByRoleId(Long roleId) {
		return permissionMapper.selectPermissionsByRoleId(roleId);
	}

}
