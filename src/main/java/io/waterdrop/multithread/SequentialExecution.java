package io.waterdrop.multithread;


/**
 * 
 * @author liangyh
 *
 */
public class SequentialExecution {
     public static void sequentialExecution(){
    	 Thread thread1 = new Thread(new Runnable(){
    		 public void run(){
    			 System.out.println("thread1");
    		 }
    	 },"T1");
    	 Thread thread2 = new Thread(new Runnable(){
    		 public void run(){
    			 try {
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			 System.out.println("thread2");
    		 }
    	 },"T2");
    	 Thread thread3 = new Thread(new Runnable(){
    		 public void run(){
    			 try {
					thread2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			 System.out.println("thread3");
    		 }
    	 },"T3");
    	 
    	 thread1.start();
    	 thread2.start();
    	 thread3.start();   	 
     }
     
     public static void main(String[] args) {
    	 sequentialExecution();
	}
    
}
