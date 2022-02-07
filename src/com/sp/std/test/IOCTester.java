package com.sp.std.test;

import com.sp.std.beans.Car;
import com.sp.std.beans.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTester {
    //classpath:/conf/applicationContext.xml 配置文件路径
    //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
    //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext2.xml");
    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext3.xml");

    //@Test
    public void test() {
        Person person = (Person) applicationContext.getBean("person01");  //通过ID 获取对对象
        //容器中对象的创建是在容器启动完成的时候 就已经创建好了的
        Person person2 = (Person) applicationContext.getBean("person01");
        //xml 中只有一个person 被定义的时候可以直接 使用 Person.class 不用强制类型转换
        //Person person2 = applicationContext.getBean(Person.class);  //通过类型 获取对对象，中能有一个Person 的定义在xml
        //Person person2 = applicationContext.getBean("person01",Person.class);
        System.out.println(person == person2);  // 结果为true 说明 spring 中对象默认是单例的
        //单例 模式的情况下 类的实例是在容器启动的是时候创建的
        System.out.println(person);

        Person person3 = (Person) applicationContext.getBean("person02");
        System.out.println(person3);

        Person person4 = (Person) applicationContext.getBean("person03");
        System.out.println(person4);


        Person person5 = (Person) applicationContext.getBean("person04");
        System.out.println(person5);

        Person person6 = (Person) applicationContext.getBean("person05");
        System.out.println(person6);

        Person person7 = (Person) applicationContext.getBean("person06");
        System.out.println(person7);
    }

    //@Test
    public void test2() {
        //测试 null ,m默认引用类型的默认值都是 null ,基本类型都为其 对应类型的默认值
        Object person07 = applicationContext.getBean("person07");
        System.out.println(person07);
        Person person = (Person) person07;
        System.out.println("person的car:" + person.getCar());
// 输出结果       person的car:Car{carName='BMW', price=100000000, color='yellow'}
//        修改完容器中的之后 person 中 car 的值：Car{carName='Benz', price=100000000, color='yellow'}
//        true
//说明 xml 中 ref 的方式 来引用类是一种 严格的引用 ，变化会随之变化
        Car car = (Car) applicationContext.getBean("car01");
        car.setCarName("Benz");
        System.out.println("修改完容器中的之后 person 中 car 的值：" + person.getCar());  //
        System.out.println(person.getCar() == car);  //true
        //此时容器中获取到的 car 值和 通过 person.getCar()获取到的值之一样的
        System.out.println("===============");


    }

    //@Test
    public void test3() {
        //测试外部类
        Person person = (Person) applicationContext.getBean("person07");
        System.out.println(person.getCar());
        //测试list bean
        Person person2 = (Person) applicationContext.getBean("person08");
        System.out.println(person2.getBooks());
        System.out.println(person2.getMaps());
        System.out.println(person2.getProperties());
        //测试 uitl 名称空间
        Person person3 = (Person) applicationContext.getBean("person09");
        System.out.println(person3.getMaps());


    }

    //@Test
    public void test4() {
        //测试级联属性 ，级联属性如果在配置的时候被修改 ，那么其他地方也会被修改
        Person person = (Person) applicationContext.getBean("person10");
        Car car = (Car) applicationContext.getBean("car01");
        System.out.println("容器中的car" + car);
        System.out.println("person中的car" + person.getCar());
        //测试属性的继承
        Person person2 = (Person) applicationContext.getBean("person11");
        System.out.println(person2);
        //测试抽象类  不能被直接调用
        // 异常信息  org.springframework.beans.factory.BeanIsAbstractException:
        // Error creating bean with name 'person12': Bean definition is abstract

//        Person person3 = (Person)applicationContext.getBean("person12");
//        System.out.println(person3);


    }

    @Test
    public void test5(){
//person 会在 car 和 book 被创建之后创建
//输出结果:
//        Car  被创建。。。。。。。。
//        Book 被创建..........
//        ........Person 對象被創建了.....
//       Person person =(Person) applicationContext.getBean("person01");
//       System.out.println(person);

//  启动但不获取 会创建 Car
//  执行结果 Car  被创建。。。。。。。。

   //测试多实例 每次获取都会创建一个新的实例
   // 容器启动的时候 不创建对象实例
   Car car = (Car)applicationContext.getBean("car01");
   Car car2 = (Car)applicationContext.getBean("car01");
//        Car  被创建。。。。。。。。
//        Car  被创建。。。。。。。。


        //测试 静态工厂类
        Car car001 = (Car)applicationContext.getBean("car001");
        System.out.println(car001);
        //测试 实例工厂类
        Car car002 = (Car)applicationContext.getBean("car002");
        System.out.println(car002);

        //测试 FactoryBean
        Object objet = applicationContext.getBean("myFactoryBean");
        System.out.println(objet);
        System.out.println("容器要关闭了。。。。。。。。。。");
        //注意多实例的时候 容器关闭 不会调用 destroy 方法，只会等待 GC 回收
        //applicationContext.close();

//     BeanPostProcessor  后置处理器测试结果
//      如果定义了初始化 方法 ，会在初始化前后 调用 后置处理器的 方法,如果没有定义初始化方法，后置处理器也会默认执行

//       postProcessBeforeInitialization
//       postProcessAfterInitialization

//        Book 被创建..........
//        book01 call postProcessBeforeInitialization .......
//        ..........myInit.............
//        book01 call postProcessAfterInitialization .......

    }

}
