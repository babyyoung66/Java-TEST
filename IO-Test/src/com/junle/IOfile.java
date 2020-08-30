package com.junle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOfile {

    public static void main(String[] args) {
        try {
            File infile=new File("C:\\Users\\SonofBit\\Desktop\\iotest\\test.txt");//读取输入地址
            File outfile=new File("C:/Users/SonofBit/Desktop/iotest/test1.txt");//输出，复制地址

            FileInputStream fis=new FileInputStream(infile);//将文件放入输入流
            FileOutputStream fos=new FileOutputStream(outfile);//将输出地址加入输出流

            int length=fis.available();//获取输入流长度
            for (int i=0;i<length;i++){
                fos.write((char)fis.read());
                //System.out.println("复制成功 ");
            }
            fos.close();
        }catch (Exception e){
            System.out.println("复制异常......");
        }finally {

        }
    }
}
