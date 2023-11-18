package com.briup.ch11;

import java.lang.String;

import java.io.*;

/**
 * @Author briup-adam
 * @Date 2023/10/24 上午8:47
 * @Description
 **/

public class ReadAndWriteData {
    public static void main(String[] args) {
        try {
            writeData("01code/src/data.txt");
            readData("01code/src/data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static   void   readData(String path) throws IOException {
        FileInputStream fis=null;
        DataInputStream dis=null;

        fis=new FileInputStream(path);
        dis=new DataInputStream(fis);

        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        System.out.println(dis.readLong());
        System.out.println(dis.readInt());


        if (dis!=null)
            dis.close();
        if (fis!=null)
            fis.close();


    }
    public static void  writeData(String path) throws IOException {
        FileOutputStream fos=null;
        DataOutputStream dos=null;

        fos=new FileOutputStream(path);
        dos=new DataOutputStream(fos);

        dos.writeByte(0);
        dos.writeShort(1);
        dos.writeInt(2);
        dos.writeLong(3);
        dos.writeChar(4);
        dos.writeBoolean(true);
        dos.writeFloat(2.0f);
        dos.writeDouble(3.0);
        dos.writeUTF("中国");


        if (dos!=null)
            dos.close();
        if(fos!=null)
            fos.close();
    }
}
