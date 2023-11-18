package com.briup.ch13;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午3:36
 * @Description 类加载
 **/

public class ClassLoaderDemo {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //获取系统类加载器的父 类加载器  拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        //获取启动类加载器
        ClassLoader classLoader = parent.getParent();
        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(classLoader);
    }
}
