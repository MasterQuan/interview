package com.qqmaster.com;

import java.util.ArrayList;
import java.util.List;

/**
 * 你给出一个整数数组（size 为 n），其具有以下特点：
 * 		1、相邻位置的数字是不同的
 * 		2、A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足 A[P] > A[P-1] 且 A[P] > A[P+1]，写一个函数返回数组中所有峰值的位置。
 * 格式：
 * 		输入行输入一个整数数组，输出行输出所有数组中的峰值的位置。
 * 样例输入
 * 		[ 1，2，1，3，4，5，7，6 ]
 * 样例输出
 * 		1，6
 * 
 * @author zhaoshiquan 2017年12月13日 下午3:06:16
 *
 */
public class PeakValue {
	public static void main(String[] args) {
		int[] a = {1,2,1,3,4,5,7,6};
		int[] b = {1,2,1,3,1,1,6,7};
		int[] c = {1,2,3,4,5,6,6,7};
		int[] d = {1,2};
		int[] e = {1};
		int[] f = {};
		int[] g = null;
		int[] h = {7,6,5,4,3,2,1,0};
		
		System.out.println("a_locs->" + getPeakValueLoc(a));
		System.out.println("b_locs->" + getPeakValueLoc(b));
		System.out.println("c_locs->" + getPeakValueLoc(c));
		System.out.println("d_locs->" + getPeakValueLoc(d));
		System.out.println("e_locs->" + getPeakValueLoc(e));
		System.out.println("f_locs->" + getPeakValueLoc(f));
		System.out.println("g_locs->" + getPeakValueLoc(g));
		System.out.println("h_locs->" + getPeakValueLoc(h));
		
	}
	
	public static List<Integer> getPeakValueLoc(int[] nums){
		List<Integer> locs= new ArrayList<Integer>();
		
		if(nums == null || nums.length <=3)
			return locs;
		
		for(int loc = 1; loc < nums.length - 1;){
			if(nums[loc] > nums[loc - 1] && nums[loc] > nums[loc + 1]){
				locs.add(loc);
				loc += 2;
			}else{
				if(nums[loc] >= nums[loc + 1]){
					loc += 2;
				}else{
					loc++;
				}
			}
		}
		
		return locs;
	}
}
