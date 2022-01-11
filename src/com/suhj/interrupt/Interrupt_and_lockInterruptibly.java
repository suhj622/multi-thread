/**
 * 
 */
package com.suhj.interrupt;

import java.util.concurrent.locks.ReentrantLock;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * 测试 interrupt 和 lockInterruptibly
 * 允许打断锁竞争过程的方法
 */
public class Interrupt_and_lockInterruptibly {

	private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			System.out.println("t1 start!");
			lock.lock();
			try {
				SleepHelper.sleepSeconds(10);
			} finally {
				lock.unlock();
			}			
			System.out.println("t1 end!");
		});
		
		t1.start();
		
		SleepHelper.sleepSeconds(1);
		
		Thread t2 = new Thread(()->{
			System.out.println("t2 start!");
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			} finally {
				lock.unlock();
			}
			System.out.println("t2 end!");
		});
		
		t2.start();
		
		SleepHelper.sleepSeconds(1);
		
		t2.interrupt();

	}

}
