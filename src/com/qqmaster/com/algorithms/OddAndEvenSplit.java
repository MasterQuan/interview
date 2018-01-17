package com.qqmaster.com.algorithms;

import java.util.Arrays;

/**
 * 写一个函数分割一个整数数组，使得奇数在前偶数在后。
 * 挑战： 
 * 	在原数组中完成，不使用额外空间。
 * 格式：
 * 	输入行输入一个整数数组，最后输出分割后的数组。
 * 样例输入
 * 	[ 1， 2，3，4 ]
 * 样例输出
 * 	[ 1，3，2，4 ]
 * 
 * @author zhaoshiquan 2017年12月26日 上午10:39:54
 *
 */

public class OddAndEvenSplit {

	public static void main(String[] args) {
		int[] nums1 = null;
		int[] nums2 = {};
		int[] nums3 = {1};
		int[] nums4 = {1,2};
		int[] nums5 = {1,2,3,4,5,6,7,8,9};
		int[] nums6 = {1,2,3,4,5,6,7,8,9,10};
		int[] nums7 = {10,9,8,7,6,5,4,3,2,1};
		int[] nums8 = {10,8,6,4,3,2,1,7,9,5};
		
		splitArrs(nums1);
		splitArrs(nums2);
		splitArrs(nums3);
		splitArrs(nums4);
		splitArrs(nums5);
		splitArrs(nums6);
		splitArrs(nums7);
		splitArrs(nums8);
		
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		System.out.println(Arrays.toString(nums5));
		System.out.println(Arrays.toString(nums6));
		System.out.println(Arrays.toString(nums7));
		System.out.println(Arrays.toString(nums8));
	}
	
	public static void splitArrs(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		
		for(int i = 0, j = nums.length - 1; i<j; ){
			while(nums[i] % 2 != 0){
				i++;
			}
			
			while(nums[j] % 2 == 0){
				j--;
			}
			
			if(i < j){
				nums[i] ^= nums[j];
				nums[j] ^= nums[i];
				nums[i] ^= nums[j];
			}
		}
	}
}
