package com.junle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream ins=null;
        ByteArrayOutputStream baos=null;


        try {
            serverSocket= new ServerSocket(9999);
            while (true){

                socket=serverSocket.accept();
                //读取客户端的消息
                ins=socket.getInputStream();
                baos=new ByteArrayOutputStream();
                byte[] buffer=new byte[1024];
                int lenth;
                while ((lenth=ins.read(buffer))!=-1){
                    baos.write(buffer,0,lenth);
                }
                System.out.println(baos.toString());
        }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if (baos!=null){
                try {
                    baos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (ins!=null){
                try {
                ins.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null){
                try {
                serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }


        }

    }
}
