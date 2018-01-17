package com.qqmaster.com.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemos {
	
	public static void main(String[] args) {
		
		ReentrantLockObj obj = new ReentrantLockObj();
		
		new Thread(()->{
			obj.increase();
		}).start();
		
		new Thread(()->{
			obj.increase();
		}).start();
		
		new Thread(()->{
			obj.decrease();
		}).start();
		
		System.out.println(obj.count);
	}

}

class ReentrantLockObj{
	public static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	public void increase(){
		lock.lock();
		try{
			count++;
			System.out.println("incr" + count);
		}finally {
			lock.unlock();
			System.out.println("incr_unlock");
		}
	}
	
	public void decrease(){
		lock.lock();
		try{
			count--;
			System.out.println("desc" + count);
		}finally {
			lock.unlock();
			System.out.println("desc_unlock");
		}
	}
}
