package com.kzm.ssm.services.impl;

import com.kzm.ssm.dao.PermissionDao;
import com.kzm.ssm.domain.Permission;
import com.kzm.ssm.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
       return  permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
