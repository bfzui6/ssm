package com.kzm.ssm.services;

import com.kzm.ssm.domain.Role;
import com.kzm.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserInfo findById(String id)throws Exception;


    List<UserInfo> findAll()throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

     List<Role> findOtherdRole(String id)throws Exception;

    void addRoleToUser(String[] roleIds, String userId)throws Exception;
}
