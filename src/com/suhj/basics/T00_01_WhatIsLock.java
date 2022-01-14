package com.suhj.basics;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 *
 */
public class T00_01_WhatIsLock {

	private static Object o = new Object();
	
	public static void main(String[] args) {
		Runnable r = () ->{
			//synchronized(o) {
				System.out.println(Thread.currentThread().getName() + " start!");
				SleepHelper.sleepSeconds(2);
				System.out.println(Thread.currentThread().getName() + " end!");			
			//}
		};

		for (int i = 0; i < 3; i ++) {
			new Thread(r).start();
		}
	}
}
