package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Role;
import com.kzm.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    UserInfo findById(String id)throws Exception;

    UserInfo findByUserName(String userName)throws Exception;

    List<UserInfo> findAll()throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

    List<Role> findOtherRole(String id)throws Exception;

    void addRoleToUser(@Param("roleId") String roleId,@Param("userId") String userId)throws Exception;
}
