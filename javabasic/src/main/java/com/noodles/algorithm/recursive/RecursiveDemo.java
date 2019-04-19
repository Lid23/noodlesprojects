package com.noodles.algorithm.recursive;

/**
 * 1.递归函数都有一个递归的终结条件
 * 2.递归，少量代码就可描述出解题过程需要的多次重复计算
 * 3.缺点，占用内存，执行效率低
 * 4.优点，简洁清晰，可读性好
 * 5.可采用数学归纳法证明递归的正确性
 * 6.递归可转化为递推
 * @program: noodles-parent
 * @description: 递归实现例子
 * @author: Eric
 * @create: 2019-01-18 11:27
 **/
public class RecursiveDemo {
    public static void main(String args[]){
        System.out.println("n阶乘，递归:" + fact(5));
        System.out.println("n阶乘，递推:" + fact2(5));

        System.out.println("斐波那契数第n项-递归：" + fibonacci(10));
        System.out.println("斐波那契数第n项-递推：" + fibonacci2(10));
    }
    
    /** 
    * @Description: 递归计算n阶乘 
    * @Param: [n] 
    * @return: int 
    * @Author: Eric
    * @Date: 2019/1/18 
    */
    public static int fact(int n){
        if(n == 1){
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
    * @Description: 阶乘的递推算法
    * @Param: [n]
    * @return: int
    * @Author: Eric
    * @Date: 2019/1/18
    */
    public static int fact2(int n){
        int s = 1;
        for(int i=1; i<=n; i++){
            s = s * i;
        }
        return s;
    }

    /**
    * @Description: 斐波那契数，递归
    * @Param: [n]
    * @return: int
    * @Author: Eric
    * @Date: 2019/1/18
    */
    public static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci( n - 2);
    }

    /** 
    * @Description: 斐波那契数，递推 
    * @Param: [n] 
    * @return: int 
    * @Author: Eric
    * @Date: 2019/1/18 
    */
    public static int fibonacci2(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int f1 = 1;
        int f2 = 1;
        int f = 0;
        for(int i=2; i<n; i++){
            f = f1 + f2;
            f2 = f1;
            f1 = f;
        }
        return f;
    }
}
