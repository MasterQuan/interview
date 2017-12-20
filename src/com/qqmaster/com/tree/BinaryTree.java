package com.qqmaster.com.tree;

import java.util.LinkedList;

public class BinaryTree {

	class TreeNode{
		public int value;

		public TreeNode right;
		public TreeNode left;
	}

	//先序遍历（递归）
	public void preOrderTraverse1(TreeNode root){
		if(root != null){
			System.out.println(root.value);
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
	}

	//先序遍历（非递归）
	public void preOrderTraverse2(TreeNode root){
		
	}

	
	//中序遍历（递归）
	public void inOrderTraverse1(TreeNode root){
		if(root != null){
			inOrderTraverse1(root.left);
			System.out.println(root.value);
			inOrderTraverse1(root.right);
		}
	}

	//中序遍历（非递归）
	public void inOrderTraverse2(TreeNode root){

	}

	//后序遍历（递归）
	public void postOrderTraverse1(TreeNode root){
		if(root == null){
			postOrderTraverse1(root.left);
			postOrderTraverse1(root.right);
			System.out.println(root.value);
		}
	}

	//后序遍历（递归）
	public void postOrderTraverse2(TreeNode root){

	}

	//层次遍历（非递归）
	public void levelTraverse(TreeNode root){
		if(root == null)
			return;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.println(node.value);
			if(node.left!= null){
				queue.offer(node.left);
			}
			if(node.right != null){
				queue.offer(node.right);
			}
		}

	}

	//判断平衡二叉树

	//二叉排序树

	//AVL树

	//堆

}
