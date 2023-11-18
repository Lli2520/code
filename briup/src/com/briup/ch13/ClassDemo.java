package com.briup.ch13;

import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午4:40
 * @Description  获取字节码对象
 **/

public class ClassDemo {
    public static void main(String[] args) {
        //第一种  使用字面常量  数据类型.class
        Class<Integer> aClass = int.class;
        Class<int[]> bClass = int[].class;
        Class<List> cClass = List.class;
        Class<String> dClass = String.class;
        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println(cClass);
        System.out.println(dClass);
        //第二种是使用 Class 类中的静态方法  forName() 仅适用引用数据类型
        try {
            //不适用基本数据类型
//            Class<?> eClass = Class.forName("int");
            Class<?> fClass = Class.forName("[I");
            Class<?> gClass = Class.forName("java.util.List");
            Class<?> hClass = Class.forName("java.lang.String");

//            System.out.println(eClass);
            System.out.println(fClass);
            System.out.println(gClass);
            System.out.println(hClass);

            System.out.println(bClass==fClass);//true
            System.out.println(aClass==int.class);//true
            System.out.println(cClass==gClass);//true

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第三种  使用Object 类中的getClass(); 只适用 数组 和类类型
        Class<? extends String> iClass = "s".getClass();
        Class<? extends int[]> jClass = new int[5].getClass();

        System.out.println(iClass);
        System.out.println(jClass);
        //没有办法从外部创建 字节码对象
        // 只有在类型加载的时候 jvm主动创建  通过defineClass()
        //一个类型在一个jvm中只加载一次  也就说  一个字节码对象只创建一个
//        Class aClass1 = new Class();


        /**
         * OOAD
         * 单例模式
         * 保证该类型的实例  最多只有一个
         */
    }
}
