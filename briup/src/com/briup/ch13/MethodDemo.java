package com.briup.ch13;

import java.lang.reflect.Method;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午5:36
 * @Description 通过反射 获取指定类中的方法
 **/

public class MethodDemo {
    public static void main(String[] args) {
        Class<? extends Dog> dogClass = new Dog().getClass();
        //获取所有公共方法  包含继承到的
        Method[] methods = dogClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===========================");
        //获取所有方法   不包含继承到的
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
        System.out.println("+++++++++++++++++++++++++++++++");
        try {
            //获取指定的公共方法
            Method wait = dogClass.getMethod("wait", long.class);
            System.out.println(wait);
            int modifiers = wait.getModifiers();
            System.out.println(modifiers);
            //获取方法的返回值类型
            Class<?> type = wait.getReturnType();
            System.out.println(type);
            //获取指定的所有方法
            Method getName = dogClass.getDeclaredMethod("getName");
            Class<?> returnType = getName.getReturnType();
            System.out.println(returnType);
            System.out.println(getName);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
