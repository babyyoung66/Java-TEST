package com.junle;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Socket_Test {
    public static void main(String args[]) {
        try {
//
            Socket socket = new Socket("127.0.0.1", 4700);
// 有系统标准设备构造BufferedReader对象
            BufferedReader sin = new BufferedReader(new InputStreamReader(
                    System.in));
// socket对象得到输出流，并构造BPrintWriter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
// socket对象得到输入流，并构造BufferedReader对象
            BufferedReader is = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            String readline;
            readline = sin.readLine();
// bye 停止
            while (!(readline.equals("bye"))) {
// 将从系统标准输入读入的字符串输出到Server
                os.println(readline);
// 刷新，使Server马山接受该字符串
                os.flush();
// 在系统标准输出上打印读入的字符串
                System.out.println("Client(客户端说：...)" + readline);
// 从Server读入一个字符串，并打印到标准输出上
                System.out.println("Sever(服务器端说：....)" + is.readLine());
// 从系统标准输入读入一个字符串
                readline = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error....." + e);
        }
    }

}
