package com.briup.test7.request.impl;

import com.briup.test7.request.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName : RequesImpl
 * Package : com.briup.test7.request.impl
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/13 21:16
 * @Version : v1.0
 */
public class RequestImpl implements Request {
    private Socket socket;

    private String requestMethod;

    private String requestResourcePath;

    private String httpVersion;

    private Map<String, String> header;

    private Map<String, String> requestBody;

    private BufferedReader br;

    private String urlArgs;

    public RequestImpl(Socket socket) {
        this.socket = socket;
        header = new HashMap<String, String>();
        requestBody = new HashMap<String, String>();
        loadRequest();
    }

    /**
     * 加载请求
     */
    public void loadRequest() {
        try {
            //读取请求
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取请求行
            requestLineHandler(br.readLine());

            //处理请求头
            requestHeaderHandler();

            //处理请求体
            requestBodyHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 请求行处理程序  GET / HTTP/1.1
     *
     * @param requestLine 请求行
     */
    public void requestLineHandler(String requestLine) {
        //分割字符串
        String[] split = requestLine.split("[ ]");
        requestMethod = split[0];
        if (split[1].contains("?")) {
            //包含 有参数  /login.html?username=tom&passwd=123
            //按照?进行分割字符串
            String[] strings = split[1].split("[?]");
            if (strings.length == 2) {
                requestResourcePath = strings[0];
                urlArgs = strings[1];
            }
        } else {
            //不包含 无参数
            requestResourcePath = split[1];
        }
        httpVersion = split[2];
    }

    /**
     * 请求标头处理程序
     */
    public void requestHeaderHandler() throws IOException {
        /**
         * 读取到消息报头
         */
        String line;
        while (!"".equals(line = br.readLine())) {
            // key: value
            //分割字符串
            String[] split = line.split(": ");
            if (split.length == 2) {
                header.put(split[0], split[1]);
            }
        }
    }

    /**
     * 请求正文处理程序
     */
    public void requestBodyHandler() throws IOException {
        if (Objects.isNull(urlArgs)) {
            if (br.ready()) {
                //创建字符数组
                char[] chars = new char[1024];
                //记录读取的长度
                int length = br.read(chars);
                //创建String   username=tom&passwd=123
                urlArgs = new String(chars, 0, length);
                //根据&分割
                String[] split = urlArgs.split("[&]");
                //遍历
                for (String bodyData : split) {
                    String[] strings = bodyData.split("[=]");
                    requestBody.put(strings[0], strings[1]);
                }
            }
        } else {
            String[] split = urlArgs.split("[&]");
            //遍历
            for (String bodyData : split) {
                String[] strings = bodyData.split("[=]");
                requestBody.put(strings[0], strings[1]);
            }
        }

    }

    @Override
    public String getRequestMethod() {
        return requestMethod;
    }

    @Override
    public String getRequestResourcePath() {
        return requestResourcePath;
    }

    @Override
    public String getHttpVersion() {
        return httpVersion;
    }

    @Override
    public Map<String, String> getHeader() {
        return header;
    }

    @Override
    public Map<String, String> getBody() {
        return requestBody;
    }

    @Override
    public BufferedReader getBufferedReader() {
        return br;
    }
}
