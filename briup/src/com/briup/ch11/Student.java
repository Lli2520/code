package com.briup.ch11;

import java.lang.String;

import java.io.Serializable;

/**
 * @Author briup-adam
 * @Date 2023/10/23 上午11:19
 * @Description  对象要想序列化 对应的类必须实现可序列化接口
 * @see  Serializable
 *
 **/

public class Student implements Serializable {
    //序列化版本号
    static final long serialVersionUID= -2704430391940309448l;
    private String name ;
    private  int age;
    //transient 修饰属性  被修饰的属性不参与序列化
   transient private String password;
   private String  gender;
   private  String  address;

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student(String name, int age, String password, String gender, String address) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.gender = gender;
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String name, int age, String password, String gender) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
        System.out.println("这是stu的无参构造器");
    }

    public Student(String name, int age) {
        System.out.println("这是stu的两参构造器");
        this.name = name;
        this.age = age;
    }
}
