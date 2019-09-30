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
	 * 由于内存申请大小为1M， 故年轻代无法满足需求，所以10m的内存分配都放到了年老代。
	 * 内存分配失败，年轻代比较小，故其将其设置了一个NewSize, 较大的值1536k，而非JVM参数中设置的1M大小
	 *
	 * 2.  -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
	 * 出现了3次新生代GC，所有内存分配都在新生代进行，通过GC保证了新生代有足够的空间，老年代没有为这些数组预留任何空间
	 * 只是在GC过程中，部分新生代对象晋升到老年代
	 *
	 * 3.-Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	 * 新生代使用15M空间，其中eden区占用了12255KB，完全满足10MB数组的分配，因此所有的分配行为都在eden区直接进行
	 * 没有触发GC行为，因此from/to和老年代的使用率都是0
	 *
	 * 由此可见，不同的堆分布情况，对系统执行会产生一定影响，在实际工作中，应该根据系统的特点做
	 * 合理的设置，基本策略是，尽可能将对象预留在新生代，减少老年代GC的次数
	 *
	 * 4. -Xmx20m -Xms20m -XX:NewRatio=2 -XX:+PrintGCDetails
	 * 新生代GC时，from/to空间不足以容纳任何一个1M数组，影响了新生代的正常回收，故在新生代回收时
	 * 需要老年代进行空间担保，因此，导致两个1M数组进入老年代
	 *
	 */
	public static void main(String[] args) {
		byte[] b = null;
		for(int i=0; i<10; i++){
			b = new byte[1 * 1024 * 1024];
		}
	}
}
