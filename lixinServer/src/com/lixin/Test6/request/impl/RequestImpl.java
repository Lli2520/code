package com.lixin.Test6.request.impl;

import com.lixin.Test6.system.Constant;
import com.lixin.Test6.request.Request;
import com.sun.corba.se.impl.corba.RequestImpl;

import java.io.*;
import java.net.Socket;

/**
 * @Classname RunnableTask
 * @Description 抽离任务
 * @Date 2023/11/13 8:11
 * @Created by qinyc
 * @Version v1.0.0
 */
public class RunnableTask implements Runnable {
    private Socket socket;

    public RunnableTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        /**
         * 请求
         */
        Request request = new RequestImpl(socket);
        System.out.println("请求方式：" + request.getRequestMethod());
        System.out.println("请求资源路径" + request.getRequestResourcePath());
        System.out.println("http协议版本" + request.getHttpVersion());
        System.out.println("请求头" + request.getHeader());
        System.out.println("请求体" + request.getBody());

        System.out.println("===============================================");

        /**
         * 响应
         */
        //声明缓冲字节输入流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        //创建文件
        File file = createFile(request.getRequestResourcePath());

        try {
            bos = new BufferedOutputStream(socket.getOutputStream());
            //响应处理
            responseHandler(file, bis, bos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }

                if (bis != null) {
                    bis.close();
                }

                if (request.getBufferedReader() != null) {
                    request.getBufferedReader().close();
                }

                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 创建文件
     *
     * @param requestResourcePath 请求资源路径
     * @return {@link File}
     */
    public File createFile(String requestResourcePath) {
        return Constant.DEFAULT_PATH.equals(requestResourcePath) ?
                new File(Constant.ROOT_PATH + Constant.HOME_PATH) :
                new File(Constant.ROOT_PATH + requestResourcePath);
    }

    public void responseHandler(File file, BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
        //判断文件是否存在
        if (file.exists()) {
            //存在
            bos.write(Constant.SUCCESS_RESPONSE_LINE.getBytes());
        } else {
            //不存在
            file = new File(Constant.ROOT_PATH + Constant.ERROR_PATH);
            bos.write(Constant.ERROR_RESPONSE_LINE.getBytes());
        }

        bis = new BufferedInputStream(new FileInputStream(file));

        //解析出文件的后缀名
        String suffix = getSuffix(file);
        String type = "Content-Type: " + LoadArgs.getValue(suffix) + Constant.PRINTLN_RESPONSE_NULL_LINE;
        bos.write(type.getBytes());

        //响应空行
        bos.write(Constant.PRINTLN_RESPONSE_NULL_LINE.getBytes());

        //响应体

        byte[] data = new byte[1024];

        int length;

        while ((length = bis.read(data)) != -1) {
            bos.write(data, 0, length);
        }

    }

    public String getSuffix(File file) {
        //获取文件名
        String name = file.getName();
        /**
         * 1.txt
         * 1.txt.txt.txt.jpg
         * rtsyhd
         */
        //按照.进行分割字符串
        String[] split = name.split("[.]");
        String suffix;
        if (split.length < 2) {
            suffix = split[0];
        } else if (split.length == 2) {
            suffix = split[1];
        } else {
            suffix = split[split.length - 1];
        }

        return suffix;
    }
}