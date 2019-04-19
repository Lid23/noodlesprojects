package com.noodles.Sockets;


import com.noodles.Sockets.beans.Request;
import com.noodles.Sockets.beans.Response;
import org.jsoup.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: HttpServer
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/21 13:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/21 13:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HttpServer {
    private static final int SERVER_PORT = 9000;
    //public static final String WEB_ROOT = System.getProperty( "user.dir" ) + File.separator + "webroot";
    public static final String WEB_ROOT = "d:/temp/sockethtmls";
    private static final String SHUTDOWN_COMMAND = "/QUIT";

    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket( SERVER_PORT );
        } catch (Exception e) {
            e.printStackTrace();
            System.exit( 1 );
        }

        while (true){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();
                if(SHUTDOWN_COMMAND .equals( request.getUri())){
                    break;
                }

                Response response = new Response( output );
                response.setRequest( request );
                response.sendStaticResource();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
