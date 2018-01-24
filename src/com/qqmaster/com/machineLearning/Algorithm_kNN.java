package com.qqmaster.com.machineLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * kNN算法思想：
 * 找出与当前节点距离（这里用最简单的欧式距离）最近的k个节点，然后通过这k的节点的所属类型进行投票分类。少数服从多数。
 * 约定原始数据为等长度的double类型数组，最后一位表示数据的class类别属性（默认二分类0，1）
 * @author zhaoshiquan 2018年1月24日 下午2:25:12
 *
 */
public class Algorithm_kNN {
	public static double pos = 1.0;
	public static double neg = 0.0;

	public static void main(String[] args) {
		//测试数据
		List<double[]> train = new ArrayList<>();
		double[] t1 = {1,1,1,1,1};
		double[] t2 = {1,2,1,0,0};
		double[] t3 = {1,3,1,3,1};
		double[] t4 = {1,2,4,1,0};
		double[] t5 = {1,0,5,1,0};
		double[] t6 = {1,0,9,1,0};
		double[] t7 = {1,1,2,1,1};
		double[] t8 = {1,4,1,1,0};
		double[] t9 = {1,5,0,1,1};
		double[] t10 = {1,8,4.5,1,1};
		train.add(t1);
		train.add(t2);
		train.add(t3);
		train.add(t4);
		train.add(t5);
		train.add(t6);
		train.add(t7);
		train.add(t8);
		
		double[] s1 = {0.0,0.0,0.0,1};
		double[] s2 = {2,6,3,1};
		double[] s3 = {1,1,2,0};
		
		Algorithm_kNN knn = new Algorithm_kNN();
		System.out.println(knn.kNN(train,s1,5));
		System.out.println(knn.kNN(train,s2,7));
		System.out.println(knn.kNN(train,s3,10));
		
	}

	public List<Res_Node> kNN(List<double[]> train, List<double[]> sample, int k){
		LinkedList<Res_Node> list = new LinkedList<Res_Node>();
		sample.forEach(s->{
			list.add(kNN(train, s, k));
		});
		return null;
	}
	
	public Res_Node kNN(List<double[]> train, double[] sample, int k){
		LinkedList<KNN_Node> list = new LinkedList<KNN_Node>();
		train.forEach(t->{
			insertNode(list, new KNN_Node(euclideanDistance(t, sample),t[t.length - 1]),k);
		});
		return getResult(list);
	}
	

	//欧式距离的计算
	private double euclideanDistance(double[] train, double[] sample){
		double sum = 0;
		int length = sample.length==train.length ? sample.length-1 : sample.length;
		for(int i = 0; i < length; i++){
			sum += (sample[i] - train[i]) * (sample[i] - train[i]);
		}
		return sum;
	}

	//维护一个大小为k的有序的中间节点链表（根据distance排序）
	private void insertNode(LinkedList<KNN_Node> list, KNN_Node node, int k){

		//插入排序，并移除最后一个节点
		int orig = list.size();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).dist >= node.dist){
				list.add(i, node);
				break;
			}
		}

		//判断当前节点是否加入list中
		if(orig == list.size())
			list.addLast(node);

		//判断list是否超过长度k
		if(list.size() > k){
			list.removeLast();
		}
	}

	//获取分类结果
	private Res_Node getResult(LinkedList<KNN_Node> list){
		int count_pos = 0;
		for(KNN_Node n:list){
			if(n.label > 0.5)
				count_pos++;
		}
		double conf = 1.0 * count_pos / list.size();
		return conf>=0.5 ? new Res_Node(pos,conf) : new Res_Node(neg, 1 - conf); 
	}


	class KNN_Node{
		double dist = Double.MAX_VALUE;
		double label;
		public KNN_Node(double dist, double label){
			this.dist = dist;
			this.label = label;
		}
	}

	class Res_Node{

		public double label = neg;

		/**
		 * confidence表示当前样本分类为label的置信度
		 */
		public double confidence = pos;

		public Res_Node(double label, double confidence){
			this.label = label;
			this.confidence = confidence;
		}

		@Override
		public String toString() {
			return "Res_Node [label=" + label + ", confidence=" + confidence + "]";
		}
	}

}
