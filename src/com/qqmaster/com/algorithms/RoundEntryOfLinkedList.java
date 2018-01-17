package com.qqmaster.com.algorithms;

import com.qqmaster.com.structure.ListNode;

public class RoundEntryOfLinkedList {
	
	public ListNode getRoundEntryOfLinkedList(ListNode list){
		ListNode entry = null;
		
		//异常输入判断
		if(list == null)
			return entry;
		
		ListNode l1 = list,l2 = list;
		for(; l2!= null && l2.next != null;l1 = l1.next, l2 = l2.next.next){
			if(l1 == l2)
				break;
		}
		//判断是否无环
		if(l2 == null || l2.next == null)
			return entry;
		
		//获取环的入口
		for(entry = list; entry!= l1;){
			entry = entry.next;
			l1 = l1.next;
		}
		return entry;
	}

}
