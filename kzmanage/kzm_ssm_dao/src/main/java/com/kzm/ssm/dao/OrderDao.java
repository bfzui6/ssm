package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Orders findById(String id)throws Exception;

    List<Orders> findAll()throws Exception;
}
