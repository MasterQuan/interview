package com.qqmaster.com.algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个非负数，表示一个数字数组，在该数的基础上 +1，返回一个新的数组。
 * 写一个函数将该数字按照大小进行排列，最大的数在列表的最前面。
 * 格式：
 * 	输入行依次输入一个整数数组，最后输出排序后的数组。
 * 样例输入
 * 	[ 1，2，3 ] 
 * 	[ 9，9，9 ] 
 * 样例输出
 * 	[ 1，2，4 ]
 * 	[ 1，0，0，0 ]
 * 
 * @author zhaoshiquan 2017年12月27日 上午9:38:31
 *
 */
public class PlusOne {
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3};
		int[] nums2 = {9,9,9};
		int[] nums3 = {9,8};
		int[] nums4 = {3,3,3};
		int[] nums5 = null;
		int[] nums6 = {};
		int[] nums7 = {0};
		int[] nums8 = {0,0,1};
		
		System.out.println(Arrays.toString(plusOneOnArray(nums1)));
		System.out.println(Arrays.toString(plusOneOnArray(nums2)));
		System.out.println(Arrays.toString(plusOneOnArray(nums3)));
		System.out.println(Arrays.toString(plusOneOnArray(nums4)));
		System.out.println(Arrays.toString(plusOneOnArray(nums5)));
		System.out.println(Arrays.toString(plusOneOnArray(nums6)));
		System.out.println(Arrays.toString(plusOneOnArray(nums7)));
		System.out.println(Arrays.toString(plusOneOnArray(nums8)));
	}
	
	public static int[] plusOneOnArray(int[] nums){
		if(nums == null || nums.length < 1){
			return nums;
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		int carry = 1;
		for(int i = nums.length - 1; i>=0; i--){
			int sum = nums[i] + carry;
			carry = sum/10;
			list.addFirst(sum % 10);
		}
		if(carry != 0){
			list.addFirst(carry);
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			res[i] = list.get(i);
		}
		
		return res;
	}
}
