package com.briup.ch08;

import java.lang.String;

import java.util.*;

/**
 * @Author briup-adam
 * @Date 2023/10/13 上午9:13
 * @Description  arrayList和linkedList的对照实验
 **/

public class ListTimeCompare {
    private  static List a=new ArrayList();
    private  static List l=new LinkedList();

    public  static  void insert(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a.add(0,i);
        }
        long end = System.currentTimeMillis();
        System.out.println("arrayList 十万次插入耗时："+(end-start));

         start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            l.add(0,i);
        }
         end = System.currentTimeMillis();
        System.out.println("linkedList 十万次插入耗时："+(end-start));

    }
    public static void find(){
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            a.get(random.nextInt(a.size()));        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList十万次元素查找耗时:"+(end-start));

         start = System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            l.get(random.nextInt(l.size()));        }
         end = System.currentTimeMillis();
        System.out.println("LinkedList十万次元素查找耗时:"+(end-start));
    }
    static  void  demo(){
        ArrayList list = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        insert();
        find();
    }
}
