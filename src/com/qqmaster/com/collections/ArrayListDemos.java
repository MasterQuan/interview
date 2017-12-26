package com.qqmaster.com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemos {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println("list->" + list);
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println("list->" + list);
		System.out.println("isEmpty: " + list.isEmpty());
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println("oter:" + it.next());
		}
		System.out.println("contains: " + list.contains(4));
		System.out.println("toArray: " + Arrays.toString(list.toArray()));
		list.add(1, 88);
		System.out.println("list->" + list);
		list.forEach(i->{
			System.out.println("forEach: " + i);
		});
	}

}
