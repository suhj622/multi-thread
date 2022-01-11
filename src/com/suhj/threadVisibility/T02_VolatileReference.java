/**
 * 
 */
package com.suhj.threadVisibility;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 *
 */
public class T02_VolatileReference {
	
	private static class A {
		boolean running = true;
		void m() {
			System.out.println("m start");
			while(running) {}
			System.out.println("m end!");
		}
	}
	
	private volatile static A a = new A();

	public static void main(String[] args) {
		new Thread(a::m,"t1").start();
		SleepHelper.sleepSeconds(1);
		a.running = false;
	}

}
