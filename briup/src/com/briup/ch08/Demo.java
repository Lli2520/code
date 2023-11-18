package com.briup.ch08;

import java.lang.String;

import java.lang.annotation.*;

/**
 * @interface  定义注解
 * @Documented  表示可以写入到api
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target(value ={ElementType.TYPE,ElementType.METHOD} )
public @interface Demo {
    String name();
    int  version() default  1;
}
