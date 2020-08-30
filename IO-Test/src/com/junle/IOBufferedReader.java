package com.junle;

import java.io.*;

public class IOBufferedReader {
    public static void main(String[] args) {
        try {
            File infile=new File("C:\\Users\\SonofBit\\Desktop\\iotest\\test.txt");
            File outfile=new File("C:/Users/SonofBit/Desktop/iotest/test2.txt");//输出，复制地址

            FileReader fr=new FileReader(infile);
            BufferedReader br=new BufferedReader(fr);

            FileWriter fw=new FileWriter(outfile);
            PrintWriter pw=new PrintWriter(fw);

            while (br.ready()){
                pw.println(br.readLine());//复制到指定位置
                //System.out.println(br.readLine());//打印文本内容到控制台
            }
            pw.close();//执行完毕操作，没有这条无法复制成功
            System.out.println("操作成功");

        }catch (Exception e){
            System.out.println("异常");
        }
    }
}
