package com.kzm.ssm.services.impl;

import com.github.pagehelper.PageHelper;
import com.kzm.ssm.dao.OrderDao;
import com.kzm.ssm.domain.Orders;
import com.kzm.ssm.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Orders findById(String id) throws Exception {
        return orderDao.findById(id);
    }

    @Override
    public List<Orders> findAll(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.findAll();
    }

}
