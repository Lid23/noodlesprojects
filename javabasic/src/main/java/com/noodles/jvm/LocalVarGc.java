package com.noodles.jvm;

/**
 * 测试局部变量对垃圾回收的影响，分配一块6M的空间，使用局部变量引用这块空间
 * 文件名：LocalVarGc.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月17日上午8:43:40
 */
public class LocalVarGc {
	
	/**
	 * byte数组被变量a引用，因此无法回收
	 * 作者：KJ00019
	 * 日期：2017年10月17日上午8:50:16
	 */
	public void localVarGc1(){
		byte[] a = new byte[6 * 1024 * 1024];
		System.gc();
	}
	
	/**
	 * 垃圾回收前， 先将局部变量置为null，使byte数组失去强引用，故垃圾回收可以顺利回收byte数组
	 * 作者：KJ00019
	 * 日期：2017年10月17日上午8:56:45
	 */
	public void localVarGc2(){
		byte[] a = new byte[6 * 1024 * 1024];
		a = null;
		System.gc();
	}
	
	/**
	 * 进行垃圾回收前，先使局部变量a失效，虽然变量a已经离开了作用域，
	 * 但是变量a依然存在于局部变量中，并且也指向这块byte数组，故byte
	 * 数组依然无法被回收
	 * 作者：KJ00019
	 * 日期：2017年10月17日上午8:58:08
	 */
	public void localVarGc3(){
		{
			byte[] a = new byte[6 * 1024 * 1024];
		}
		System.gc();
	}
	
	/**
	 * 垃圾回收前， 不仅使变量a失效，更是申明了变量c，使变量c复用了变量a的字，由于变量a此时被销毁
	 * 故垃圾回收器可以顺利回收byte数组
	 * 作者：KJ00019
	 * 日期：2017年10月17日上午8:59:40
	 */
	public void localVarGc4(){
		{
			byte[] a = new byte[6 * 1024 * 1024];
		}
		int c = 10;
		System.gc();
	}
	
	/**
	 * 首先调用了localVarGc1，但并没有释放byte数组，在localVarGc1返回后，他的栈帧被销毁，
	 * 自然也包含了栈帧中的所有局部变量，故byte数组失去引用，被回收
	 * 作者：KJ00019
	 * 日期：2017年10月17日上午9:01:09
	 */
	public void localVarGc5(){
		localVarGc1();
		System.gc();
	}
	
	public static void main(String args[]){
		LocalVarGc ins = new LocalVarGc();
		ins.localVarGc5();
	}
	
}