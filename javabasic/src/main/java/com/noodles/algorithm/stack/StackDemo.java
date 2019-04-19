package com.noodles.algorithm.stack;

import java.util.Stack;

/**
 * @program: noodles-parent
 * @description: 栈例子
 * @author: Eric
 * @create: 2019-01-30 14:20
 **/
public class StackDemo {

    public static void main(String args[]){

        /***Java自带的栈*/
        Stack stack = new Stack();


        /***栈，10进制转换为8进制的数*/
        String n = binaryConversion(3467, 8);
        System.out.println("转换后的值：" + n);
    }

    /**
    * @Description: 十进制的数转为r进制的，辗转相除法
    * @Param: [srcNumber, binary]
    * @return: java.lang.String
    * @Author: Eric
    * @Date: 2019/1/30
    */
    public static String binaryConversion(int srcNumber, int r){
        Stack<String>  stack = new Stack();

        /**辗转相除法余数入栈*/
        int n = srcNumber;
        while(n != 0){
            int y = n % r;
            stack.push(String.valueOf(y));
            n = n / r;
        }

        /**出栈得到转换后的值*/
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }



    /** 
    * @Description: 利用栈，实现迷宫的求解，回溯法 
    * @Param: []
    * @return: void 
    * @Author: Eric
    * @Date: 2019/1/30 
    */
    public void maze(){
        //迷宫的定义
        int m = 6;    // 迷宫的实际行
        int n = 8;    //迷宫的实际列
    }
}

