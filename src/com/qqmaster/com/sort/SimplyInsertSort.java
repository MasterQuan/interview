package com.qqmaster.com.sort;

import java.util.Arrays;

/**
 * 简单插入排序算法
 * 
 * @author zhaoshiquan 2017年12月19日 上午9:55:57
 *
 */
public class SimplyInsertSort {
	
	public static void main(String[] args) {
		int[] ns1 = {};
		int[] ns2 = {3,2,1,6,8,4,5,7,9,0};
		int[] ns3 = {0,9,8,7,6,5,4,3,2,1};
		int[] ns4 = {0,1,2,3,4,5,6,7,8,9};
		int[] ns5 = {51,22,83,46,75,18,6,30};
		int[] ns6 = {51,22,83,46,75,18,51,51,20};
		int[] ns7 = null;
		int[] ns8 = {8, 7};
		int[] ns9 = {8, 7, 8};
		
		System.out.println("-----------------");
		insertSort(ns1) ;
		System.out.println("-----------------");
		insertSort(ns2) ;
		System.out.println("-----------------");
		insertSort(ns3) ;
		System.out.println("-----------------");
		insertSort(ns4) ;
		System.out.println("-----------------");
		insertSort(ns5) ;
		System.out.println("-----------------");
		insertSort(ns6) ;
		System.out.println("-----------------");
		insertSort(ns7) ;
		System.out.println("-----------------");
		insertSort(ns8) ;
		System.out.println("-----------------");
		insertSort(ns9) ;
		System.out.println("-----------------");
	}
	

	public static void insertSort(int[] ns){
		//异常判断
		if(null ==ns || ns.length <=1)
			return;
		
		System.out.println("-->" + Arrays.toString(ns));
		
		for(int i = 1; i < ns.length; i++){
			int mid = ns[i], j = i - 1;
			for(; j >= 0 ; j--){
				if(ns[j] > mid){
					ns[j + 1] = ns[j]; 
				}else break;
			}
			ns[j + 1] = ns[j + 1] > mid? mid: ns[j + 1];
			System.out.println("-->" + Arrays.toString(ns));
		}
	}
}
