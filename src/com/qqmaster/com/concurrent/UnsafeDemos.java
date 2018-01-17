package com.qqmaster.com.concurrent;

import sun.misc.Unsafe;

public class UnsafeDemos {

}


class SyncObj{
	public static int count;
	public static final long countOffset;
	public static final Unsafe unsafe = Unsafe.getUnsafe();
	
	static{
		
		try {
			countOffset = unsafe.objectFieldOffset(SyncObj.class.getDeclaredField("count"));
		} catch (Exception ex) { throw new Error(ex); }
	}
	
	public int  atomicInc(int num){
		for(;;){
			if(unsafe.compareAndSwapInt(this,countOffset, 1, 0)){
				return 0;
			}
			
		}
	}
	
	
}