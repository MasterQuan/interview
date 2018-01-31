package com.qqmaster.com.machineLearning.node;

import java.util.Arrays;

public class DataNode {
	private String id;
	private double[] features;
	private String label;
	public static String attNames;
	
	public DataNode(){}
	
	public DataNode(String id, double[] features, String label){
		this.id = id;
		this.features = features;
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double[] getFeatures() {
		return features;
	}

	public void setFeatures(double[] features) {
		this.features = features;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "DataNode [id=" + id + ", features=" + Arrays.toString(features) + ", label=" + label + "]";
	}

}
