package com.noodles.netty.io;

import java.net.Socket;
import java.util.Date;

/**
 * @program: noodlesprojects
 * @description: IOClient
 * @author: Eric
 * @create: 2019-05-14 10:13
 **/
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while(true){
                    socket.getOutputStream().write((new Date() + ":hello world").getBytes());
                    socket.getOutputStream().flush();

                    Thread.sleep(2000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
