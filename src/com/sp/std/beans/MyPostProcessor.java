package com.sp.std.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/***
 *
 * 测试 后置处理器
 *
 */
public class MyPostProcessor implements BeanPostProcessor {
    //对象初始化完成之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" call postProcessBeforeInitialization .......");
        return bean;
    }
    //对象初始化完成之后调用

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" call postProcessAfterInitialization .......");
        return bean;
    }
}
