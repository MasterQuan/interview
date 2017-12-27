package com.qqmaster.com;

/**
 * 若给定两个整数数组（第一个是数组 A，第二个是数组 B），
 * 在数组 A 中取 A[ i ]，数组 B 中取 B[ j ]，A[ i ] 和 B[ j ] 
 * 两者的差越小越好( | A[ i ] - B[ j ] | )，写一个函数返回最小差。
 * 挑战 ：
 * 	时间复杂度 O(n log n)
 * 格式：
 * 	输入行输入两个整数数组 A 和 B，最后输出返回的最小差。
 * 样例输入
 * 	A = [ 3，4，6，7 ]
 * 	B = [ 2，3，8，9 ]
 * 样例输出
 * 	0
 * 
 * @author zhaoshiquan 2017年12月27日 上午10:36:53
 *
 */
public class MinDifferrence {

	public static void main(String[] args) {
		int[] n1 = null, n2 = null;
		int[] n3 = {}, n4 = {};
		int[] n5 = null, n6 = {1,2};
		int[] n7 = {1,2,3}, n8 = {1,2,3};
		int[] n9 = {3,4,6,7}, n10 = {2,3,8,9};
		int[] n11 = {1,2,3,4}, n12 = {10,9,8,7};
		int[] n13 = {3,4}, n14 = {4,4,8,7};
		int[] n15 = {3,9,999}, n16 = {4,8,999};
		
		System.out.println(getMinDiff1(n1,n2));
		System.out.println(getMinDiff1(n3,n4));
		System.out.println(getMinDiff1(n5,n6));
		System.out.println(getMinDiff1(n7,n8));
		System.out.println(getMinDiff1(n9,n10));
		System.out.println(getMinDiff1(n11,n12));
		System.out.println(getMinDiff1(n13,n14));
		System.out.println(getMinDiff1(n15,n16));
	}
	
	//时间复杂度O(n^2)
	public static int getMinDiff1(int[] ns1, int[] ns2){
		if(ns1 == null || ns2 == null || ns1.length < 1 || ns2.length < 1)
			return -1;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < ns1.length; i++){
			for(int j = 0; j < ns2.length; j++){
				int abs = Math.abs(ns1[i] - ns2[j]);
				min = abs < min ? abs : min;
				if(min == 0)
					return min;
			}
		}
		
		return min;
	}

	public static int getMinDiff2(int[] ns1, int[] ns2){
		if(ns1 == null || ns2 == null || ns1.length < 1 || ns2.length < 1)
			return -1;
		int len = ns1.length + ns2.length;
		int[] nums = new int[len];
		
		return 0;
	}
}
