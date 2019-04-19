package com.noodles.jvm;

import java.nio.ByteBuffer;

/**
 * 文件名：AccessDirectBuffer.java
 * 描述：直接内存跳过了Java堆，使Java程序可以直接访问原生堆空间，一定程度上加快了内存空间的访问速度
 * 最大可用直接内存可以使用参数 -XX：MaxDirectMenorySize设置，如不设置，默认值为最大堆空间，当直接内存使用量
 * 达到-XX:MaxDirectMemorySize时，就会触发垃圾回收，如果垃圾回收不能有效释放足够空间，直接内存溢出依然会引起
 * 系统的OOM
 * 作者：KJ00019
 * 日期：2017年10月20日上午9:43:22
 */
public class AccessDirectBuffer {
	
	/**
	 * 对直接内存进行读写 ，进行耗时统计
	 * 作者：KJ00019
	 * 日期：2017年10月20日上午10:12:26
	 */
	public void directAccess(){
		long startTime = System.currentTimeMillis();
		
		ByteBuffer b = ByteBuffer.allocateDirect(10000);
		for(int i=0; i<100000; i++){
			for(int j=0; j<999; j++){
				b.putInt(j);
			}
			b.flip();
			for(int j=0; j<999; j++){
				b.getInt(j);
			}
			b.clear();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("testDirectWrite:" + (endTime - startTime));
	}
	
	/**
	 * 对堆内存进行读写，进行耗时统计
	 * 作者：KJ00019
	 * 日期：2017年10月20日上午10:13:11
	 */
	public void bufferAccess(){
		long startTime = System.currentTimeMillis();

		ByteBuffer b = ByteBuffer.allocate(10000);
		for(int i=0; i<100000; i++){
			for(int j=0; j<999; j++){
				b.putInt(j);
			}
			b.flip();
			for(int j=0; j<999; j++){
				b.getInt(j);
			}
			b.clear();
		}

		long endTime = System.currentTimeMillis();

		System.out.println("testBufferWrite:" + (endTime - startTime));
	}

	/**
	 * 申请直接内存空间
	 * 作者：KJ00019
	 * 日期：2017年10月20日上午10:16:48
	 */
	public void directAllocate(){
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<200000; i++){
			ByteBuffer b = ByteBuffer.allocateDirect(1000);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("directAllocate : " + (endTime - startTime));
	}
	
	/**
	 * 申请堆内存空间
	 * 作者：KJ00019
	 * 日期：2017年10月20日上午10:16:56
	 */
	public void bufferAllocate(){
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<200000; i++){
			ByteBuffer b = ByteBuffer.allocate(1000);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("bufferAllocate : " + (endTime - startTime));
	}
	
	public static void main(String args[]){
		AccessDirectBuffer accessDirectBuffer = new AccessDirectBuffer();
		
		/** 直接内存读写比堆内存读写快*/
		accessDirectBuffer.directAccess();
		accessDirectBuffer.bufferAccess();
		
		/** 内存空间申请时间对比*/
		accessDirectBuffer.directAllocate();
		accessDirectBuffer.bufferAllocate();
	}
	
}
