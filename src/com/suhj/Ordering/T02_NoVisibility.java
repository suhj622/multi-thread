package com.suhj.Ordering;

/**
 * 
 * @author Haojie
 * 测试并发编程之可见性
 * 存在2个问题：1> 可见性 2> 有序性
 */
public class T02_NoVisibility {
	
	private static volatile boolean ready = false;
	private static int number;
	
	private static class ReaderThread extends Thread{

		@Override
		public void run() {
			while(!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new ReaderThread();
		t.start();
		number = 42;
		ready = true;
		t.join();
	}

}
