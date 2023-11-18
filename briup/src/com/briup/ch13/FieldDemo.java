package com.briup.ch13;

import java.lang.reflect.Field;

/**
 * @Author briup-adam
 * @Date 2023/10/30 下午6:01
 * @Description 通过反射获取属性
 **/

public class FieldDemo {
    public static void main(String[] args) {
        Class<Dog> dogClass = Dog.class;

        //获取所有公共属性
        Field[] fields = dogClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------------");
        //获取所有属性
        Field[] declaredFields = dogClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        try {
            //获取指定的公共属性
            Field color = dogClass.getField("color");
            System.out.println("color:" + color);
            //获取指定属性
            Field name = dogClass.getDeclaredField("name");
            System.out.println("name:" + name);
            //获取属性的类型
            Class<?> type = name.getType();
            System.out.println(type);

            System.out.println("===============================");
            //通过反射获取对象
            Dog dog = dogClass.newInstance();
            System.out.println(dog);
            //设置私有属性的科技性
            name.setAccessible(true);
            //给属性赋值以及取值
            //赋值
            color.set(dog, "黑白灰渐变");
            name.set(dog, "精神小狗狗");
            System.out.println(dog);
            //取值
            Object o = color.get(dog);
            System.out.println(o);
            Object o1 = name.get(dog);
            System.out.println(o1);
            //静态属性的访问和赋值
            Field uid = dogClass.getDeclaredField("serialVersionUID");
            Object o2 = uid.get(null);
            System.out.println(o2);
            Object o3 = uid.get(dog);
            System.out.println(o3);
            uid.setAccessible(true);
            uid.set(null, 45L);

            o3 = uid.get(dog);
            System.out.println(o3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
