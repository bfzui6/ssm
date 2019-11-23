package com.kzm.ssm.services;

import com.kzm.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public List<Product>finAll()throws Exception;

    void saveProduct(Product product)throws Exception;
}
