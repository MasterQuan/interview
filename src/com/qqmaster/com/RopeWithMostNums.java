package com.qqmaster.com;

/**
 * 有一个有序数组中存在n个不相同的整数，每个整数可以认为是一个点，现有一根长度为L的绳子，求这根绳子能最多覆盖的点的数目。
 * 假设数组中的数字都是有序的。
 * 
 * @author zhaoshiquan 2017年12月18日 下午8:04:43
 *
 */
public class RopeWithMostNums {
	
	public static void main(String[] args) {
		int[] nums1 = {1,3,4,5,6,7,8};
		int[] nums2 = {1,3,5,7,9};
		int[] nums3 = {1,2,3,4,5,6,7,8};
		int[] nums4 = {1,3,14,25,76,97,208};
		int[] nums5 = {};
		int[] nums6 = {1};
		int[] nums7 = {-1,0,1,3,4,8};
		
		System.out.println(ropeWithMostNums(nums1, 3));
		System.out.println(ropeWithMostNums(nums2, 5));
		System.out.println(ropeWithMostNums(nums2, 6));
		System.out.println(ropeWithMostNums(nums3, 4));
		System.out.println(ropeWithMostNums(nums4, 80));
		System.out.println(ropeWithMostNums(nums4, 25));
		System.out.println(ropeWithMostNums(nums5, 3));
		System.out.println(ropeWithMostNums(nums6, 3));
		System.out.println(ropeWithMostNums(nums7, 6));
	}
	public static int ropeWithMostNums(int[] nums, int ropeLen){
		if(nums == null || nums.length <=1 || ropeLen <= 0)
			return 0;
		
		int count = 0;
		int dist = 0;
		int maxCount = 0;
		
		for(int i = 0, front = 0; i<nums.length ;i++){
			dist = nums[i] - nums[front];
			count ++;
			
			if(dist > ropeLen){
				count --;
				front ++;
				dist -= nums[front];
			}
			maxCount = maxCount < count ? count: maxCount;
		}
		
		return maxCount;
	}
}
