package com.qqmaster.com;

/**
 * 给出 2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，写一个函数找到这个数字。
 * 挑战：
 * 一次遍历，常数级的额外空间复杂度
 * 
 * 格式：
 * 输入行输入一个数组，最后输出出现一次的数字。
 * 样例输入
 * [ 1，2，2，1，3，4，3 ]
 * 样例输出
 * 4
 * 
 * @author zhaoshiquan 2017年12月21日 上午10:07:35
 *
 */
public class SingleNum {
	
	public static void main(String[] args) {
		int[] nums1 = null;
		int[] nums2 = {};
		int[] nums3 = {1};
		int[] nums4 = {1,1,2,2,3};
		int[] nums5 = {1,1,2};
		int[] nums6 = {2,2,1};
		
		System.out.println(findSingleNum(nums1));
		System.out.println(findSingleNum(nums2));
		System.out.println(findSingleNum(nums3));
		System.out.println(findSingleNum(nums4));
		System.out.println(findSingleNum(nums5));
		System.out.println(findSingleNum(nums6));
	}
	
	public static int findSingleNum(int[] nums){
		if(nums == null || nums.length <= 0)
			return -1;
		
		int single = 0;
		for(int num:nums){
			single ^= num;
		}
		return single;
	}

}
