/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ²âÊÔ interrupt ºÍ wait ·½·¨
 */
public class Interrupt_and_wait {
	
	private static Object o = new Object();

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			synchronized(o) {
				try {
					o.wait();
				} catch (InterruptedException e) {
					System.out.println("sub thread is interrupted!");
					System.out.println("sub thread:" + Thread.currentThread().isInterrupted());
				}
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(5);
		
		t.interrupt();

	}

}
