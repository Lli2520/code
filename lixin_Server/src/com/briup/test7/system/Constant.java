package com.briup.test7.system;

/**
 * ClassName : Constant
 * Package : com.briup.test7.system
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 21:17
 * @Version : v1.0
 */
public class Constant {
    /**
     * 线程数
     */
    public static final int THREAD_COUNT = 10;

    /**
     * 端口
     */
    public static final int PORT = 9999;
    /**
     * 根路径
     */
    public static final String ROOT_PATH = "E:\\大三\\resource";

    /**
     * 首页路径
     */
    public static final String HOME_PATH = "/index/index.html";

    /**
     * 错误路径
     */
    public static final String ERROR_PATH = "/error/error.html";

    /**
     * 默认路径
     */
    public static final String DEFAULT_PATH = "/";

    /**
     * 成功响应行
     */
    public static final String SUCCESS_RESPONSE_LINE = "HTTP/1.1 200 OK \r\n";

    /**
     * 错误响应行
     */
    public static final String ERROR_RESPONSE_LINE = "HTTP/1.1 404 NOT FOUND \r\n";

    /**
     * 换行 响应空行
     */
    public static final String PRINTLN_RESPONSE_NULL_LINE = "\r\n";
}
