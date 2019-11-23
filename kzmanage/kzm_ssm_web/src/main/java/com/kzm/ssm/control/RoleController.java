package com.kzm.ssm.control;

import com.kzm.ssm.domain.Permission;
import com.kzm.ssm.domain.Role;
import com.kzm.ssm.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findRole() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Role> list= roleService.findAll();
        mv.addObject("roleList",list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
       roleService.save(role);
       return "redirect:findAll";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
       Role role=  roleService.findById(id);
       List<Permission> permissions=roleService.findOtherPermissions(id);
       mv.addObject("permissionList",permissions);
       mv.addObject("role",role);
       mv.setViewName("role-permission-add");
       return mv;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId")String roleId,@RequestParam(name = "ids")String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
}
