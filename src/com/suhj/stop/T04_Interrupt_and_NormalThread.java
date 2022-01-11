/**
 * 
 */
package com.suhj.stop;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 *
 */
public class T04_Interrupt_and_NormalThread {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			//�̱߳�־λ������Ϊfalse
			while(!Thread.interrupted()) {
				//sleep wait
				//t.sleep(0);
			}
			
			System.out.println("t1 end");
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(1);
		
		t.interrupt();
	}

}
