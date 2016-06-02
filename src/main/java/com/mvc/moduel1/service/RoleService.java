package com.mvc.moduel1.service;

import java.util.List;

import com.mvc.moduel1.model.Role;

public interface RoleService {
	public List<Role> selectRolesByUserId(long id) ;
}
