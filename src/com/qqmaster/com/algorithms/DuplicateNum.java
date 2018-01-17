package com.qqmaster.com.algorithms;

/**
 * 
 * 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，
 * 保证至少存在一个重复的整数。假设只有一个重复的整数，编写一个函数找出这个重复的数。
 * 注意事项：
 * 	1，不能修改数组(假设数组只能读)
 * 	2，只能用额外的O(1)的空间
 * 	3，时间复杂度小于O(n^2)
 * 	4，数组中只有一个重复的数，但可能重复超过一次
 * 
 * 格式：
 * 	输入每一行输入一个 整数数组，输出每一行依次输出数组中重复的数。
 * 
 * 样例输入
 * 	[ 5，5，4，3，2，1 ]
 * 	[ 5，4，3，3，2，1 ]
 * 
 * 样例输出
 * 	5
 * 	3
 * 
 * @author zhaoshiquan 2017年12月19日 下午8:27:06
 *
 */

public class DuplicateNum {
	
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {1};
		int[] nums3 = {1,2,3,4,5,5};
		int[] nums4 = {1,1,2,3,4,5};
		int[] nums5 = {1,1,1,1,4,5};
		int[] nums6 = {1,2,2,3,4,5};
		
		System.out.println(findDuplicate(nums1));
		System.out.println(findDuplicate(nums2));
		System.out.println(findDuplicate(nums3));
		System.out.println(findDuplicate(nums4));
		System.out.println(findDuplicate(nums5));
		System.out.println(findDuplicate(nums6));
	}
	
	public static int findDuplicate(int[] nums){
		
		if(nums == null || nums.length <= 1){
			return 0;
		}
		
		int fast = 0, slow = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(fast!=slow);
		
		fast = 0;
		while(fast != slow){
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return fast;
	}
}
