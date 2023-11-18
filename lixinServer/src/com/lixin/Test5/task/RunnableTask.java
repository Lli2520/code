package com.lixin.Test5.task;

import com.lixin.Test5.System.Constant;

import java.io.*;
import java.net.Socket;

/**
 * ClassName:RunnableTask
 * Description:
 *
 * @Authonr 李欣
 * @Create 2023/11/9/009 15:19
 * @Version 1.0
 */
public class RunnableTask implements Runnable {

    /**
     * 套接字
     */
    private Socket socket;

    /**
     * 可运行任务
     *
     * @param socket 套接字
     */
    public RunnableTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        /**
         * 读请求
         */
        //声明缓冲字符输入流
        BufferedReader br = null;
        //声明缓冲字节输入流
        BufferedInputStream bis = null;
        //声明缓冲字节输出流
        BufferedOutputStream bos = null;

        try {
            //初始化缓冲字符输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取请求资源路径
            String resourcePath = getResourcePath(br);
            //创建文件
            File file = createFile(resourcePath);
            //初始化缓冲字节输出流
            bos = new BufferedOutputStream(socket.getOutputStream());
            //判断文件是否存在 初始化bis 返回响应状态行 响应空行 响应体
            aboutResponseHandle(file, bis, bos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 获取资源路径
     *
     * @param br br
     * @return {@link String}
     */
    public String getResourcePath(BufferedReader br) throws IOException {
        //读取请求行
        String requestLine = br.readLine();
        //分割字符串
        String[] requestLineData = requestLine.split("[ ]");
        //返回资源路径
        return requestLineData[1];
    }

    /**
     * 创建文件
     *
     * @param resourcePath 资源路径
     * @return {@link File}
     */
    public File createFile(String resourcePath) {
        return "/".equals(resourcePath) ?
                new File(Constant.ROOT_PATH + Constant.HOME_PATH) :
                new File(Constant.ROOT_PATH + resourcePath);
    }

    public void aboutResponseHandle(File file, BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
        //判断文件是否存在
        if (file.exists()) {
            //存在
            bis = new BufferedInputStream(new FileInputStream(file));
            //写回响应行
            bos.write(Constant.SUCCESS_RESPONSE_HEAD.getBytes());
        } else {
            //不存在
            bis = new BufferedInputStream(new FileInputStream(new File(Constant.ROOT_PATH + Constant.ERROR_PATH)));
            //写回响应行
            bos.write(Constant.ERROR_RESPONSE_HEAD.getBytes());
        }
        //写回响应报头

        //写回响应空行
        bos.write(Constant.PRINTLN_RESPONSE_HEAD.getBytes());

        //写回响应体
        //创建字节数组
        byte[] data = new byte[1024];
        //创建变量记录读取的长度
        int length;
        //读文件
        while ((length = bis.read(data)) != -1) {
            //写回客户端
            bos.write(data, 0, length);
        }
    }
}