/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * 测试 interrupt 和 sleep 方法
 * 
 */
public class Interrupt_and_sleep {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			//线程 sleep、wait、join 时，如果执行打断操作时，会抛出 InterruptedException
			//此块逻辑需要应用程序员做出处理
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
