package com.briup.ch12;

import java.lang.String;

import java.io.Serializable;

/**
 * @Author briup-adam
 * @Date 2023/10/25 上午11:15
 * @Description
 **/

public class Student  implements Serializable {
    static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
