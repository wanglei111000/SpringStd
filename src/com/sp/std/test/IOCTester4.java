package com.sp.std.test;

import com.sp.std.dao.CarDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTester4 {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext6.xml");

    @Test
    public void test(){
        //可以在 注解的后面添加 名字  如 ： @Repository("carDao01")
        CarDao carDao01 = (CarDao)applicationContext.getBean("carDao01");
        CarDao carDao02 = (CarDao)applicationContext.getBean("carDao01");
        System.out.println(carDao01 == carDao02);
    }

}
