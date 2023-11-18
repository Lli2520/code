package com.briup.test7.response;

/**
 * ClassName : ResponseImpl
 * Package : com.briup.test7.response
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 21:13
 * @Version : v1.0
 */

import java.io.BufferedOutputStream;
import java.io.IOException;

public class ResponseImpl implements Response {
    private BufferedOutputStream bos;

    public ResponseImpl(BufferedOutputStream bos) {
        this.bos = bos;
    }

    @Override
    public void setStatus(int statusCode) {
        // 实现设置响应状态码的逻辑
    }

    @Override
    public void setHeader(String key, String value) {
        // 实现设置响应头的逻辑
    }

    @Override
    public void setContentType(String contentType) {
        // 实现设置Content-Type的逻辑
    }

    @Override
    public void write(String content) {
        // 实现写入响应体的逻辑
    }

    @Override
    public void flush() throws IOException {
        // 实现刷新输出流的逻辑
    }

    @Override
    public void close() throws IOException {
        // 实现关闭输出流的逻辑
    }
}

