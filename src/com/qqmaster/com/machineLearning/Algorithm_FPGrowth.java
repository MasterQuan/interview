package com.qqmaster.com.machineLearning;

import java.util.List;

public class Algorithm_FPGrowth {


	
	
	class Header{
		
		private String name;
		private int count;
		private FPTreeNode fPTreeNode;
		
		Header(){}
		Header(String name, int count){
			this.setName(name);
			this.setCount(count);
		}
		
		public FPTreeNode getFPTreeNode() {
			return fPTreeNode;
		}
		public void setFPTreeNode(FPTreeNode fPTreeNode) {
			this.fPTreeNode = fPTreeNode;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
	}
	
	class FPTreeNode{
		private FPTreeNode father;
		private List<FPTreeNode> children;
		private int count = 0;
		
		public FPTreeNode getFather() {
			return father;
		}
		public void setFather(FPTreeNode father) {
			this.father = father;
		}
		public List<FPTreeNode> getChildren() {
			return children;
		}
		public void setChildren(List<FPTreeNode> children) {
			this.children = children;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
	}
}

