package com.noodles.concurrent.threadpool.runners;

import java.util.concurrent.Callable;

import com.noodles.concurrent.threadpool.service.RunnerService;

/**
 * 文件名：RunnerDemo.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年7月17日下午4:37:23
 */
public class CallableDemo implements Callable<String> {

    /**
     * 线程私有属性，创建线程时创建
     */
    private String str;

    private RunnerService runnerService;

    public CallableDemo(RunnerService runnerService, String str) {
    	this.runnerService = runnerService;
        this.str = str;
    }

    @Override
    public String call() throws Exception {
        //System.out.println("thread:" + Thread.currentThread().getName() + ",str:" + str);
        try {
            runnerService.printStr(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
