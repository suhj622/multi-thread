/**
 * 
 */
package com.suhj.howToCreateThread;

/**
 * @author Haojie
 * 创建线程方式1：继承了 Thread 类
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hello MyThread!");
	}
	
	

}
