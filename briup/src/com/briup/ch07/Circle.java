package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/8 上午11:30
 * @Description
 **/

public class Circle extends Shape {
    private int r;

    public Circle(String name, int r) {
        super(name);
        this.r = r;
    }

    public Circle() {
    }

    public Circle(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}
