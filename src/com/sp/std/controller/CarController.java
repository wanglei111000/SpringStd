package com.sp.std.controller;

import com.sp.std.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {
    @Autowired
    @Qualifier("carService")
    //当有多个 实例对象被创建的时候 可以使用 @Qualifier 来指定不同的名称
    //根据指定名称来匹配，不使用默认的 根据类的变量名来装配
    //找到就装配 ，找不到就会报错
    //如果找不到 不想报错 ，可以添加 required  属性 默认true
    //指定@Autowired(required = false) 为false 会出现空指针异常
    private CarService carService;
}
