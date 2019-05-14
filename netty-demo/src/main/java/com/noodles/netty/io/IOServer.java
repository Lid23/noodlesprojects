package com.noodles.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: noodlesprojects
 * @description: IOServer
 * @author: Eric
 * @create: 2019-05-14 09:26
 **/
public class IOServer {

    /**
    * @Description: 创建ServerSocket监听8000端口，然后创建线程不断调用阻塞方法
     * accept()获取新的连接，当获取到新的连接给没调连接创建新的线程负责从该连接
     * 以字节流的方式中读取数据
    * @Param:
    * @return:
    * @Author: Eric
    * @Date: 2019/5/14
    */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);

        //接收新连接线程
        new Thread(() -> {
            //(1)阻塞方法获取新的连接
            try {
                Socket socket = serverSocket.accept();

                //(2)每一个新的连接都创建一个线程，负责读取数据
                new Thread(() -> {
                    byte[] data = new byte[1024];
                    try {
                        InputStream inputStream = socket.getInputStream();
                        while(true){
                            int len;
                            //(3)按照字节流方式读取数据
                            while((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data, 0, len));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
