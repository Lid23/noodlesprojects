package com.noodles.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则表达式 java.util.regex包
 * 文件名：RegularExpression.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月26日下午1:54:46
 */
public class RegularExpression{
	
	public static void main(String args[]){
		
		/*String regex = "abc*";
		String input = "abcabcabc";
		
		System.out.println(matches(regex, input));*/
		
		
		testMatcherFind("", "Evening is full of the Linset's wings");


		//testMatcherFind("s.[0-9]{6}", "http://quote.eastmoney.com/sz201001.html");
		
		/**组*/
		/*String groupRegex = "(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$";
		String poem = "Twas brillig, and the slithy toves\n" + 
				"Did gyre and gimble in the wabe.\n" + 
				"All mimsy were the borogoves, \n" + 
				"And the mome raths outgrade.\n\n" + 
				"Beware the jabberwock, my son, \n" + 
				"The jaws that bite , the claws that catch.\n" + 
				"Beware the jubjub bird, and shun\n" + 
				"The funmious Bandersnatch";
		
		testMatcherGroup(groupRegex, poem);*/
		
		/**模式标记*/
		/*String regex = "^java";
		String input = "java has regex\n regex\n" + 
				"JAVA has pretty good regular expression\n" + 
				"Regular expressions are in Java";
		int patternFlag = Pattern.CASE_INSENSITIVE | Pattern.MULTILINE;
		testPatternFlags(regex, input, patternFlag);*/
		
		/**split分割*/
		/*String regex = "!!";
		String input = "This!!unusual!!of exclamation!!points";
		System.out.println(Arrays.asList(testSplitRegex(regex, input)));*/
		
		/**替换操作*/
		/*testReplacements();*/
		
		/**reset*/
		//testRegexReset();
	}
	
	/**
	 * 
	 * @param regex
	 * @param input
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午1:59:03
	 */
	public static void testMatcherFind(String regex, String input){
		
		/**Pattern对象表示正则表达式的编译版本，compile方法将正则表达式编程成Pattern对象*/
		Pattern pattern = Pattern.compile(regex);
		
		/**使用matcher方法和输入字符串从编译过的Pattern对象中产生Matcher对象*/
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()){
			/**find 方法扫描输入序列以查找与该模式匹配的下一个子序列*/
			System.out.println(matcher.group());
		}
	}
	
	
	/**
	 * 编译给定正则表达式并尝试将给定输入与其匹配，用于快速识别
	 * @param regex
	 * @param input
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午2:05:55
	 */
	public static boolean matches(String regex, String input){
		return Pattern.matches(regex, input);
	}
	
	/**
	 * 组 是由圆括号分开的正则表达式，随后可以根据他们的组号进行调用。第0组表示整个匹配表达式，第一组表示第一个用圆括号括起来的组
	 *  A(B(C))D : 第0组 ABCD，第1组BC，第2组C
	 */
	public static void testMatcherGroup(String regex, String input){
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()){
			
			// System.out.println(matcher.group());
			
			for(int j=0; j<=matcher.groupCount(); j++){
				System.out.print("["+matcher.group(j)+"]" + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 模式标记
	 *   Pattern.CANON_EQ  -- 启用规范等价
	 *   Pattern.UNICODE_CASE -- 启用 Unicode 感知的大小写折叠
	 *   参考 java api
	 * @param regex
	 * @param input
	 * @param patternFlag
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午3:45:53
	 */
	public static void testPatternFlags(String regex, String input, int patternFlag){
		Pattern pattern = Pattern.compile(regex, patternFlag);
		
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
	
	/**
	 * Splitting将输入字符串断开成字符串数组对象，断开边界由正则表达式确定
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午3:49:12
	 */
	public static String[] testSplitRegex(String regex, String input){
		
		Pattern pattern = Pattern.compile(regex);
		return pattern.split(input);
		
	}
	
	
	/**
	 * 替换操作
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午4:41:39
	 */
	public static void testReplacements(String s){
		
		try {
			Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
			if(mInput.find()){
				s = mInput.group(1);
				
				/**Replace two or more spaces with a single of space*/
				s = s.replaceAll(" {2,}"," ");
				/**Replace one or more spaces at the beginning of each line 
				 * with no spaces,Must enable MULTLINE mode*/
				s = s.replaceAll("(?m)^ +", "");
				System.out.println(s);
				
				s = s.replaceFirst("[aeiou]", "VOWEL1");
				StringBuffer sbuf = new StringBuffer();
				Pattern p = Pattern.compile("[aeiou]");
				Matcher m = p.matcher(s);
				while(m.find()){
					m.appendReplacement(sbuf, m.group().toUpperCase());
				}
				m.appendTail(sbuf);
				
				System.out.println(sbuf);
						
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用reset方法，可以将现有的matcher对象应用于一个新的字符序列
	 * 作者：KJ00019
	 * 日期：2017年10月26日下午4:42:20
	 */
	public static void testRegexReset(){
		Pattern pattern = Pattern.compile("[frb][aiu][gx]");
		Matcher matcher = pattern.matcher("fix the rug with bags");
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
		matcher.reset("fix the rig with rags");
		
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
		
		
	}
}
