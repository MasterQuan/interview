package com.qqmaster.com.algorithms;

/**
 * 给出 n + 1 个数字，每个数字都在1到n之间
 * 除其中一个数字出现两次外其他每个数字均只出现一次，写一个函数找到这个数字。
 * 挑战：
 * 一次遍历，常数级的额外空间复杂度
 * 
 * 格式：
 * 输入行输入一个数组，最后输出出现一次的数字。
 * 样例输入
 * [ 1，2，3，1，4，5，6]
 * 样例输出
 * 4
 * @author zhaoshiquan 2017年12月21日 上午10:16:18
 *
 */
public class DuplicateNum2 {
	
	public static void main(String[] args) {
		int[] nums1 = null;
		int[] nums2 = {1};
		int[] nums3 = {1,1};
		int[] nums4 = {1,2,2};
		int[] nums5 = {1,2,3,4,5,6,7,7};
		int[] nums6 = {1,1,2,3,4,5,6,7,8,9};
		
		System.out.println(findDuplicateNum(nums1));
		System.out.println(findDuplicateNum(nums2));
		System.out.println(findDuplicateNum(nums3));
		System.out.println(findDuplicateNum(nums4));
		System.out.println(findDuplicateNum(nums5));
		System.out.println(findDuplicateNum(nums6));
	}
	
	public static int findDuplicateNum(int[] nums){
		if(nums == null || nums.length <= 1){
			return 0;
		}
		
		int dupNum = 0;
		for(int num:nums){
			dupNum ^= num;
		}
		for(int i = 1; i < nums.length; i++){
			dupNum ^= i;
		}
		return dupNum;
	}
}
