/**
 * 
 */
package com.suhj.stop;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ʹ��stop����ֹͣ�߳�
 */
public class T01_Stop {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->{
			while(true) {
				System.out.println("go on");
				SleepHelper.sleepSeconds(1);
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(5);
		
		t.stop();

	}

}
