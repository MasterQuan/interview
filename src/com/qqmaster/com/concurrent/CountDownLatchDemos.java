package com.qqmaster.com.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemos {
	public static void main(String[] args) throws InterruptedException {	
		CountDownLatch latch = new CountDownLatch(3);
		System.out.println("all thread is start");
		System.out.println("count->" + latch.getCount());

		new Thread(()->{
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("count->" + latch.getCount());
			System.out.println("all pre-thread is finished");
		}).start();
		
		new Thread(()->{
			System.out.println("Thread 1 process...");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			latch.countDown();
			System.out.println("Thread 1 count->" + latch.getCount());

		}).start();	
		
		new Thread(()->{
			System.out.println("Thread 2 process...");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
			System.out.println("Thread 2 count->" + latch.getCount());

		}).start();	
		
		new Thread(()->{
			System.out.println("Thread 3 process...");
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
			System.out.println("Thread 3 count->" + latch.getCount());

		}).start();	
		
	}
}
