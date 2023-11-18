package com.briup.ch08;

import java.lang.String;

import java.util.Objects;

/**
 * @Author briup-adam
 * @Date 2023/10/12 上午10:39
 * @Description
 **/

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    static int count=0;
    private int hashVal=0;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        hashVal= Objects.hash(name,age);
        return hashVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }


    public Student() {
        count++;
        hashVal=count;

    }

    public Student(String name, int age) {
        this();
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Student o) {

        return  this.age%2==0?-1:1;
    }
}
