package com.briup.test5.task;

import com.briup.test5.system.Constant;
import com.briup.test5.util.LoadArgs;

import java.io.*;
import java.net.Socket;

/**
 * ClassName : RunnableTask
 * Package : com.briup.test5.task
 * Description : TDOO
 *
 * @Author : LENOVO
 * @DateTime : 2023/11/9 15:32
 * 核心任务
 * @Version : v1.0
 */
public class RunnableTask implements Runnable {
    //套接字
    private Socket socket;

    //构造器
    public RunnableTask(Socket socket) {
        this.socket = socket;
    }

    //核心逻辑
    @Override
    public void run() {
        /**
         * 请求行
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
            //获取资源路径
            String resourcePath = getResourcePath(br);
            //创建文件
            File file = createFile(resourcePath);
            //初始化缓冲字节输出流
            bos = new BufferedOutputStream(socket.getOutputStream());
            //关于响应的处理器
            aboutResponseHandle(bis, bos, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
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
     * @throws IOException ioexception
     */
    public String getResourcePath(BufferedReader br) throws IOException {
        //读取请求行
        String requestLine = br.readLine();
        //分割
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
        return Constant.DEFAULT_PATH.equals(resourcePath) ?
                new File(Constant.ROOT_PATH + Constant.HOME_PATH) :
                new File(Constant.ROOT_PATH + resourcePath);
    }

    /**
     * 关于响应处理器
     *
     * @param bis  缓冲字节输入流
     * @param bos  缓冲字节输出流
     * @param file 文件
     */
    public void aboutResponseHandle(BufferedInputStream bis, BufferedOutputStream bos, File file) throws IOException {
        //判断文件是否存在
        if (file.exists()) {
            //存在
            //初始化缓冲字节输入流
            bis = new BufferedInputStream(new FileInputStream(file));
            //写响应行
            bos.write(Constant.SUCCESS_RESPONSE_LINE.getBytes());
        } else {
            //不存在
            //初始化缓冲字节输入流
            bis = new BufferedInputStream(new FileInputStream(new File(LoadArgs.getValue("root_path") + Constant.ERROR_PATH)));
            //写回响应行
            bos.write(Constant.ERROR_RESPONSE_LINE.getBytes());
        }

        //写回响应头（省略）

        //写回响应空行
        bos.write(Constant.PRINTLN_RESPONSE_NULL_LINE.getBytes());

        //写回响应体

        //创建字节数组
        byte[] data = new byte[1024];
        //创建变量记录读取的长度
        int length;
        //读
        while ((length = bis.read(data)) != -1) {
            //写回客户端
            bos.write(data, 0, length);
        }
    }
}