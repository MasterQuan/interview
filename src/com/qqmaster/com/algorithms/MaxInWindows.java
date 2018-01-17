package com.qqmaster.com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qqmaster.com.util.CommonUtils;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，
 * 		如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 		那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 		针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， 
 * 		{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， 
 * 		{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author zhaoshiquan 2017年12月18日 下午2:06:24
 *
 */
public class MaxInWindows {

	public static void main(String[] args) {
		int[] nums1 = {2,3,4,2,6,2,5,1};
		int[] nums2 = {9,8,7,6,5,4,3,2,1};
		int[] nums3 = {1,2,3,4,5,6,7,8,9};
		int[] nums4 = {1,2,2,2,3,3,3,4,4,5,6,7,8,9};
		System.out.println(maxInWindows(nums1,3));
		System.out.println(maxInWindows(nums2,3));
		System.out.println(maxInWindows(nums3,3));
		System.out.println(maxInWindows(nums4,3));
		System.out.println(maxInWindows(nums4,2));
		System.out.println(maxInWindows(nums4,4));
		System.out.println(maxInWindows(nums4,1));
		System.out.println(maxInWindows(nums4,0));
		System.out.println(maxInWindows(nums4,-1));
		System.out.println(maxInWindows(null,-1));
		System.out.println(maxInWindows(new int[0],-1));
	}
	
	public static List<Integer> maxInWindows(int [] nums, int size){
		
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || size < 1){
        		return result;
        }
        
        int length = nums.length;
        
        if(length <= size){
        		result.add(CommonUtils.maxValueInArray(nums));
        		return result;
        }
        
        int maxIndex = -1;
        for(int startIndex = 0; startIndex <= length - size; startIndex++){
        		
        		if(maxIndex == -1){
        			int[] mid = Arrays.copyOfRange(nums, startIndex, startIndex + size);
        			maxIndex = CommonUtils.maxValueAndIndexInArray(mid);
        		}
        		
        		if(nums[maxIndex + startIndex] <= nums[startIndex + size - 1]){
        			result.add(nums[startIndex + size - 1]);
        			maxIndex = size - 1;
        		}else {
        			result.add(nums[maxIndex + startIndex]);
        		}
        		maxIndex--;
        }
        
        return result;
    }
}
