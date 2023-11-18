package com.briup.ch08;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/10/13 上午8:19
 * @Description
 **/

public class ListBasic {
    public static void main(String[] args) {
        //底层数组长度=0 size=0
        List list = new ArrayList();
        //底层数组长度=10 size=1
        // 添加元素到集合指定位置 添加元素的时候要挨着添加 保证索引是连续的
        list.add(0, "闫昊");
        list.add(1, "赵栋");
        list.add(2, "李想");
        //如果指定位置上有值  原来的值往后移
        list.add(2, "郭琴");
        list.add(2, "杨欣瑶");
        System.out.println(list.size());//5
        list.set(2, "谢盼盼");
        System.out.println(list.size());//5
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.remove(list.get(i));
        }
        System.out.println("list = " + list);
        for (Object o : list) {
            list.remove(o);
        }
        //list 特有的遍历方式  普通for
        for (int i = 0; i < list.size(); i++) {
            //可以获取指定索引上的值
            Object o = list.get(i);
            System.out.println(o);
        }
        //将集合中所有元素放到指定位置
        list.addAll(2, list);
        System.out.println(list);
        //移除指定位置上的值
        list.remove(0);
        int index = list.indexOf("赵栋");
        System.out.println(index);
        index = list.lastIndexOf("赵栋");
        System.out.println(index);
        System.out.println(list);
        //[formIndex,toIndex)
        List subList = list.subList(2, 6);
        System.out.println(subList);


    }
}
