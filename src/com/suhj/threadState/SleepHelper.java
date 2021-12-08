/**
 * 
 */
package com.suhj.threadState;

import java.util.concurrent.TimeUnit;

/**
 * @author Haojie
 *
 */
public class SleepHelper {
	public static void sleepSeconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
