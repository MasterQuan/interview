package com.qqmaster.com;

/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 写一个函数判断你是否能到达数组的最后一个位置。
 * 
 * 格式：
 * 		输入行输入一个整数数组 A，最后输出是否可以到达数组的最后一个位置么，
 * 		如果可以输出 true，如果不可以输出 false。
 * 样例输入:
 * 		A = [ 2，3，1，1，4 ]
 * 样例输出:
 * 		true
 * 
 * @author zhaoshiquan 2017年12月12日 上午10:47:41
 *
 */
public class JumpGame {
	public static void main(String[] args) {
		int[] a = {2,3,1,1,4};
		int[] b = {2,2,0,0,1,1,1,1,4};
		int[] c = {2,2,1,0,4};
		int[] d = {2,2,1,1,0};
		
		System.out.println(canJumpToEnd(a));
		System.out.println(canJumpToEnd(b));
		System.out.println(canJumpToEnd(c));
		System.out.println(canJumpToEnd(d));
	}
	
	public static boolean canJumpToEnd(int[] nums){
		if(null == nums || nums.length <= 1){
			return true;
		}
		return isToEnd(0, 0, nums);
	}
	
	private static boolean isToEnd(int start, int end, int[] nums){
		if(end >= nums.length - 1 || start >= nums.length - 1){
			return true;
		}
		int max = nums[start];
		for(int i = start; i <= end; i++){
			int s = nums[i] + i;
			if(s > max){
				max = s;
			}
		}
		if(max <= end){
			return false;
		}
		return isToEnd(end + 1, max, nums);
	}
	
	
}
