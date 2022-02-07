package com.sp.std.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
    private String id;
    private Integer age;
    private String name ="xiaoming001";
    private String  email;
    private String address;

    private Car car;
    private List<Book> books;
    private Map<String,Object> maps;
    private Properties properties;



    //属性的赋值 是依靠 setter 方法来映射的
    public Person() {
        System.out.println("........Person 對象被創建了.....");
    }


    public Person(Car car){
        System.out.println("。。。。。。。。有参构造器被执行。。。。。。。。。。。。。");
        this.car = car;
    }
    //有参构造器 用于测试 构造器创建对象
    public Person(String id,Integer age,String name) {
        System.out.println("........Person 有参构造器對象被創建了.....");
        this.id = id;
        this.age = age;
        this.name = name;
    }


    //有参构造器 用于测试 构造器创建对象，重载了构造器
    public Person(String id,String email,String name) {
        System.out.println("........Person 有参构造器對象被創建了.....");
        this.id = id;
        this.email = email;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
