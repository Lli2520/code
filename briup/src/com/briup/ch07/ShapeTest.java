package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/8 上午11:34
 * @Description
 **/

public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle("圆形", 5);
        System.out.println(s1.getArea());
    }
}
