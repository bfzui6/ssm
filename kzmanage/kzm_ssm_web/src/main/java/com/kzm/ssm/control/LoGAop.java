package com.kzm.ssm.control;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoGAop {
    //获取开始时间和执行的类和方法
    @Before("execution(* com.kzm.ssm.control.*.*(..))")
    public void beforedo(){

    }
    @After("execution(* com.kzm.ssm.control.*.*(..))")
    public void afterdo(){

    }
}
