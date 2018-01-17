package com.qqmaster.com.algorithms;

/**
 * 给定一个整数 N，写一个程序判断是否存在 2 个整数 a、b（a < b），使得 a^2 + b^2 = N
 * 例子1：
 * 		输入：N = 5，输出：true，a = 1，b = 2；
 * 例子2：
 * 		输入：N = 7，输出：false
 * 
 * @author zhaoshiquan 2017年12月19日 上午9:36:10
 *
 */
public class PowSumOf2Nums {
	
	public static void main(String[] args) {
		System.out.println(isPowSumOf2Nums(225121));
		System.out.println(isPowSumOf2Nums(225794));
		System.out.println(isPowSumOf2Nums(19861361));
		System.out.println(isPowSumOf2Nums(225122));
		System.out.println(isPowSumOf2Nums(225795));
		System.out.println(isPowSumOf2Nums(19861363));
		System.out.println(isPowSumOf2Nums(0));
		System.out.println(isPowSumOf2Nums(-1));
		System.out.println(isPowSumOf2Nums(8));
	}
	
	public static boolean isPowSumOf2Nums(int num){
		if(num < 0)
			return false;
		
		boolean isPowOf2 = false;
		int sqrt = (int)Math.sqrt(num);
		for(int a = 0, b = sqrt; a + b >= sqrt && a <= b;){
			int sum = a*a + b*b;
			if(sum == num){
				return true;
			}else if (sum < num){
				a++;
			}else {
				b--;
			}
		}
		
		return isPowOf2;
	}
}
