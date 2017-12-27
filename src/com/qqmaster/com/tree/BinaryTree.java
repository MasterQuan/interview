package com.qqmaster.com.tree;

import java.util.LinkedList;

import com.qqmaster.com.structure.TreeNode;

public class BinaryTree {
	
	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		
		root.right = new TreeNode(7);
		
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(9);
		
		root.right.right.left = new TreeNode(10);
		
//		System.out.println("先序遍历（递归）--->");
//		preOrderTraverse1(root);
//		
//		System.out.println("先序遍历（非递归）--->");
//		preOrderTraverse2(root);
		
//		System.out.println("中序遍历（递归）--->");
//		inOrderTraverse1(root);
//		
//		System.out.println("中序遍历（非递归）--->");
//		inOrderTraverse2(root);
		
		//二叉树的高度
//		System.out.println(getHeight(root));
		
		//是否平衡二叉树
		System.out.println(isBalanceTree(root));
		
		
	}

	//先序遍历（递归）
	public static void preOrderTraverse1(TreeNode root){
		if(root != null){
			System.out.println(root.value);
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
	}

	//先序遍历（非递归）
	public static void preOrderTraverse2(TreeNode root){
		if(root != null){
			System.out.println(root.value);
			LinkedList<TreeNode> stack = new LinkedList<>();
			
			if(root.right != null){
				stack.push(root.right);
			}
			
			if(root.left != null){
				stack.push(root.left);	
			}
			
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				System.out.println(node.value);
				
				if(node.right != null){
					stack.push(node.right);
				}
				
				if(node.left != null){
					stack.push(node.left);	
				}
				
			}
		}
	}

	
	//中序遍历（递归）
	public static void inOrderTraverse1(TreeNode root){
		if(root != null){
			inOrderTraverse1(root.left);
			System.out.println(root.value);
			inOrderTraverse1(root.right);
		}
	}

	//中序遍历（非递归）
	public static void inOrderTraverse2(TreeNode root){
		TreeNode node = root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		
		while(node != null || !stack.isEmpty()){
			if(node != null){
				stack.push(node);
				node = node.left;
			}else{
				TreeNode sNode = stack.pop();
				System.out.println(sNode.value);
				node = sNode.right;
			}
		}
	}

	//后序遍历（递归）
	public static void postOrderTraverse1(TreeNode root){
		if(root != null){
			postOrderTraverse1(root.left);
			postOrderTraverse1(root.right);
			System.out.println(root.value);
		}
	}

	//后序遍历（递归）
	public static void postOrderTraverse2(TreeNode root){
		
	}

	//层次遍历（非递归）
	public static void levelTraverse(TreeNode root){
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

	//获取二叉树的深度
	public static int getHeight(TreeNode root){
		if(root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	//判断平衡二叉树
	public static boolean isBalanceTree(TreeNode root){
		if(root == null)
			return true;
		int diffHeight = Math.abs(getHeight(root.left) - getHeight(root.right));
		if(diffHeight > 1){
			return false;
		}else return isBalanceTree(root.left) && isBalanceTree(root.right);
	}
	//判断平衡二叉树2
	
	public static boolean isBalanceTree2(TreeNode root){
		if(getDepth(root) == -1){
            return false;
        }return true;
	}
	
	private static int getDepth(TreeNode root){
        if(root == null) return 0;
        
        int leftDepth = getDepth(root.left);
        if(leftDepth == -1) return -1;
        
        int rightDepth = getDepth(root.right);
        if(rightDepth == -1) return -1;
        
        if(Math.abs(rightDepth - leftDepth) > 1){ 
            return -1;
        }else return Math.max(rightDepth, leftDepth) + 1;
    }

	
	//构建完全二叉树	
	public static TreeNode buildCompleteTree(int[] nums){
		if(nums == null || nums.length < 1)
			return null;
		int count = nums.length;
		TreeNode[] nodes = new TreeNode[count];
		for(int i = 0; i < count; i++){
			nodes[i] = new TreeNode(nums[i]);
		}
		for(int temp = 0; temp <= (nums.length - 2) / 2; temp++){
			if(temp << 1 + 1 < nums.length)
				nodes[temp].left = nodes[temp << 1 + 1];
			if(temp << 1 + 2 < nums.length)
				nodes[temp].right = nodes[temp << 1 + 2];
		}
		return nodes[0];
	}

	//AVL树

	//堆
	
	//是否是对称树
	public static boolean isSymmetrical(TreeNode root){
		if(root == null)
			return true;
		return sameNode(root.left, root.brother.right);
	}
 	
	private static boolean sameNode(TreeNode pRoot, TreeNode qRoot){
        if( pRoot == null && qRoot == null) return true;
        if( pRoot == null && qRoot != null) return false;
        if( pRoot != null && qRoot == null) return false;
        
        if(pRoot.value == qRoot.value){
            return sameNode(pRoot.right, qRoot.left) && sameNode(qRoot.right, pRoot.left);
        }else 
        	return false;
    }

	//镜像二叉树
	
}
