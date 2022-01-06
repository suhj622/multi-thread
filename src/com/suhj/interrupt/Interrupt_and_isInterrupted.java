/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * 测试 interrupt() 与 isInterrupted()
 * 设置标志位 + 查询标志位
 */
public class Interrupt_and_isInterrupted {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(;;) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread is interrupted!");
					System.out.println(Thread.currentThread().isInterrupted());
					//break;
				}
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(2);
		
		t.interrupt();
		
	}

}
