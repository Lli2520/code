package com.briup.ch09;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/18 下午3:44
 * @Description
 **/

public class FinallyTest {
    public static void  methodA(){
        int a;
        try {
            a=10;
        }catch (Exception e){
            a=12;
        }finally {
            a=13;
        }
        System.out.println(a);
    }
    public static int  methodB(){
        int a;
        try {
            a=10;
        }catch (Exception e){
            a=12;
        }finally {
            a=13;
        }
        return  a;
    }

    public static int  methodC(){
        int a;
        try {
            a=10;
            return  a;
        }catch (Exception e){
            a=12;
            return  a;
        }finally {
            a=13;
            return a;
        }

    }
    public static int  methodD(){
        int a;
        try {
            a=10;
            return  a;
        }catch (Exception e){
            a=12;
            return  a;
        }finally {
            a=13;
            System.out.println(a);
            System.out.println("finally code  block");
        }

    }
    public static void main(String[] args) {
        methodA();//13
        System.out.println(methodB());//13
        System.out.println(methodC());//13
        System.out.println(methodD());// 10

    }

}
