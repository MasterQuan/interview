package com.qqmaster.com.algorithms;


/**
 * 写一个函数计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 * 格式：
 * 		输入行输入一个整数 n 和一个数字 k，最后输出数字 k 在 0 到 n 中出现的次数。
 * 样例输入:
 * 		n = 12		k = 1
 * 样例输出:
 * 		5
 * 
 * @author zhaoshiquan 2017年12月7日 下午5:54:29
 *
 */
public class NumCount {
	
	
	public static void main(String[] args) {
		System.out.println(numCount(12,2));
		System.out.println(numCount(12,1));
		System.out.println(numCount(111111,1));
		System.out.println(numCount(321,2));
		System.out.println(numCount(322,2));
		System.out.println(numCount(323,2));
	}
	
	public static int numCount(int range, int num){
		final int TEN = 10;
		int count = 0;
		for(int factor = 1, div = range/TEN, rem = range % TEN; 
				true; 
				rem = div % TEN, div /= TEN, factor *= TEN){
			
			if(div == 0){
				if(rem > num){
					count += factor;
				}else if(rem == num){
					count += range - num * factor + 1;
				}
				break;
			}else{
				count += (div + (rem >= num ? 1:0)) * factor;
			}
		}
		return count;
	}

}
