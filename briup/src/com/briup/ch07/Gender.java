package com.briup.ch07;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/12 上午8:10
 * @Description 枚举类型要解决的事一个类型只能创建固定个数的对象、
 * 枚举本质上就是类 不能有子类
 * 所有的枚举类型直接继承java.lang.Enum  不能再继承其他类型
 * 枚举类型可以实现接口
 * 枚举类型可以写抽象方法   枚举元素创建时要通过匿名内部类重写
 **/

public enum Gender implements IJumpAble {

    //枚举元素  实际上就是枚举类型的对象 且是公共静态常量
//    枚举元素 必须写在枚举类型的第一行 如果枚举元素之后没有任何代码 枚举元素声明完可以不写分号  但是如果后面还有代码 必须写分号
    MALE{
        @Override
        public void jump() {

        }
    }, FEMALE("女人"){
        @Override
        public void jump() {

        }
    };

    //    枚举类型可以定义属性
    private String chineseName;

    //枚举类型可以定义成员方法
    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    Gender(String chineseName) {
        this.chineseName = chineseName;
    }

    //默认提供的枚举类型的构造器是私有的
    //枚举类型的构造器只能是私有的
    Gender() {

    }

    //枚举类型可以有静态方法
    public static void main(String[] args) {

    }


}

class GenderTest {
    public static void main(String[] args) {
//        枚举类型不能通过new关键字实例化
//        枚举元素可以直接通过类名调用
        Gender g = Gender.MALE;
        g.setChineseName("男");
        System.out.println(g.getChineseName());
//        通过名字获取枚举对象
        Gender g1 = Gender.valueOf("MALE");
        System.out.println(g1.getChineseName());
        System.out.println(g == g1);
    }
}
