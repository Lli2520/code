package com.briup.ch08;

import java.lang.String;

import java.util.LinkedHashSet;

/**
 * @Author briup-adam
 * @Date 2023/10/16 下午2:31
 * @Description
 **/

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        //set  无序  不可重复 无索引
        //LinkedHashSet  有序  不可重复 允许null
        LinkedHashSet set=new LinkedHashSet();
        set.add("闫昊");
        set.add("闫昊");
        set.add("杨硕");
        set.add("杨欣瑶");
        set.add("杨嘉俊");
        set.add(null);
        System.out.println(set);
    }
}
