/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ���� interrupt �� sleep ����
 * 
 */
public class Interrupt_and_sleep {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			//�߳� sleep��wait��join ʱ�����ִ�д�ϲ���ʱ�����׳� InterruptedException
			//�˿��߼���ҪӦ�ó���Ա��������
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Thread is interrupted!");
				System.out.println("sub thread:" + Thread.currentThread().isInterrupted());
			}			
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(5);
		
		t.interrupt();

	}

}
