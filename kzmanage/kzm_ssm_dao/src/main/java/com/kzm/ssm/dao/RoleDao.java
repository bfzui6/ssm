package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Permission;
import com.kzm.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    Role findById(String id)throws Exception;

    List<Role> findAll()throws Exception;

    void save(Role role)throws Exception;

    List<Permission> findOtherPermissions(String id)throws Exception;



    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId")String permissionId)throws Exception;
}
