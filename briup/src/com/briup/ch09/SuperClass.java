package com.briup.ch09;

import java.io.IOException;

/**
 * @Author briup-adam
 * @Date 2023/10/18 下午3:08
 * @Description
 **/

public class SuperClass {
    public void  methodA() throws  Exception{

    }
}
class SubClass extends  SuperClass{
    @Override
    public void  methodA()throws IOException {

    }
}
