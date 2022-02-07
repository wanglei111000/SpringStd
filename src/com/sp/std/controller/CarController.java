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
    // 避免多个时 不知道使用哪个，容器启动时会报错
    private CarService carService;
}
