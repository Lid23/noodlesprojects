package com.noodles.algorithm;

/**
 * @filename ReplaceSpace
 * @description 替换空格 : 将一个字符串中的空格替换成 "%20"
 * @solve
 *  1.在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符
 *  2.令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容
 *  3.当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出
 * @link https://cyc2018.github.io/CS-Notes/#/notes/5.%20%E6%9B%BF%E6%8D%A2%E7%A9%BA%E6%A0%BC
 * @author 巫威
 * @date 2020/8/13 10:14
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("A B  C");
		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str){
		// p1指向现有字符串末尾
		int p1 = str.length() - 1;
		for (int i = 0; i < p1; i++) {
			if(str.charAt(i) == ' '){
				//1.遇到空格，末尾填充两个任意字符，符合替换空格后的长度
				str.append("  ");
			}
		}

		// p2指向替换后的字符串末尾
		int p2 = str.length() - 1;

		//遍历p1
		while(p1 >= 0 && p1 < p2){
			char c = str.charAt(p1--);
			if(c == ' '){
				// 如果是空格字符
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			} else {
				// 如果不是空格字符，移到p2指向的位置
				str.setCharAt(p2--, c);
			}
		}

		return str.toString();

	}
}
