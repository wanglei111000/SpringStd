package com.sp.std.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
// 加了注解之后 ioc 获取对象的的时候 默认按照 类名 首字母小写
@Repository("carDao01")
//@Scope("prototype")  //设置作用域为多实例
public class CarDao {

}
