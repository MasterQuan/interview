package com.qqmaster.com.algorithms;

/**
 * 判断一个数是否是2的N次幂
 * 示例
 * 
 * 输入：
 * 		5
 * 返回：
 * 		false
 * @author zhaoshiquan 2017年12月22日 上午10:13:46
 *
 */
public class PowerOf2 {
	public static void main(String[] args) {
		System.out.println(isPowerOf2(0));
		System.out.println(isPowerOf2(1));
		System.out.println(isPowerOf2(2));
		System.out.println(isPowerOf2(1024));
		System.out.println(isPowerOf2(1025));
		System.out.println(isPowerOf2(-1));
		System.out.println(isPowerOf2(-2));
	}

	public static boolean isPowerOf2(int num){
		return (num & (num - 1)) == 0 ?true:false;
	}
}
