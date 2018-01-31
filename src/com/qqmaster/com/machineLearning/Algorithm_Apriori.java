package com.qqmaster.com.machineLearning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qqmaster.com.machineLearning.node.AprioriNode;

public class Algorithm_Apriori {

	public static void main(String[] args) {
		List<AprioriNode> data = new ArrayList<AprioriNode>();
		String[] names = {"p1", "p2", "P3", "P4", "P5"};
		AprioriNode.attNames = names;
		
		AprioriNode d0 = new AprioriNode();
		boolean[] f0 = {true,true,false,false,true};
		d0.setFeatures(f0);
		
		AprioriNode d1 = new AprioriNode();
		boolean[] f1 = {false,true,false,true,false};
		d1.setFeatures(f1);
		
		AprioriNode d2 = new AprioriNode();
		boolean[] f2 = {false,false,true,true,false};
		d2.setFeatures(f2);
		
		AprioriNode d3 = new AprioriNode();
		boolean[] f3 = {true,true,false,true,false};
		d3.setFeatures(f3);
		
		AprioriNode d4 = new AprioriNode();
		boolean[] f4 = {true,false,true,false,false};
		d4.setFeatures(f4);
		
		AprioriNode d5 = new AprioriNode();
		boolean[] f5 = {false,true,true,false,false};
		d5.setFeatures(f5);
		
		AprioriNode d6 = new AprioriNode();
		boolean[] f6 = {true,false,true,false,false};
		d6.setFeatures(f6);
		
		AprioriNode d7 = new AprioriNode();
		boolean[] f7 = {true,true,true,false,true};
		d7.setFeatures(f7);
		
		AprioriNode d8 = new AprioriNode();
		boolean[] f8 = {true,true,true,false,false};
		d8.setFeatures(f8);
		
		data.add(d0);
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);
		data.add(d6);
		data.add(d7);
		data.add(d8);
		for(double support = 0.1;support <= 0.9; support += 0.1){
			System.out.println("support -> " + support);
			Algorithm_Apriori apriori = new Algorithm_Apriori();
			System.out.println("\nFrequent Items -> " + apriori.aprior(data, support));
			System.out.println("\n--------------------------------\n");
		}
		
	}
	
	/**
	 * Aprior 算法入口
	 * 
	 * @param data
	 * @param support
	 * @return
	 */
	public List<Set<Integer>> aprior(List<AprioriNode> data, double support){
		List<Set<Integer>> freqItems = new ArrayList<Set<Integer>>();
		
		//1. 获取meta items
		List<Set<Integer>> metaItems = metaFreqItems(data, support);
		
		//2. 迭代的获取item集合超集合。
		do{
			freqItems.addAll(metaItems);
			System.out.println("step--" + freqItems);
			metaItems = supFreItems(data, metaItems, support);
		}while(metaItems != null && !metaItems.isEmpty());
		
		return freqItems;
	}

	/**
	 * 初始化meta item项集，并根据support进行筛选，剪枝
	 * 
	 * @param data
	 * @param support
	 * @return
	 */
	private List<Set<Integer>> metaFreqItems(List<AprioriNode> data, 
			double support){

		List<Set<Integer>> metaItems = new ArrayList<Set<Integer>>();

		for(int i=0; i < AprioriNode.attNames.length; i++){
			Set<Integer> set = new HashSet<Integer>();
			set.add(i);
			metaItems.add(set);
		}
		rmWithSupport(data, metaItems,support);
		
		return metaItems;
	}

	/**
	 * 
	 * @param data
	 * @param supFreItems
	 * @param support
	 * @return
	 */
	private List<Set<Integer>> supFreItems(List<AprioriNode> data, 
			List<Set<Integer>> subFreItems, 
			double support){
		if(subFreItems == null || subFreItems.size()<=1){
			return null;
		}

		int size = subFreItems.size();
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();

		for(int i = 0; i < size - 1; i++){
			for(int j = i + 1; j < size; j++){
				Set<Integer> s = mergeSet(subFreItems.get(i), 
						subFreItems.get(j));
				if(s!=null)
					if(!list.contains(s))
						list.add(s);
			}
		}
		rmWithSupport(data,list,support);
		return list;
	}

	/**
	 * 求两个集合的并集
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	private Set<Integer> mergeSet(Set<Integer> set1, Set<Integer> set2){
		if(set1 == null || set2 == null)
			return null;
		Set<Integer> newSet = new HashSet<>(set1);
		set2.forEach(it -> {
			newSet.add(it);
		});
		if(newSet.size() > set1.size() + 1)
			return null;
		return newSet;
	}

	
	/**
	 * 根据支持度，移除不满足支持度的项集
	 * 
	 * @param data
	 * @param items
	 * @param support
	 * @return
	 */
	private void rmWithSupport(List<AprioriNode> data,
			List<Set<Integer>> items, 
			double support){

		for(int i = items.size() - 1; i >= 0; i--){
			if(support(data, items.get(i)) < support)
				items.remove(i);
		}
	}


	/**
	 * 获取指定item项集的支持度-support
	 * @return
	 */
	private double support(List<AprioriNode> data, Set<Integer> items){
		if(data == null || data.size() < 1)
			return 0.0;

		int count = 0;
		for(AprioriNode d:data){
			if(isFreqItems(d.getFeatures(), items)) count++;
		}

		return 1.0 * count / data.size();
	}


	/**
	 * 判断集合是否中的item是否均命中。
	 * 
	 * @param features
	 * @param items
	 * @return
	 */
	private boolean isFreqItems(boolean[] features, Set<Integer> items){

		if(items == null || items.size() < 1) return false;

		for(Integer i : items)
			if(!features[i])  return false;

		return true;
	}
}

