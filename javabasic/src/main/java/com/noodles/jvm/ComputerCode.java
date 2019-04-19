package com.noodles.jvm;

public class ComputerCode {
	public static void main(String args[]){
		printComplement(-10);
	}
	
	/**
	 * 打印整数在jvm内的实际表示：补码
	 * 
	 * 原码：符号位+数字的二进制表示 
	 * 反码：原码基础上，符号位不变，其余为取反
	 * 补码：正数的补码是原码本身，负数的补码是反码加1
	 * 使用补码的好处：1.解决数字0的存储，2.简化整数的加减法计算，只需要将补码简单地相加，无须区别正数或者负数
	 */
	public static void printComplement(int a){
		for(int i=0; i<32; i++){
			int t = (a & 0x80000000>>>i)>>>(31-i);
			System.out.print(t);
		}
	}
}
