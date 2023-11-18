package com.briup.ch13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午5:46
 * @Description 使用反射调用方法
 **/

public class InvokeMethod {
    public static void main(String[] args) {
        Class<Dog> dogClass = Dog.class;
        try {
            Constructor<Dog> constructor = dogClass.getDeclaredConstructor(String.class, int.class, char.class, String.class);
            Dog dog = constructor.newInstance("来福", 5, '男', "白");
            System.out.println(dog);
            //获取方法
            Method getName = dogClass.getDeclaredMethod("getName");
            //调用方法  并获得返回值
            Object o = getName.invoke(dog);
            System.out.println(o);
//            String name = dog.getName();
//            System.out.println(name);
            Method getColor = dogClass.getDeclaredMethod("getColor");
            getColor.setAccessible(true);
            Object o1 = getColor.invoke(dog);
            System.out.println(o1);
            //获取静态方法
            Method show = dogClass.getDeclaredMethod("show", String.class);
            //设置可见性
            show.setAccessible(true);
            Object o2 = show.invoke(dog, "杨柳岸 晓风残月");
            System.out.println(o2);//null

            //静态方法 可以不需要 对象调用
            Object o3 = show.invoke(null, "执手相看泪眼  尽无语凝噎");
            System.out.println(o3);//null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
