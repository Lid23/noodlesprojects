package com.noodles.concurrent.threadpool.service;

/**
 * @program: noodlesprojects
 * @description: RunnerService
 * @author: Eric
 * @create: 2019-05-06 13:46
 **/
public class RunnerService {
    public String printStr(String s) throws Exception{
        Thread thread = Thread.currentThread();
        for(int i = 0; i<1000000000; i++){
            System.out.println(thread.getName() + "-> str = " + s + ",i = " + i);
        }
        return null;
    }
}
