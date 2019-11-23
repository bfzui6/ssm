package com.kzm.ssm.dao;

import com.kzm.ssm.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 */
@Repository()
public interface ProductDao {
    //查询所有商品信息
    List<Product> findAll() throws Exception;

    //保存商品信息
    void saveProduct(Product product) throws Exception;

    //根据id查询
    Product findById(String id) throws Exception;
}
