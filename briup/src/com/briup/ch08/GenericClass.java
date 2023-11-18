package com.briup.ch08;

import java.lang.String;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午10:58
 * @Description
 **/

public class GenericClass {

    public void methodA(Collection<String> c) {

    }

    public void methodB(Collection<?> c) {
        c.add(null);

    }

    public void methodC(Collection<? extends Number> c) {

    }

    public void methodD(Collection<? super Integer> c) {

    }

    public static void main(String[] args) {
        GenericClass gc = new GenericClass();
        gc.methodB(new ArrayList<Integer>());
        gc.methodC(new ArrayList<Number>());
        gc.methodC(new ArrayList<Double>());
        gc.methodC(new ArrayList<Byte>());
        gc.methodC(new ArrayList<BigDecimal>());

        gc.methodD(new ArrayList<Number>());
        gc.methodD(new ArrayList<Object>());
        gc.methodD(new ArrayList<Integer>());
    }
}
