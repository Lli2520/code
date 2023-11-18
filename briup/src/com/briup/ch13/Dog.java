package com.briup.ch13;

import java.io.Serializable;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午4:53
 * @Description  只供反射 测试使用
 **/

public class Dog implements Serializable {
    static final long serialVersionUID = 42L;
    private  String  name;
    int  age;
    protected  char  gender;
    public  String color;

    static  void  show(String text){
        System.out.println(text);
    }

    public String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

     char getGender() {
        return gender;
    }

    private String getColor() {
        return color;
    }

    public Dog(String name, int age, char gender, String color) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.color = color;
    }

    protected Dog(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

     Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private  Dog(String name) {
        this.name = name;
    }


    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                '}';
    }

    public  Dog(){}
}
