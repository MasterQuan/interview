package com.qqmaster.com.machineLearning;

import java.util.LinkedList;
import java.util.List;

/**
 * K-Means Clustering:
 * step: 1. random choose k samples as center of each Clustering.
 * step: 2. calculate distances of samples to each center, 
 * 			and cluster them into coresponding centers.
 * step: 3.recalculate all centers by obtaining the centroid of each cluster.
 * 			if all centers never change or several times have been iterated, 
 * 			stop the iteration and return results. Else continue step 2.
 * 			
 * @author zhaoshiquan 2018年1月24日 下午8:29:08
 *
 */
public class Algorithm_kMeans {	
	//最大迭代次数。
	public static final int MAX_ITER_TIMES = 10;
	
	public Clusters kMeans(int k, List<DataNode> samples){
		Clusters clusters = null;
		if(samples.size() < k){
			System.out.println("lack of samples!");
			return clusters;
		}
		
		double[][] centers = new double[k][];
		//初始化k个聚类的中心
		for(int i = 0; i < k; i++){
			centers[i] = samples.get(i).getFeatures();
		}
		
		for(int i = 0; i < MAX_ITER_TIMES; i++){
			clusters = clusterWithCenters(centers, samples);
			System.out.println("\n\nAfter " + (i+1) +"-th iterator:");
			System.out.println(clusters);
			if(!updateCenters(centers, clusters)) break;
		}
		return clusters;
	}
	
	/**
	 * cluster according to current centers.
	 * 
	 * @param centers
	 * @param samples
	 * @return
	 */
	private Clusters clusterWithCenters(double[][] centers, List<DataNode> samples){
		Clusters cluster = new Clusters(centers.length);
		samples.forEach(s->{
			double[] features = s.getFeatures();
			double min = Double.MAX_VALUE;
			int index = 0;
			for(int i =0; i < centers.length; i++ ){
				index = min > MLUtils.euclideanDistance(centers[i], features) ? i : index;
			}
			cluster.insertDataNodeIntoCluster(index, s);
		});
		return cluster;
	}
	
	/**
	 * update centers during each iterator.
	 * 
	 * @param centers
	 * @param clusters
	 * @return
	 */
	private boolean updateCenters(double[][] centers, Clusters clusters){
		boolean updated = false;
		for(int i = 0; i < centers.length; i++){
			if(!MLUtils.isSameArray(centers[i],reObtainCentroidForCluster(clusters.clusters[i])))
				updated = true;
		}
		return updated;
	}
	
	
	/**
	 * 计算每个簇上的样本的平均值作为当前簇的几何中心。
	 * @param cluster
	 * @return
	 */
	private double[] reObtainCentroidForCluster(List<DataNode> cluster){
		int dimension = cluster.get(0).getFeatures().length;
		int clusterSize = cluster.size();
		
		double[] newCentroid = new double[dimension];
		cluster.forEach(node->{
			double[] features = node.getFeatures();
			for(int i=0; i < dimension; i++){
				newCentroid[i] += features[i];
			}
		});
		
		for(int i=0; i < dimension; i++){
			newCentroid[i] /= clusterSize;
		}
		return newCentroid;
	}
	
	
	/**
	 * Object defined for Clustring results.
	 * @author zhaoshiquan 2018年1月24日 下午8:03:48
	 *
	 */
	class Clusters{
		private int k = 1;
		private List<DataNode>[] clusters;
		
		Clusters(int k){
			this.k = k;
			this.clusters = new LinkedList[k];
		}

		public int getK() {
			return k;
		}

		public void setK(int k) {
			this.k = k;
		}

		public List<DataNode>[] getClusters() {
			return clusters;
		}

		public void setClusters(List<DataNode>[] clusters) {
			this.clusters = clusters;
		}

		@Override
		public String toString() {
			return "Clusters [k=" + k + ", clusters=" + clusters + "]";
		}
		
		public void insertDataNodeIntoCluster(int k, DataNode node){
			this.clusters[k].add(node);
		}

	}
}

