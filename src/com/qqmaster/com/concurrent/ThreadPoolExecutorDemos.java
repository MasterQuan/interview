package com.qqmaster.com.concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemos {
	public static void main(String[] args) {
		newCachedThreadPoolDemos();
//		newFixedThreadPoolDemos();
//		newSingleThreadExecutorDemos();
//		newScheduledThreadPoolDemos();
	}
	
	
	/**
	 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，
	 * 可灵活回收空闲线程，若无可回收，则新建线程。线程池为无限大，当执行第二个
	 * 任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
	 * 示例代码如下：
	 */
	public static void newCachedThreadPoolDemos(){

		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++){
			final int index = i;
//			try{
//				Thread.sleep(index * 100);
//			}catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			pool.submit(()->{
				System.out.println("submit->" + index);
				return null;
			});
//			pool.execute(()->{
//				System.out.println("execute->" + index);
//			});
		}
		System.out.println("------------------------------");
		
//		for(int i = 0; i < 10; i++){
//			final int index = i;
//			pool.submit(()->{
//				System.out.println("submit->" + index);
//			});
//		}
		pool.shutdown();
		pool.shutdownNow();
		System.out.println("isShutdown: " + pool.isShutdown());
		
		try {
			pool.execute(()->{
				System.out.println("after shutdown~~");
			});
		} catch (Exception e) {
			System.out.println("Exception after shutdown~~~~" + e.getMessage());
		}
		
	}
	
	/**
	 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
	 * 定长线程池的大小最好根据系统资源进行设置。
	 */
	public static void newFixedThreadPoolDemos(){
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 10; i++){
			final int index = i;
			pool.execute(()->{
				System.out.println("execute" + index);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Exception during sleep->" + e.getMessage());
				}
			});
		}
		System.out.println("isShutdown: " + pool.isShutdown() + "   isTerminated: " + pool.isTerminated());
		pool.shutdown();
//		pool.shutdownNow();
		System.out.println("isShutdown: " + pool.isShutdown() + "   isTerminated: " + pool.isTerminated());

		
		try {
			Thread.sleep(10000);
			System.out.println("isShutdown: " + pool.isShutdown() + "   isTerminated: " + pool.isTerminated());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
	 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	 * (可通过实现ThreadFactory来实现，newSingleThreadExecutor(ThreadFactory threadFactory))。
	 */
	public static void newSingleThreadExecutorDemos(){
		ExecutorService pool = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 10; i++){
			final int index = i;
			pool.execute(()->{
				System.out.println("execute -> " + index);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					System.out.println("Exception during sleep: " + e.getMessage());
				}
			});
		}
		pool.shutdown();
	}
	
	/**
	 * 创建一个定长线程池，支持定时及周期性任务执行。
	 */
	public static void newScheduledThreadPoolDemos(){
		System.out.println("start ... " + new Date());
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		//表示延迟3秒执行
//		pool.schedule(()->{
//			System.out.println("delay 3 seconds...");
//		}, 3, TimeUnit.SECONDS);
		
		//延迟10秒后每3秒执行一次
		pool.scheduleWithFixedDelay(()->{
			System.out.println("delay 2 seconds..." + new Date());
		}, 10, 3, TimeUnit.SECONDS);
		
//		try {
//			Thread.sleep(11000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("exception-->" + e.getMessage());;
//		}
//		pool.shutdown();
//		System.out.println("isShutdown -> " + pool.isShutdown());
	}
}
