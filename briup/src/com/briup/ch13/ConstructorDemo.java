package com.briup.ch13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午4:53
 * @Description  通过反射获取构造器
 **/

public class ConstructorDemo {
    public static void main(String[] args) {
        //获取指定类型的字节码对象
        Class<Dog> dogClass = Dog.class;
        //获取所有公共构造器
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("------------------s");
        //获取所有的构造器
        Constructor<?>[] declaredConstructors = dogClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }
        System.out.println("=======获取公共的指定构造器=======");
        //获取公共的指定构造器
        try {
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, char.class, String.class);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //获取指定构造器
        try {
            Constructor<Dog> constructor = dogClass.getDeclaredConstructor(String.class);
            System.out.println(constructor);
            //构造器对象的操作
            //获取修饰符
            int i = constructor.getModifiers();
            System.out.println(i);
            boolean b = Modifier.isPrivate(i);
            System.out.println(b);
        //获取构造器的参数个数
            int count = constructor.getParameterCount();
            System.out.println(count);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> type : parameterTypes) {
                System.out.println(type);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
