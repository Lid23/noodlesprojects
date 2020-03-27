package com.noodles.concurrent.threadpool.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @filename CustomThreadFactory
 * @description 创建线程factory
 * @author 巫威
 * @date 2020/3/27 14:31
 */
public class CustomThreadFactory implements ThreadFactory {

	/**线程名称前缀*/
	private String namePrefix;

	/**线程组*/
	private ThreadGroup group;

	/**线程数目*/
	private final AtomicInteger threadNumber = new AtomicInteger(0);

	public CustomThreadFactory(String namePrefix) {
		SecurityManager securityManager = System.getSecurityManager();
		group = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
		this.namePrefix = namePrefix;
	}

	@Override
	public Thread newThread(Runnable r) {
		/**创建线程，设置线程的线程组和线程名*/
		Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);

		/**守护线程*/
		if (t.isDaemon()){
			t.setDaemon(false);
		}

		if(t.getPriority() != Thread.NORM_PRIORITY){
			t.setPriority(Thread.NORM_PRIORITY);
		}

		return t;
	}
}
