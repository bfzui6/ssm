package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionDao {

    List<Permission> findPermissionByRoleId(String id);

    List<Permission> findAll()throws Exception;

    void save(Permission permission)throws Exception;
}
