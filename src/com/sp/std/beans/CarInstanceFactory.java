package com.sp.std.beans;

public class CarInstanceFactory {
    //实例 工厂类 需要先new 才能使用
    public Car createCar(String carName){
        Car car = new Car();
        car.setCarName(carName);
        car.setColor("green");
        car.setPrice(10000);
        return car;
    }
}
