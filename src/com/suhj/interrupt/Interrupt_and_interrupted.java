/**
 * 
 */
package com.suhj.interrupt;

import com.suhj.threadState.SleepHelper;

/**
 * @author Haojie
 * 测试 interrupt() 和 interrupted
 */
public class Interrupt_and_interrupted {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(;;) {
				if(Thread.interrupted()) {
					System.out.println("sub thread is interrupted!");
					System.out.println("sub thread: " + Thread.interrupted());
				}
			}
		});
		
		t.start();
		
		SleepHelper.sleepSeconds(2);
		
		t.interrupt();
		
		//思考一下，如果在这里写
		System.out.println("main thread:" + Thread.interrupted());
		//输出的是哪个线程的中断状态

	}

}
