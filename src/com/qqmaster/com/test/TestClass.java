package com.qqmaster.com.test;

public class TestClass {
	public static void main(String[] args) {
		
//		for(int i= 0; i< 10; i++){
//			int sum = i*i + (i + 1) *(i+1);
//			System.out.println(sum);
//			System.out.println(Math.sqrt(sum));
//			System.out.println((int)Math.sqrt(sum));
//			System.out.println(Math.pow(i, 2));
//			System.out.println();
//		}
		
//		int sum = 26*26 + 27*27;
//		System.out.println(sum);
//		System.out.println(37*37);
//		System.out.println((int) Math.sqrt(sum));
//		
//		int sum1 = 1*1 + 36 * 36;
//		System.out.println(sum1);
//		System.out.println(36*36);
//		System.out.println((int) Math.sqrt(sum1));
		
//		System.out.println(335*335 + 336*336);
//		System.out.println(335*335 + 337*337);
//		System.out.println(335*335 + 4444*4444);
		
		int a = 13, b = 14;
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println(a + "   " + b);
	}
}
