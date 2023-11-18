package com.briup.ch07;

import java.lang.String;

import java.util.Arrays;

/**
 * @Author briup-adam
 * @Date 2023/10/12 上午8:40
 * @Description
 **/

public class ClassRoom {
    private Teacher  teacher;
    private Stu[]  stus;

    public ClassRoom(Teacher teacher, Stu[] stus) {
        this.teacher = teacher;
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "teacher=" + teacher +
                ", stus=" + Arrays.toString(stus) +
                '}';
    }

    public static void main(String[] args) {
        Teacher tom = new Teacher("tom", 2000, Gender.MALE);
        Stu [] stus={new Stu("闫昊",18),new Stu("杨硕",20)};
        ClassRoom classRoom = new ClassRoom(tom, stus);
        System.out.println(classRoom);
    }
}
class Teacher{
    private String name;
    private int salary;
    private  Gender gender;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }

    public Teacher(String name, int salary, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }
}