package com.briup.ch11;

import java.lang.String;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @Author briup-adam
 * @Date 2023/10/18 下午4:35
 * @Description
 **/

public class FileDemo {
    public static void main(String[] args) {
        //创建file对象的几种格式
        File file = new File("/Users/adam/code/idea-workspace/bttc-code/01code/src/十年.txt");
        File file1 = new File("01code/src/爱情转移.txt");
        File file2 = new File("01code/src", "你的背包.txt");
        File parentFile = new File("01code/src");
        File file3 = new File(parentFile, "红玫瑰.txt");
        //获取文件大小
        System.out.println(file.length());
        System.out.println(file3.length());
        //获取拥有者对于文件的读写执行权限
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        //获取文件的最后修改时间
        System.out.println(file.lastModified());
        //判断文件类型
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());
        //获取目录信息
        System.out.println(parentFile.isDirectory());
        //获取目录下的所有文件的名字
        String[] fileNames = parentFile.list();
        for (String name : fileNames) {
            System.out.println(name);
        }
        //调用递归查找指定目录下的所有文件这个方法
        listFile(parentFile);
        System.out.println("-------------------");
        String[] list = parentFile.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains(".java"))
                    return true;
                else
                    return false;
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
        //文件的创建
//        文件不存在创建成功 文件存在 不会再次创建
        try {
            System.out.println(file1.createNewFile());
            System.out.println(file2.createNewFile());
            System.out.println(file3.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //目录的创建  目录不存在能成功创建  存在创建失败
        File a = new File("a");
        File b = new File("b/c");
        //mkdir只能在父目录已存在的情况下创建目录
        System.out.println(a.mkdir());
//       如果父目录不存在连同父目录一起创建
        System.out.println(b.mkdirs());
        //删除文件和目录
//        文件可以直接删除
        file1.delete();
//        空目录可以直接删除
        a.delete();
        b.delete();
        System.out.println("------------------------");
        //非空目录不能直接删除
        File out = new File("out");
        System.out.println(out.getAbsolutePath());
        System.out.println(out.delete());
        //调用递归删除方法 删除文件
        deleteFile(out);
        //判断文件是否存在
        System.out.println(out.exists());


    }
    //递归查找指定目录下的所有文件
    static  void   listFile(File file){
        System.out.println("parentFile:"+file);
//        获取当前目录下的所有文件
        File[] files = file.listFiles();
        for (File file1 : files) {
            //递归
            if (file1.isDirectory()){
                listFile(file1);
            }else {
                System.out.println("file:"+file1.getName());
            }
        }

    }
    //删除指定目录下的所有文件
    static void  deleteFile(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                deleteFile(file1);
                file1.delete();
            }
            else{
                System.out.println(file1.getAbsolutePath());
                System.out.println(file1.delete());
            }

        }
        file.delete();
    }

}
