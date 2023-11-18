package com.briup.ch09;

import java.lang.String;

import java.util.Scanner;

/**
 * @Author briup-adam
 * @Date 2023/10/18 下午2:50
 * @Description
 **/

public class ThrowTest {
    public static  void  login(String name, String password)throws  Exception{
        if(!name.equals("root")){
//            抛出运行时异常  编译器没有任何提示
//            throw  new RuntimeException("用户名不存在");
//            抛出编译时期异常 编译 报错
            throw  new Exception("用户名不存在");
        }else if(!password.equals("briup")){
//            throw new  RuntimeException("用户名密码错误");
            throw new  Exception("用户名密码错误");
        }else {
            System.out.println("登录成功");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        try {
            login(name,password);
            System.out.println("登录结束");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录结束");
        }
        System.out.println("☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺");
    }



}
