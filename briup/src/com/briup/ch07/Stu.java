package com.briup.ch07;


import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午10:39
 * @Description
 **/

public class Stu {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Stu() {

    }

    public Stu(String name, int age) {
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
    public boolean equals(Object o) {
        if (o instanceof Stu) {
            Stu stu = (Stu) o;
            //比较两个学生的名字是否一致 如果相同返回true
            return this.name.equals(stu.name) ? true : false;
        } else {

            return false;
        }

    }

    @Override
    public int hashCode() {
        return age;
    }
}

class StuTest {

    public static void main(String[] args) {
        Stu stu1 = new Stu("闫昊", 20);
        Stu stu2 = new Stu("杨硕", 23);
        Stu stu3 = new Stu("闫昊", 23);
        System.out.println(stu1.equals(stu2));//false
        System.out.println(stu2.equals(stu1));//false
        System.out.println(stu3.equals(stu1));//true
        System.out.println(stu1);
    }
}
