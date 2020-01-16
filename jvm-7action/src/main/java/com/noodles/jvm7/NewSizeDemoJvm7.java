package com.noodles.jvm7;

/**
 * @filename NewSizeDemo
 * @description 连续向系统请求10M空间
 * @author 巫威
 * @date 2019/9/29 16:20
 */
public class NewSizeDemoJvm7 {

	/***
	 * Jdk1.7_80 有bug SurvivorRatio失效
	 * 1.-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
	 * -Xmn1m 用于设置新生代的大小，设置一个较大的新生代会减小老年代的大小，这个参数对系统性能以及GC行为有很大的影响
	 * -XX:SurvivorRatio 用来设置新生代中eden空间和 from/to空间的比例关系
	 */
	public static void main(String[] args) {
		byte[] b = null;
		for(int i=0; i<10; i++){
			b = new byte[1 * 1024 * 1024];
		}
	}
}
