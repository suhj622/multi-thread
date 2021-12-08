/**
 * 
 */
package com.suhj.threadState;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Haojie
 * �����߳�״̬��ʵ��
 */
public class ThreadState {	
	public static void main(String[] args) throws InterruptedException {
		//==================================
		Thread t1 = new Thread(()->{
			System.out.println("2: " + Thread.currentThread().getState());
			for (int i = 0; i < 3; i++) {
				SleepHelper.sleepSeconds(1);
				System.out.print(i + " ");
			}
			System.out.println();
		 }
		);
		System.out.println("1: " + t1.getState());
		t1.start();
		t1.join();
		System.out.println("3: " + t1.getState());
		
		//========================================
		Thread t2 = new Thread(()->{			
			try {
				LockSupport.park();
				System.out.println("t2 go on");
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		);
		
		t2.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("4: " + t2.getState());
		
		LockSupport.unpark(t2);
		TimeUnit.SECONDS.sleep(1);
		System.out.println("5: " + t2.getState());
		//=========================================
		//synchronized���������߳̽���blocked״̬
		final Object o = new Object();
		Thread t3 = new Thread(()->{
			synchronized(o) {
				System.out.println("t3 �õ����� o");
			}
		 }
		);
		
		new Thread(()->{
			synchronized(o) {
				SleepHelper.sleepSeconds(5);
			} 
		 }
		).start();
		
		SleepHelper.sleepSeconds(1);
		
		t3.start();		
		SleepHelper.sleepSeconds(1);
		System.out.println("6: " + t3.getState());
		//============================================
		//lock������ʱ���߳̽���WAITING״̬
		final Lock lock = new ReentrantLock();
		Thread t4 = new Thread(()->{
			lock.lock();
			System.out.println("t4 �õ����� o");
			lock.unlock();
		 }
		);
		
		new Thread(()->{
			lock.lock();
			SleepHelper.sleepSeconds(5);
			lock.unlock();
		 }		
		).start();
		
		SleepHelper.sleepSeconds(1);
		
		t4.start();
		SleepHelper.sleepSeconds(1);
		System.out.println("7: " + t4.getState());
		//=============================================
		Thread t5 = new Thread(()->{
			LockSupport.park();
		 }
		);
		
		t5.start();
		
		SleepHelper.sleepSeconds(1);
		
		System.out.println("8: " + t5.getState());
		LockSupport.unpark(t5);
	}
}
