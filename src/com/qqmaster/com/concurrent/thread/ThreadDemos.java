package com.qqmaster.com.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemos {
	public static void main(String[] args) {
//		Thread A = new ThreadDemo();
//		A.start();
//		
//		Thread B = new Thread(new RunnableDemo());
//		B.start();
		
		Callable<String> C = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("print ***");
				return "ok print ***";
			}
		};
		
		FutureTask<String> task = new FutureTask<>(C);
		
		Thread D = new Thread(task);
		D.start();
//		task.cancel(true);
	}
}

class ThreadDemo extends Thread{
	@Override
	public void run(){
		System.out.println("print ---");
	}
}

class RunnableDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("print ===");
	}

}

class CallableDemo implements Callable<Object>{

	@Override
	public String call() throws Exception {
		return "print ***";
	}
	
}