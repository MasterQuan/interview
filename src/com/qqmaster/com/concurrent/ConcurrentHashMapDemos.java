package com.qqmaster.com.concurrent;

public class ConcurrentHashMapDemos {
	public static void main(String[] args) {
//		System.out.println("spread->" + ConcurrentMethods.spread(100));
//		System.out.println("spread->" + ConcurrentMethods.spread(100001013));
//		System.out.println("spread->" + ConcurrentMethods.spread(888888888));
//		System.out.println("spread->" + ConcurrentMethods.spread(123456789));
//		System.out.println("spread->" + ConcurrentMethods.spread(2147483647));
		
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(0));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(1));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(2));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(4));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(8));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(9));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(10));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(64));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(1024));
		System.out.println("size->" + ConcurrentMethods.tableSizeFor(1025));
		
	}
}

class ConcurrentMethods{
	static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
	private static final int MAXIMUM_CAPACITY = 1 << 30;


	public static final int spread(int h) {
		return (h ^ (h >>> 16)) & HASH_BITS;
	}
	
	public static final int tableSizeFor(int c) {
        int n = c - 1;
        System.out.println("n->" + n);
        n |= n >>> 1;
        System.out.println("n->" + n);
        n |= n >>> 2;
        System.out.println("n->" + n);
        n |= n >>> 4;
        System.out.println("n->" + n);
        n |= n >>> 8;
        System.out.println("n->" + n);
        n |= n >>> 16;
        System.out.println("n->" + n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
