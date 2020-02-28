package com.noodles.effectivejava.ch2;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Random;

/**
 * @filename CreateAndDestroyObject
 * @description 创建和销毁对象
 * @author 巫威
 * @date 2020/2/28 11:30
 */
public class CreateAndDestroyObject {

	public static void main(String[] args) {
		/**一、静态工厂方法代替构造器*/
		/**1.静态工厂方法与构造器不同的第一大优势在于，它们有名称*/
		BigInteger propablePrime1 = new BigInteger(1, 10, new Random());
		BigInteger propablePrime2 = BigInteger.probablePrime(10, new Random());

		/**2.静态工厂方法与构造器不同的第二大优势在于，不必在每次调用它们的时候都创建一个新对象，如果程序
		经常请求创建相同的对象，并且创建对象的代价很高，则这项技术可以极大的提升性能*/
		Boolean trueBoolean = Boolean.valueOf(true);

		/*3.静态工厂方法与构造器不同的第三大优势在于，它们可以返回原返回类型的任何子类型的对象，这样我们在选择返回对象
		的类时就有了更大的灵活性*/
		//java.util.Collections;

		/*4.静态工厂方法与构造器不同的第四大优势在于，所返回的对象的类可以随着每次调用而发生变化，
		这取决于静态工厂方法的参数值*/
		//EnumSet 元素少于或者等于64个，返回RegularEnumSet，用单个long进行支持，
		// 否则工厂就返回JumboEnumSet，用一个long数组进行支持

		/*静态工厂方法与构造器不同的第五大优势在于，方法返回的对象所属的类，在编写包含该静态工厂
		* 方法的类时可以不存在*/

		/*静态工厂方法的主要缺点在于，类如果不含公有的或者受保护的构造器，就不能被子类化*/

		/*静态工厂方法的第二个缺点在于，程序员很难发现他们，一些静态工厂方法的一些管用名称：
		* from-类型转换
		* of-聚合方法，带有多个参数，返回该类型的一个实例，把他们合并起来
		* valueOf
		* instance或者getInstance-返回的实例是通过方法的（如有）参数来描述的，但是不能说与参数具有同样的值
		* create或者newInstance-像instance或者getInstance一样，但create或者newInstance能够确保每次调用
		* 都返回一个新的实例
		* getType-Type表示工厂方法锁返回的对象类型
		* newType-像newInstance一样，但是在工厂方法处于不同的类中的时候使用
		* type-getType和newType的简版
		* */


	}

}
