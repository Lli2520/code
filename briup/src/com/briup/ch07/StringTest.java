package com.briup.ch07;


import java.lang.String;

import java.util.Arrays;

/**
 * @Author briup-adam
 * @Date 2023/10/11 上午11:11
 * @Description
 **/

public class StringTest {
    public static void main(String[] args) {
        String s = new String();
        String s1 = new String("");
        String s2 = "";
        System.out.println(s.equals(s2));
        System.out.println(s1.equals(s2));
        char[] c = {'h', 'e', 'l'};
        String s3 = new String(c);
        System.out.println(s3);
        String s4 = "hello";
        String s5 = "hello";
        System.out.println(s4 == s5);//true
        System.out.println(System.identityHashCode(s4));
        System.out.println(System.identityHashCode(s5));
        String s6 = new String("hello");
        System.out.println(s4 == s6);//false
        String s7 = new String("hello").intern();
        System.out.println(s4 == s7);//true
        System.out.println(s7 == s6);//false
        String s8 = "hell" + "o";
        System.out.println(s8 == s4);//true
        String s9 = "hell";
        String s10 = s9 + "o";
        System.out.println(s8 == s10);//false
        //遍历字符串
        for (int i = 0; i < s10.length(); i++) {
            System.out.println(s10.charAt(i));
        }
        char[] chars = s10.toCharArray();
        System.out.println(Arrays.toString(chars));
        String s11="hi my name is lixaing";
        String[] split = s11.split("[ ]");
        System.out.println(Arrays.toString(split));
//        s11.split("\\ ");
        String s12 = s11.substring(11);
        System.out.println(s12);
        String s13 = s11.substring(11, 12);
        System.out.println(s13);
        String s14 = s11.replace(" ", ",");
        System.out.println(s14);
        String s15 = s11.replace(' ', ',');
        System.out.println(s15);
        String s16 = s11.toUpperCase();
        System.out.println(s16);
        String s17 = s16.toLowerCase();
        System.out.println(s17);
    }

}
