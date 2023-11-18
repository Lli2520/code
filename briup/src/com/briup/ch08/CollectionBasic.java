package com.briup.ch08;


import java.lang.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author briup-adam
 * @Date 2023/10/12 上午10:02
 * @Description
 **/

public class CollectionBasic {
    static Collection c = new ArrayList();

    public static void main(String[] args) {
        System.out.println(c);
        //向集合中添加元素 可以是任意的引用数据类型
        c.add("tom");
        c.add(new Integer(10));
        c.add(new Long(10l));
        //自动装箱  40.5 double--->Double
        c.add(40.5);

        //从集合取元素
        for (Object o : c) {
            System.out.println(o);
            System.out.println(o.getClass());
        }
//        判断集合长度是否为0
        System.out.println(c.isEmpty());
//       集合的元素个数
        System.out.println(c.size());
//        是否包含指定元素
        System.out.println(c.contains("tom"));
//        将集合转成数组
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));
        int[] a = {1, 2, 3, 4, 5};
//        将数组转集合
        Arrays.asList(a);
        Arrays.asList(1, 2, 3, 4, 5, 7, 8);
//        清空集合
        c.clear();
        System.out.println(c.isEmpty());
        Collection c1 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            c1.add(i);
        }
        c.add(c1);
        System.out.println(c);
        c.addAll(c1);
        System.out.println(c);
        //判断c1是否是c的子集
        System.out.println(c.containsAll(c1));
        //保留两个集合相同的元素
        c.retainAll(c1);
        //移除元素c1
        System.out.println(c.remove(c1));
        //移除c1所包含的所有元素
        System.out.println(c.removeAll(c1));
//        创建集合专门存放学生对象
        Collection stus = new ArrayList();
        stus.add(new Student("闫昊", 18));
        stus.add(new Student("杨硕", 20));
        stus.add(new Student("阿木", 21));
        stus.add(new Student("郭雅鑫", 20));
        System.out.println(stus);
        System.out.println(stus.remove(new Student("闫昊", 18)));
        //集合转数组遍历
        Object[] objects = stus.toArray();
        System.out.println("-------------普通for遍历数组---------------");
//        普通for遍历数组
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
//        增强for遍历数组
        System.out.println("-------------------增强for遍历数组------------");
        for (Object o : objects) {
            System.out.println(o);
        }
//        工具类打印数组
        System.out.println("-------------工具类打印数组-----------");
        System.out.println(Arrays.toString(objects));
        System.out.println("-------------迭代器---------------");
//        通过迭代器
        Iterator iterator = stus.iterator();
//        通过迭代器遍历  先判断是否有更多元素
        while (iterator.hasNext()) {
//            获取下一个元素
            System.out.println(iterator.next());
        }

        System.out.println("------------增强for遍历集合----------");
        for (Object o : stus) {
            System.out.println(o);
        }

    }
}
