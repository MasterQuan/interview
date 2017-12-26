package com.qqmaster.com.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemos {
	public static void main(String[] args) {

		LinkedList<Integer> queue = new LinkedList<>();

		System.out.println("-->as queue:");
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.offer(5);
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);

		System.out.println("-------------------------");
		LinkedList<Integer> stack = new LinkedList<>();
		System.out.println("-->as stack:");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(5);
		stack.push(6);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		System.out.println("-------------------------");

		stack.forEach(i->{
			System.out.println(i+"--");
		});
		System.out.println("-------------------------");

		for( Iterator<Integer> it = stack.iterator(); it.hasNext();){
			System.out.println("== " + it.next());
		}

		System.out.println("----------------------------");
		System.out.println("common methods:");
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		System.out.println("-->" + list.remove());
		System.out.println(list);
		System.out.println("isEmpty: " + list.isEmpty());
		System.out.println("size: " + list.size());
		System.out.println("peek: " + list.peek());
		System.out.println("peekFirst: " + list.peekFirst());
		System.out.println("peekLast: " + list.peekLast());
		System.out.println(list);
	}
}
