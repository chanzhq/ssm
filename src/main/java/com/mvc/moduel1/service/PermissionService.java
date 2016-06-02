package com.mvc.moduel1.service;

import java.util.List;

import com.mvc.moduel1.model.Permission;

public interface PermissionService {
    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Long roleId);
}
