package com.qqmaster.com;

/**
 * 设计一个算法，计算出任意一个整数 n 的阶乘中尾部零的个数
 * 挑战 :
 * O(logN)的时间复杂度
 * 格式：
 * 输入行第一行输入一个整数 n，最后输出阶乘尾部零的个数。
 * 样例输入
 * 		11
 * 样例输出
 * 		2
 * 
 * @author zhaoshiquan 2017年12月25日 下午3:32:20
 *
 */

public class ZeroNumOfFactor {
	
	public static void main(String[] args) {
		System.out.println(numOfZero(1));
		System.out.println(numOfZero(11));
		System.out.println(numOfZero(25));
	}
	
	public static int numOfZero(int num){
		if(num < 5)
			return 0;
		
		int count = 0;
		for(int i = 5; num / i > 0; i = i * 5){
			count += num/i;
		}
		return count;
	}
}
