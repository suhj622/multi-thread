/**
 * 
 */
package com.suhj.interrupt;

import java.util.concurrent.locks.ReentrantLock;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ²âÊÔ Interrupt ºÍ lock
 * interrupt ²»Ó°Ïì lock 
 */
public class Interrupt_and_lock {
	
	private static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			lock.lock();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			System.out.println("t1 end!");
		});
		
		t1.start();
		
		SleepHelper.sleepSeconds(1);
		
		Thread t2 = new Thread(()->{
			lock.lock();
			try {
				
			} finally {
				lock.unlock();
			}
			System.out.println("t2 end!");
		});
		
		t2.start();
		
		SleepHelper.sleepSeconds(1);
		
		t2.interrupt();
		
		System.out.println("t2 thread:" + t2.isInterrupted());

	}

}
