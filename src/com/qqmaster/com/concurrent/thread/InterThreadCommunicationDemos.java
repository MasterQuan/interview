package com.qqmaster.com.concurrent.thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class InterThreadCommunicationDemos {

//	public static void main(String[] args) {
//		SynchronizedDemos sdm1 = new SynchronizedDemos();
//		SynchronizedDemos sdm2 = new SynchronizedDemos();
//		
//		Thread t1 =new Thread(()->{
////			sdm1.synchronizedDemo1();
//			sdm1.synchronizedDemo2();
////			sdm1.synchronizedDemo3();
//		});
//		
//		Thread t2 =new Thread(()->{
////			sdm2.synchronizedDemo1();
//			sdm2.synchronizedDemo2();
////			sdm1.synchronizedDemo3();
//		});
//		
//		t1.start();
//		t2.start();
//		
//	}
	
	public static void main(String[] args) throws InterruptedException {
		WaitAndNotifyDemos blockQueue = new WaitAndNotifyDemos();
		Thread t1 = new Thread(()->{
			for(int i = 1; i<=15; i++){
				try {
					blockQueue.push(i);
					System.out.println("push " + i);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i = 1; i <=10; i++){
				try {
					System.out.println("pop " + blockQueue.pop());
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	private LinkedList<Integer> queue = new LinkedList<>();
	private final int capacity = 10;
	private final int empty = 0;
	
	public synchronized void push(int num) throws InterruptedException{
		if(queue.size() >= capacity){
			this.wait();
		}
		if(queue.size() == empty){
			this.notifyAll();
		}
		this.queue.addFirst(num);
	}
	
	public synchronized int pop() throws InterruptedException{
		if(queue.size() == empty){
			this.wait();
		}
		if(queue.size() < capacity){
			this.notifyAll();
		}
		return this.queue.removeLast();
	}
}

class VolatileDemos{
	
}