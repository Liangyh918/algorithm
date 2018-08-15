package io.waterdrop.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SequentialExecution Base SingleThreadExecutor
 * 
 * @author liangyh
 *
 */
public class SequentialExecutionBaseSTE {
	public static void sequentialExecution() {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread1");
			}
		}, "T1");
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread2");
			}
		}, "T2");
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread3");
			}
		}, "T3");
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(thread1);
		executor.submit(thread2);
		executor.submit(thread3);
	}
	
	public static void main(String[] args) {
		sequentialExecution();
	}
}
