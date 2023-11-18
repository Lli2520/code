package com.briup.ch08;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午10:35
 * @Description
 **/

public class Circle<T, E> {
    private T x;
    private T y;
    private E radius;

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }

    public Circle() {
    }

    public Circle(T x, T y, E radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public E getRadius() {
        return radius;
    }

    public void setRadius(E radius) {
        this.radius = radius;
    }
}

class CircleTest {
    public static void main(String[] args) {
        Circle<Integer, Double> c1 = new Circle<>(2, 3, 2.5);
        int x = c1.getX();
        double r = c1.getRadius();
        System.out.println("x: " + x + " radius: " + r);
        System.out.println("------------------");
//2.实例化具体类对象，2种泛型设置为Double和Integer
        Circle<Double, Integer> c2 = new Circle<>(2.0, 3.0, 2);
        double x2 = c2.getX();
        int r2 = c2.getRadius();
        System.out.println("x2: " + x2 + " r2: " + r2);
    }
}