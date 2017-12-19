package com.qqmaster.com.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * @author zhaoshiquan 2017年12月19日 上午9:55:30
 *
 */
public class QuickSort {
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
		quickSort(ns1) ;
		System.out.println("-----------------");
		quickSort(ns2) ;
		System.out.println("-----------------");
		quickSort(ns3) ;
		System.out.println("-----------------");
		quickSort(ns4) ;
		System.out.println("-----------------");
		quickSort(ns5) ;
		System.out.println("-----------------");
		quickSort(ns6) ;
		System.out.println("-----------------");
		quickSort(ns7) ;
		System.out.println("-----------------");
		quickSort(ns8) ;
		System.out.println("-----------------");
		quickSort(ns9) ;
		System.out.println("-----------------");
	}

	public static void quickSort(int[] ns){
		//异常判断
		if(null ==ns || ns.length <=1){
			return;
		}
		System.out.println("-->" + Arrays.toString(ns));
		quickSort(ns, 0, ns.length - 1);
	}

	private static void quickSort(int[] ns, int start, int end){

		if(start >= end) 
			return;

		int i = start, j = end, key = ns[i];
		while(i < j){
			for(; i < j; j--){
				if(ns[j] < key){
					ns[j] ^= ns[i];
					ns[i] ^= ns[j];
					ns[j] ^= ns[i];
					break;
				}
			}

			for(; i < j; i++){
				if(ns[i] > key){
					ns[j] ^= ns[i];
					ns[i] ^= ns[j];
					ns[j] ^= ns[i];
					break;
				}
			}

		}
		System.out.println("-->" + Arrays.toString(ns));
		quickSort(ns,start, i-1);
		quickSort(ns,i + 1, end);
	}


}
