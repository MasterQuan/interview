package com.qqmaster.com.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zhaoshiquan 2017年12月6日 下午8:03:25
 *
 */
public class SumOfThreeNums {

	public static void main(String[] args) {
		int a[] = {-1,-1,-1};
		int b[] = {0,0,2,3,2};
		int c[] = {-1,-1,0,0,0};
		int d[] = {-1,-1,0,1,0,7};
		int e[] = {-1,0,1,2,-1,-4};
		
		System.out.println(sumOfThreeNums(a));
		System.out.println("---------------");
		System.out.println(sumOfThreeNums(b));
		System.out.println("---------------");
		System.out.println(sumOfThreeNums(c));
		System.out.println("---------------");
		System.out.println(sumOfThreeNums(d));
		System.out.println("---------------");
		System.out.println(sumOfThreeNums(e));
	}
	
	
	/*
	 * 给出一个有 n 个整数的数组 S，在 S 中找到三个整数 a, b, c，
	 * 使得 a + b + c = 0。写一个函数找到所有满足要求的三元组。
	 * 注意事项：
	 * 在三元组(a, b, c)，要求a <= b <= c。结果不能包含重复的三元组。
	 */

	public static Set<String> sumOfThreeNums(int[] S){
		//存放结果，防止重复
		Set<String> set = new HashSet<>();

		//定义必须数据结构
		List<Integer> stNums = new LinkedList<Integer>();

		//预处理数据
		int countZero = insertSortAndCount0(S,stNums);
		
		int stSize = stNums.size();
		int pos = findPos(stNums);

		//处理结果
		if(countZero >=3)
			set.add("(0,0,0)");
		
		if(pos == 0){
			return set;
		}
		//两负一正组合
		for(int i = 0; i < pos - 1; i++){
			
			for(int j = i + 1; j < pos; j++){
				for(int k = pos; k < stSize; k++){
					if(stNums.get(i) + stNums.get(j) + stNums.get(k) >0 )
						break;
					if(stNums.get(i) + stNums.get(j) + stNums.get(k) == 0 ){
						set.add("("+ stNums.get(i) + "," + stNums.get(j) + "," + stNums.get(k) + ")");
					}
				}
			}
		}
		
		//一负两正组合
		for(int i=0; i<pos; i++){
			for(int j = pos; j < stSize - 1; j ++){
				for(int k = j + 1; k < stSize; k++){
					if(stNums.get(i) + stNums.get(j) + stNums.get(k) >0 )
						break;
					if(stNums.get(i) + stNums.get(j) + stNums.get(k) == 0 ){
						set.add("("+ stNums.get(i) + "," + stNums.get(j) + "," + stNums.get(k) + ")");
					}
				}
			}
		}
		
		//一负一正组合
		for(int i = 0; countZero > 0 && i < pos; i++){
			for(int j = pos; j < stSize; j++){
				if(stNums.get(i) + stNums.get(j)>0 )
					break;
				if(stNums.get(i) + stNums.get(j)== 0 ){
					set.add("("+ stNums.get(i) + ",0," + stNums.get(j) + ")");
				}
			}
		}
		
		return set;
	}

	private static int insertSortAndCount0(int[] nums, List<Integer> stNums){
		int countZero = 0; 
		for(int num:nums){
			if(num == 0){
				//计算0的个数，并不插入数组中
				countZero++;
			}else{
				//新list为空，直接插入
				if(stNums.size() == 0){
					stNums.add(num);
				}else{
					//找到适合位置插入
					int i = 0;
					for(; i<stNums.size(); i++){
						if(stNums.get(i) >= num){
							stNums.add(i, num);
							break;
						}
					}
					//如果没有,插入末尾
					if(i == stNums.size()){
						stNums.add(num);
					}
				}
			}
		}

		return countZero;
	}
	
	private static int findPos(List<Integer> stNums){
		int pos = 0;
		
		for(int i = 0; i < stNums.size(); i++){
			if(stNums.get(i) > 0){
				pos = i; break;
			}
		}
		return pos;
	}
}
