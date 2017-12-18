package com.qqmaster.com.util;

import java.util.Arrays;

public class CommonUtils {
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,2,3,4,5,6,7,8};
		System.out.println(nums.length);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 6)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1, 7)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 2, 8)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 3, 9)));
	}
	
	
	//返回数组中的最大值的位置。
	//indexOfMaxValue;
	public static int maxValueAndIndexInArray(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int maxIndex = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > nums[maxIndex]){
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	//返回数组中的最大值
	public static int maxValueInArray(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int max = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > max){
				max = nums[i];
			}
		}
		
		return max;
	}

}
