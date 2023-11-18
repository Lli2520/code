package com.briup.ch08;

import java.lang.String;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author briup-adam
 * @Date 2023/10/13 上午10:33
 * @Description
 **/

public class SetBasic {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("闫昊");
        set.add("闫昊");
        set.add("赵栋");
        set.add("李鑫");
        set.add("阿木");
        set.add("母志强");
        set.add("抖音小王子");
        //set不允许元素重复
        System.out.println(set.size());//  6
        //存取顺序不一致
        System.out.println(set);
        //set集合的遍历  增强for
        for (Object o : set) {
            System.out.println(o);
        }
        //  set集合的遍历  迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //set集合遍历不能使用普通for
        set.add(null);
        set.add(null);
        System.out.println(set);
        Set set1=new HashSet();
        //hashset判断元素是否可以插入  先看对象的hash值 如果相同再通过equals比较
        set1.add(new Student("李想",19));
        set1.add(new Student("郭琴",19));
        set1.add(new Student("李丹",19));
        set1.add(new Student("谢盼盼",19));
        System.out.println(set1.size());//4
        for (Object o : set1) {
            System.out.println(o);
        }
    }
}
