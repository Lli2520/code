package com.briup.test7.response;

import java.io.IOException;

/**
 * ClassName : Response
 * Package : com.briup.test7.response
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 21:12
 * @Version : v1.0
 */
public interface Response {
    void setStatus(int statusCode);

    void setHeader(String key, String value);

    void setContentType(String contentType);

    void write(String content);

    void flush() throws IOException;

    void close() throws IOException;
}
