package com.briup.ch07;

/**
 * @Author briup-adam
 * @Date 2023/10/10 下午5:33
 * @Description  java 中的接口可以多继承  类是单继承  继承同样使用extends
 **/

public interface Action  extends  Runnable,Flyable {
    void  sing();
}
