package com.briup.ch13;

import java.lang.reflect.Constructor;
import java.security.acl.Acl;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午5:14
 * @Description 通过反射使用构造器  创建对象
 **/

public class ConstructorNewInstance {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.briup.ch13.Dog");
            //通过字节码对象创建对象  默认调用公共无参构造
            Dog instance = (Dog) aClass.newInstance();
            System.out.println(instance);
            //调用指定一参构造器 创建对象
            Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
            //设置构造器的可见性   也成暴力访问
            constructor.setAccessible(true);
            Object o = constructor.newInstance("二狗");
            System.out.println(o);
            //调用四参构造器 创建 dog对象
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, char.class, String.class);
            declaredConstructor.setAccessible(true);
            Object o1 = declaredConstructor.newInstance("狗蛋", 18, '男', "黑");
            System.out.println(o1);

            //通过字节码对象 获取 类的简单名称和实现的接口的名称
            String name = aClass.getSimpleName();
            System.out.println(name);
            String name1 = aClass.getName();
            System.out.println(name1);
            //获取 该类实现的所有接口
            Class<?>[] interfaces = aClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                System.out.println(anInterface.getSimpleName());
            }
            //获取该类的父类型
            Class<?> superclass = aClass.getSuperclass();
            System.out.println(superclass);
            System.out.println(superclass.toGenericString());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
