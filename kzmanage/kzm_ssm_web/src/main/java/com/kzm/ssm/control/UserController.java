package com.kzm.ssm.control;

import com.kzm.ssm.domain.Role;
import com.kzm.ssm.domain.UserInfo;
import com.kzm.ssm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("findById")
    public ModelAndView findUser(String id) throws Exception {
        UserInfo user= userService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findUses() throws Exception {
        ModelAndView mv=new ModelAndView();
      List<UserInfo> list= userService.findAll();
      mv.addObject("userList",list);
      mv.setViewName("user-list");
      return mv;
    }

    @RequestMapping("/saveUser")
    public String  saveUser(UserInfo userInfo) throws Exception {
         userService.saveUser(userInfo);
         return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        UserInfo userInfo = userService.findById(id);
        List<Role>roles= userService.findOtherdRole(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("roleList",roles);
        mv.addObject("user",userInfo);
        mv.setViewName("user-role-add");
        return  mv;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId")String userId,@RequestParam(name = "ids")String[] roleIds) throws Exception {
        userService.addRoleToUser(roleIds,userId);
        return "redirect:findAll";
    }
}
