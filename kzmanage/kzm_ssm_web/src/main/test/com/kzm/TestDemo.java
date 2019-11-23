package com.kzm;

import com.kzm.ssm.dao.OrderDao;
import com.kzm.ssm.dao.PermissionDao;
import com.kzm.ssm.dao.ProductDao;
import com.kzm.ssm.dao.UserDao;
import com.kzm.ssm.domain.Orders;
import com.kzm.ssm.domain.Product;
import com.kzm.ssm.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private SqlSession sqlSession;
    private InputStream inputStream;
    private OrderDao orderDao;
    private ProductDao productDao;
    private PermissionDao permissionDao;
    private UserDao userDao;
    @Before
    public void init() throws Exception {
        inputStream=Resources.getResourceAsStream("MybatisConfiger.xml");
        sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        orderDao = sqlSession.getMapper(OrderDao.class);
        productDao = sqlSession.getMapper(ProductDao.class);
        permissionDao=sqlSession.getMapper(PermissionDao.class);
        userDao=sqlSession.getMapper(UserDao.class);
    }
    @After
    public void af() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void test1() throws Exception {
        List<Orders> orders = orderDao.findAll();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
    @Test
    public void test2() throws Exception {
        Product product = productDao.findById("12B7ABF2A4C544568B0A7C69F36BF8B7");
        System.out.println(product);
    }

    @Test
    public void test3() throws Exception {
        UserInfo id = userDao.findById("1001");
        System.out.println(id);
    }
}
