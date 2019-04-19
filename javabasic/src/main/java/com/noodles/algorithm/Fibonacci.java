package com.noodles.algorithm;

/**
 * 文件名：Fibonacci.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:25:34
 */
public class Fibonacci {
	public static void main(String args[]){
		System.out.println(fibonacci(10));
	}
	
	/**
	 * 递归实现
	 * @param n
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年10月31日下午4:27:21
	 */
	public static int fibonacci(int n){  
        if(n<=2){  
            return 1;  
        }else{  
            return fibonacci(n-1)+fibonacci(n-2);  
        }  
    }
	
    /**
     * 递推实现
     * @param n
     * @return
     * 作者：KJ00019
     * 日期：2017年10月31日下午4:27:31
     */
    public static int fibonacciNormal(int n){  
        if(n<=2){  
            return 1;  
        }  
        int n1=1,n2=1,sum=0;  
        for(int i=0;i<n-2;i++){  
            sum=n1+n2;  
            n1=n2;  
            n2=sum;  
        }  
        return sum;  
    }  
}
