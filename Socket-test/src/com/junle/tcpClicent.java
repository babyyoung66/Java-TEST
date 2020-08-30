package com.junle;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class tcpClicent {
    public static void main(String[] args) {
        Socket socket=null;
        OutputStream os=null;
        try {
            InetAddress serverip=InetAddress.getByName("127.0.0.1");
            int port= 9999;
            //创建连接
            socket= new Socket(serverip,port);
            //发送IO流
            os=socket.getOutputStream();
            os.write("hello，你好呀!".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
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
        }
    }
}
