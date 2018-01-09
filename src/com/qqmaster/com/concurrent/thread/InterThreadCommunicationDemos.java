package com.qqmaster.com.concurrent.thread;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class InterThreadCommunicationDemos {

	public static void main(String[] args) {
		SynchronizedDemos sdm1 = new SynchronizedDemos();
		SynchronizedDemos sdm2 = new SynchronizedDemos();
		
		Thread t1 =new Thread(()->{
//			sdm1.synchronizedDemo1();
			sdm1.synchronizedDemo2();
//			sdm1.synchronizedDemo3();
		});
		
		Thread t2 =new Thread(()->{
//			sdm2.synchronizedDemo1();
			sdm2.synchronizedDemo2();
//			sdm1.synchronizedDemo3();
		});
		
		t1.start();
		t2.start();
		
	}
	
}

class ReentrantLockDemos{
	ReentrantLock lock1 = new ReentrantLock();
	
	
	
	ReentrantLock lock2 = new ReentrantLock(true);
	
}

class SynchronizedDemos{
	
	private int index = 0;
	private static int index2 = 0;
	
	//non-static synchronized method, lock the 'this' Object.
	public synchronized void synchronizedDemo1(){
		index ++;
		System.out.println(new Date().getTime() + ":" + Thread.currentThread().getName() 
				+ "--index : " + index);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//static synchronized method, lock the Class
	public static synchronized void synchronizedDemo2(){
		index2 ++;
		System.out.println(new Date().getTime() + ":" + Thread.currentThread().getName() 
				+ "--index2 : " + index2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void synchronizedDemo3(){
		
		//synchronized block, lock the 'this' Object
		synchronized (this) {
			index ++;
			System.out.println(new Date().getTime() + ":" + Thread.currentThread().getName() 
					+ "--synchronized block methods and index : " + index);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class WaitAndNotifyDemos{
	
}

class VolatileDemos{
	
}