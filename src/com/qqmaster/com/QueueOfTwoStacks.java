package com.qqmaster.com;

import java.util.Stack;

public class QueueOfTwoStacks {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		//pop stack2 and push into stack1,then push
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}

	public int pop() {
		//pop stack1 and push into stack2,then pop;
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}
