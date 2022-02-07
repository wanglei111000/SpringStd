package com.sp.std.beans;

public class CarStaticFactory {
    //静态方法调用方式  CarStaticFactory.createCar();
    public static Car createCar(String carName){
        Car car = new Car();
        car.setCarName(carName);
        car.setColor("green");
        car.setPrice(10000);
        return car;
    }
}
