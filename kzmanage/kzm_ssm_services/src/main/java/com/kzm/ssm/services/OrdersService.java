package com.kzm.ssm.services;

import com.kzm.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    //通过id查询order
    Orders findById(String id)throws Exception;

    List<Orders> findAll(int pageNum, int pageSize)throws Exception;
}
