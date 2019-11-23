package com.kzm.ssm.services;

import com.kzm.ssm.domain.Permission;
import com.kzm.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll()throws Exception;

    void save(Role role)throws Exception;

    Role findById(String id)throws Exception;

    List<Permission> findOtherPermissions(String id)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
