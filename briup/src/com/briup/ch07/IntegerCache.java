package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午10:23
 * @Description  常量池优化  常量池缓冲
 **/

public class IntegerCache {
    public static void main(String[] args) {
        Integer i1=new Integer(1);
        Integer i2=new Integer(1);
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
        System.out.println(i1==i2);//false
        i1=1;
        i2=1;
        System.out.println(i1==i2);//true
        i1=128;
        i2=128;
        System.out.println(i1==i2);//false
    }
}
