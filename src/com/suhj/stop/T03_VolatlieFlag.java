/**
 * 
 */
package com.suhj.stop;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * ²âÊÔ volatile
 */
public class T03_VolatlieFlag {
	
	private static volatile boolean running = true;

	public static void main(String[] args) {
		
		Thread t = new Thread(()->{
			long i = 0L;
			while(running) {
				//wait recv accept
				i++;
			}
			System.out.println("end and i= " + i); //3257120867 3235933696
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(1);
		
		running = false;

	}

}
