package com.qqmaster.com;

/**
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 * 注意事项
 * 		1、如果两个链表没有交叉，返回null。
 * 		2、在返回结果后，两个链表仍须保持原有的结构。
 * 		3、可假定整个链表结构中没有循环。
 * 格式：
 * 		第一行输入两个链表 A 和 B，最后输出两个链表的交叉节点。
 * 样例输入
 * A:          a1 → a2
 *                   ↘
 *                    c1 → c2 → c3
 *                   ↗            
 * B:     b1 → b2 → b3
 * 样例输出
 * 		c1
 * 
 * @author zhaoshiquan 2017年12月13日 下午3:36:19
 *
 */
public class IntersectionOfList {
	public static ListNode findIntersectionOfList(ListNode l1, ListNode l2 ){
		ListNode intersect = null;
		
		//特殊情况判断
		if(l1 == null || l2 == null){
			return intersect;
		}
		
		int len1 = 0, len2 = 0;
		ListNode s1 = l1, s2 = l2;
		
		//假定链表无环(有环的，可以先找到环的入口点，然后再做相应处理，具体可见另一个类)
		for(;s1!=null; s1 = s1.next)
			len1++;
		for(;s2!=null; s2 = s2.next)
			len2++;
		
		s1 = l1;
		s2 = l2;
		if(len1 > len2){
			for(int i=1; i<= Math.abs(len1 - len2); i++)
				s1 = s1.next;
		}else{
			for(int i=1; i<= Math.abs(len1 - len2); i++)
				s2 = s2.next;
		}
		
		while(s1 != null){
			if(s1 == s2){
				intersect = s1;
				break;
			}
			s1 = s1.next;
			s2 = s2.next;
		}
		return intersect;
	}
}
