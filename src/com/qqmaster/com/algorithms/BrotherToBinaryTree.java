package com.qqmaster.com.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

import com.qqmaster.com.structure.TreeNode;

/**
 * 
 * @author zhaoshiquan 2017年12月7日 下午5:35:51
 *
 */
public class BrotherToBinaryTree {
	
	public static TreeNode doBrother(TreeNode t){
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		if(t == null){
			q.add(t);
		}else {
			return t;
		}
		
		TreeNode nt = new TreeNode();
		while(!q.isEmpty()){
			TreeNode mid = q.poll();
			nt.brother = mid;
			
			if(mid.left != null){
				q.add(mid.left);
			}
			
			if(mid.right != null){
				q.add(mid.right);
			}
		}
		
		return nt;
	}
}

