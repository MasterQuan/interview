package com.qqmaster.com.machineLearning;

public class MLUtils {
	
	/**
	 *	计算两个特征向量之间的欧式距离（未开方，降低计算复杂度）
	 * @param features1
	 * @param features2
	 * @return
	 */
	public static double euclideanDistance(double[] features1, double[] features2){
		double sum = 0;
		int length = features2.length;
		for(int i = 0; i < length; i++){
			sum += Math.pow(features1[i] - features2[i], 2);
		}
		return sum;
	}

	/**
	 * 判断连个特征向量每个特征是否一样
	 * @param features1
	 * @param features2
	 * @return
	 */
	public static boolean isSameArray(double[] features1, double[] features2){
		int len = features1.length;
		
		if(len != features2.length)
			return false;
		
		for(int i=0; i<len; i++){
			if(features1[i] != features2[i])
				return false;
		}
		return true;
	}
}
