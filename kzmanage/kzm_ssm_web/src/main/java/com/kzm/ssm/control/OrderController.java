package com.kzm.ssm.control;

import com.github.pagehelper.PageInfo;
import com.kzm.ssm.domain.Orders;
import com.kzm.ssm.domain.Role;
import com.kzm.ssm.services.OrdersService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders o = ordersService.findById(id);
        mv.addObject("orders",o);
        mv.setViewName("orders-show");
        return mv;
    }
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "pageNum" ,defaultValue = "1")int pageNum,@RequestParam(name = "pageSize" ,defaultValue = "3") int pageSize) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

}
