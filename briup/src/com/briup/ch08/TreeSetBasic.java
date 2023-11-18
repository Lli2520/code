package com.briup.ch08;

import java.lang.String;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author briup-adam
 * @Date 2023/10/13 上午11:04
 * @Description  比较器排序 优先于 自然排序
 **/

public class TreeSetBasic {
    public static void main(String[] args) {
        //自然排序  让元素自身具备比较性
        TreeSet set=new TreeSet();
        set.add(5);
        set.add(1);
        set.add(3);
        set.add(7);
        System.out.println(set);
        set.clear();
        set.add(new Student("谢盼盼",9));
        set.add(new Student("李想",18));
        set.add(new Student("李丹",1));
        set.add(new Student("郭琴",4));
        set.add(new Student("阿木",14));

        System.out.println(set);
        //创建比较器对象
//        Comparator cmp=new ComparatorImpl();
        Comparator<Student> cmp=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()%2==0?1:-1;
            }
        };
         cmp=(s1,s2)->{
             return  s1.getAge()%2==0?1:-1;
         };
//        将比较器赋值给treeset
        TreeSet set1 = new TreeSet(cmp);
        set1.addAll(set);
        System.out.println(set1.size());//5
        for (Object o : set1) {
            System.out.println(o);
        }
    }
}
class ComparatorImpl implements  Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {

        return o1.getAge()%2==0?1:-1;
    }
}
