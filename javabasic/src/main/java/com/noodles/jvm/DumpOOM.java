package com.noodles.jvm;

import java.util.Vector;

/**
 * @filename DumpOOM
 * @description 堆溢出测试
 * @author 巫威
 * @date 2019/9/30 15:56
 */
public class DumpOOM {

	public static void main(String[] args) {

		/**
		 * -XX:+HeapDumpOnOutOfMemoryError 内存溢出时导出这个堆信息
		 * -XX:HeapDumpPath 指定导出堆的存放路径
		 * 1. -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/log/a.dump
		 *
		 * */
		Vector vector = new Vector<>();
		for(int i=0; i<25; i++){
			vector.add(new byte[1 * 1024 * 1024]);
		}
	}
}
