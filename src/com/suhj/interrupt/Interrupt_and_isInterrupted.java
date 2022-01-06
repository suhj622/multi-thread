/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ���� interrupt() �� isInterrupted()
 * ���ñ�־λ + ��ѯ��־λ
 */
public class Interrupt_and_isInterrupted {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(;;) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread is interrupted!");
					System.out.println(Thread.currentThread().isInterrupted());
					//break;
				}
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(2);
		
		t.interrupt();
		
	}

}
