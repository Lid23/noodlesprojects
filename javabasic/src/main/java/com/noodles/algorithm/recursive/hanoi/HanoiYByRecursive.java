package com.noodles.algorithm.recursive.hanoi;

/**
 * @program: noodles-parent
 * @description: 汉诺塔递归
 * @author: Eric
 * @create: 2019-01-29 14:46
 **/
public class HanoiYByRecursive {

    public static void main(String args[]){
        hanoi(3, 'a', 'b', 'c');


    }

    public static void move(char from, char to){
        System.out.println("move " + from + " to " + to);
    }

    /**
    * @Description:  递归
    * @Param: [n, a, b, c]
    * @return: void
    * @Author: Eric
    * @Date: 2019/1/29
    */
    public static void hanoi(int n, char a, char b, char c){
        if(n == 1){
            // 递归完成条件
            move(a, c);
            return;
        }

        hanoi(n - 1, a, c, b);
        move(a, c);
        hanoi(n - 1, b, a, c);

    }

}
