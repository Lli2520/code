package com.briup.test6.request;

import java.io.BufferedReader;
import java.util.Map;

/**
 * ClassName : Request
 * Package : com.briup.test6.request
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 8:15
 * @Version : v1.0
 */
public interface Request {
    /**
     * 获取 请求方法
     *
     * @return {@link String}
     */
    String getRequestMethod();

    /**
     * 获取请求资源路径
     *
     * @return {@link String}
     */
    String getRequestResourcePath();

    /**
     * 获取 HTTP 版本
     *
     * @return {@link String}
     */
    String getHttpVersion();

    /**
     * GET 标头
     *
     * @return {@link Map}<{@link String},{@link String}>
     */
    Map<String, String> getHeader();


    /**
     * 获取正文
     *
     * @return {@link Map}<{@link String},{@link String}>
     */
    Map<String, String> getBody();

    /**
     * 获取缓冲读取器
     *
     * @return {@link BufferedReader}
     */
    BufferedReader getBufferedReader();

}