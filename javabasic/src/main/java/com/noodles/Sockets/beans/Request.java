package com.noodles.Sockets.beans;

import noodles.Sockets.common.TestUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: Request
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/21 13:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/21 13:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Request {
    private final static int BUFFER_SIZE = 1024;
    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse(){
        StringBuffer request = new StringBuffer();
        int readLength;
        byte[] buffer = new byte[BUFFER_SIZE];

        try {
            readLength = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            readLength = -1;
        }

        for (int i = 0; i < readLength; i++){
            request.append( (char)buffer[i] );
        }
        System.out.println(request.toString());

        /**对请求参数dosomething*/
        TestUtil.doSomething(request.toString());

        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf('?', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

    public String getUri() {
        return uri;
    }

}
