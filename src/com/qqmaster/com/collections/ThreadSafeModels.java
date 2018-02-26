package com.qqmaster.com.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSafeModels {
	public static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
	public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	public static LinkedBlockingQueue<Integer> quene = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) {
		list.add(6);
		list.add(7);
		list.add(9);
		list.add(8);
		
		System.out.println(list);
		
		
	}
}
