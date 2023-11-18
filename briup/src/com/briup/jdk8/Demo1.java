package com.briup.jdk8;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(1+3);

        List<Integer> list = Arrays.asList(1, 2, 3, 45, 6, 54, 25, 32, 358);
        list.forEach((i)->System.out.println(i));
        list.forEach(System.out::println);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
