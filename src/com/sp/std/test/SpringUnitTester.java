package com.sp.std.test;

//spring 单元测试 案例

import com.sp.std.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//指定spring配置文件目录
@ContextConfiguration(locations = "classpath:/conf/applicationContext7.xml")
//使用spring 的单元测试模块 SpringJUnit4ClassRunner.class
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringUnitTester {
    //ApplicationContext applicationContext = null;
    @Autowired
    private CarService carService;

    @Test
    public void test01(){
        carService.sayHello("小明");
    }

}
