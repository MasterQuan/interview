package com.qqmaster.com.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 
 * @author zhaoshiquan 2017年12月19日 上午9:55:16
 *
 */
public class BubbleSort {

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
		bubbleSort(ns1) ;
		System.out.println("-----------------");
		bubbleSort(ns2) ;
		System.out.println("-----------------");
		bubbleSort(ns3) ;
		System.out.println("-----------------");
		bubbleSort(ns4) ;
		System.out.println("-----------------");
		bubbleSort(ns5) ;
		System.out.println("-----------------");
		bubbleSort(ns6) ;
		System.out.println("-----------------");
		bubbleSort(ns7) ;
		System.out.println("-----------------");
		bubbleSort(ns8) ;
		System.out.println("-----------------");
		bubbleSort(ns9) ;
		System.out.println("-----------------");
	}

	public static void bubbleSort(int[] ns){

		//异常判断
		if(null ==ns || ns.length <=1){
			return;
		}
		System.out.println("-->" + Arrays.toString(ns));
		for(int i = ns.length; i >= 1; i--){
			for(int j = 1; j < i; j++){
				if(ns[j] < ns[j - 1]){
					ns[j] ^= ns[j - 1];
					ns[j - 1] ^= ns[j];
					ns[j] ^= ns[j - 1];
				}
			}
			System.out.println("-->" + Arrays.toString(ns));
		}
	}
}
