package com.sp.std.beans;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        System.out.println("myFactoryBean  ......创建对象........");
        Car car = new Car();
        car.setPrice(10000);
        car.setColor("blue");
        car.setCarName("Hammer");
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
