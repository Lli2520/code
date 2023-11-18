package com.briup.ch08;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午10:40
 * @Description
 **/

public interface Action<T> {
     void  print(T t);
     T getValue();

    public static void main(String[] args) {
        Action<Integer> a=new ActionImpl<>();
        Action<String> action =new Action<String>() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }

            @Override
            public String getValue() {
                return "你好";
            }
        };
        a.print(10);
        action.print("ok  hello");
        ActionImpl<Integer> ac = new ActionImpl<>();
        ac.show("oo");

    }
}
class  ActionImpl<T>  implements  Action<T>{

    @Override
    public void print(T t) {
        System.out.println(t);
    }

    @Override
    public T getValue() {
        return null;
    }
    public static <E>   void show(E e){
        System.out.println(e.getClass());
    }
}