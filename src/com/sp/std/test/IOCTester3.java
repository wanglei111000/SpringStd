package com.sp.std.test;


import com.sp.std.beans.Person;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;


public class IOCTester3 {
    //测试自动装配
    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext5.xml");
    @Test
    public void test() throws SQLException {
        Person person = (Person) applicationContext.getBean("person01");
        System.out.println(person);
        //UUID.randomUUID().toString().substring(0,8)
        Person person02 = (Person) applicationContext.getBean("person002");
        System.out.println(person02);
    }

}
