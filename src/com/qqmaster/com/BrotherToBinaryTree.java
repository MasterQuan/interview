package com.qqmaster.com;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author zhaoshiquan 2017年12月7日 下午5:35:51
 *
 */
public class BrotherToBinaryTree {
	
	
	
	public static Node doBrother(Node t){
		Queue<Node> q = new ArrayDeque<Node>();
		if(t == null){
			q.add(t);
		}else {
			return t;
		}
		
		Node nt = new Node();
		while(!q.isEmpty()){
			Node mid = q.poll();
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

class Node{
	public Node right;
	public Node left;
	public Node brother;
}
