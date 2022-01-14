/**
 * 
 */
package com.suhj.basics;

import java.util.concurrent.CountDownLatch;

/**
 * @author Haojie
 *
 */
public class T00_00_IPlusPlus {
	private static long n = 0L;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[100];
		CountDownLatch latch = new CountDownLatch(threads.length);
		
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->{
				for(int j = 0; j < 10000; j++) {
					//当一个线程在执行n++这个操作时，不会被其他线程打断
					//原子性：一系列操作要么全部执行完成，要么都不执行
					synchronized(T00_00_IPlusPlus.class) {
						n ++;
					}					
				}
				latch.countDown();
			});
		}
		
		for(Thread t:threads) {
			t.start();
		}
		
		latch.await();
		
		System.out.println(n);

	}

}
