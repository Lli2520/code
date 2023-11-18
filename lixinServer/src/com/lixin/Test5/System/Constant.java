package com.lixin.Test5.System;

/**
 * ClassName:Constant
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:18
 * @Version 1.0
 */
public class Constant {
    /**
     * 端口号
     */
    public static final int PORT = 9999;

    /**
     * 线程数
     */
    public static final int THREAD_COUNT = 10;

    /**
     * 根路径
     */
    public static final String ROOT_PATH = "E:/resource";

    /**
     * 首页路径
     */
    public static final String HOME_PATH = "/index.html";

    /**
     * 错误路径
     */
    public static final String ERROR_PATH = "/error.html";

    /**
     * 成功响应头
     */
    public static final String SUCCESS_RESPONSE_HEAD = "HTTP/1.1 200 OK \r\n";

    /**
     * 错误响应头
     */
    public static final String ERROR_RESPONSE_HEAD = "HTTP/1.1 404 NOT FOUND \r\n";

    /**
     * 空行响应头
     */
    public static final String PRINTLN_RESPONSE_HEAD = "\r\n";
}