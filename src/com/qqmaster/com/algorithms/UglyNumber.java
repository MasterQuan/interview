package com.qqmaster.com.algorithms;

/**
 * 给定一个整数 N，写一个程序判断 N 是否为丑数。
 * 什么是丑数？
 * 只包含质因子 2、3 和 5 的正整数。
 * 比如：6 和 8 都是丑数，因为 6 = 2 * 3；8 = 2 * 2 *2。14 不是丑数，因为 14 = 2 * 7，还有另外一个质因子 7。
 * 
 * 补充 ：
 * 指在数论里，某个正整数的质因子指能整除该数的质数整数。
 * 质数：在大于 1 的自然数中，除了整数 1 外，只能被自己整除的整数。
 * 
 * 例子1：
 * 		输入：N = 10，输出：true；
 * 例子2：
 * 		输入：N = 14，输出：false
 * 
 * @author zhaoshiquan 2017年12月25日 下午2:16:31
 *
 */
public class UglyNumber {
	
	
	public static void main(String[] args) {
		System.out.println(isUglyNumber(0));
		System.out.println(isUglyNumber(1));
		System.out.println(isUglyNumber(2));
		System.out.println(isUglyNumber(3));
		System.out.println(isUglyNumber(8));
		System.out.println(isUglyNumber(14));
		System.out.println(isUglyNumber(1024));
	}
	
	public static boolean isUglyNumber(int num){
		if(num <2){
			return false;
		}
		
		for(int count = 0; num!=1; ){
			if(num % 2 == 0){
				num = num >> 1;
				count ++;
			}
			if(num % 3 == 0){
				num /= 3;
				count ++;
			}
			if(num % 5 == 0){
				num /= 5;
				count ++;
			}
			if(count ==0)
				return false;
			count = 0;
		}
		
		return true;
	}
}
