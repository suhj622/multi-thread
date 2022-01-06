/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ���� interrupt() �� interrupted
 */
public class Interrupt_and_interrupted {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(;;) {
				if(Thread.interrupted()) {
					System.out.println("sub thread is interrupted!");
					System.out.println("sub thread: " + Thread.interrupted());
				}
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(2);
		
		t.interrupt();
		
		//˼��һ�£����������д
		System.out.println("main thread:" + Thread.interrupted());
		//��������ĸ��̵߳��ж�״̬

	}

}
