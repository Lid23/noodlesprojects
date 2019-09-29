package com.noodles.jvm;

/**
 * @filename NewSizeDemo
 * @description 连续向系统请求10M空间
 * @author 巫威
 * @date 2019/9/29 16:20
 */
public class NewSizeDemo {

	/***
	 * 1.-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
	 *
	 */
	public static void main(String[] args) {
		byte[] b = null;
		for(int i=0; i<10; i++){
			b = new byte[1 * 1024 * 1024];
		}
	}
}
