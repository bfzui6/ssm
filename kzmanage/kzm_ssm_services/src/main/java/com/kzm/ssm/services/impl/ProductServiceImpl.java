package com.kzm.ssm.services.impl;

import com.kzm.ssm.dao.ProductDao;
import com.kzm.ssm.domain.Product;
import com.kzm.ssm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> finAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }
}
