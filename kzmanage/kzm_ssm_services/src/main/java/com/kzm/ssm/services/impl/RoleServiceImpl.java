package com.kzm.ssm.services.impl;

import com.kzm.ssm.dao.RoleDao;
import com.kzm.ssm.dao.UserDao;
import com.kzm.ssm.domain.Permission;
import com.kzm.ssm.domain.Role;
import com.kzm.ssm.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }


    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String id) throws Exception {
        return  roleDao.findOtherPermissions(id);
    }
}
