package com.junle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Test {
    public static void main(String args[]) {
        try {
            ServerSocket server = null;
            try {
// 创建一个ServerSocket在端口4700监听客户端的请求
                server = new ServerSocket(4700);
            } catch (Exception e) {
                System.out.println("can not listen to(不能监听...)" + e);
            }
            Socket socket = null;
            try {
// 用accept（）阻塞等待客户的请求，有客户请求到来则产生一个Socket对象并继续执行
                socket = server.accept();
            } catch (Exception e) {
                System.out.println("Error(出错啦..)" + e);
            }
            String line;
// 由Socket对象得到输入流，并构造BufferedReader对象
            BufferedReader is = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
// 由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
// 有系统标准输入设备构造BufferedReader对象
            BufferedReader sin = new BufferedReader(new InputStreamReader(
                    System.in));
            System.out.println("Client(客户端...)" + is.readLine());
            line = sin.readLine();
// 如果为bye 停止循环
            while ((!line.equals("bye"))) {
// 将从系统标准输入读入的字符串输出到Server
                os.println(line);
// 刷新，使server马上接受该字符串
                os.flush();
// 从Server读入一个字符串，并打印子啊标准输出上
                System.out.println("Server(服务器端发送的内容.....)" + line);
// 在系统标准 输出上打印读入的字符串
                System.out.println("Client(客户端发送的内容.....)" + is.readLine());
// 从系统标准输入读入一个字符串
                line = sin.readLine();
            }
// 关闭。。。
            os.close();
            is.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            System.out.println("Error(出错啦..)" + e);
        }
    }

}
