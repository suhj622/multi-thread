/**
 * 
 */
package com.suhj.howToCreateThread;

/**
 * @author Haojie
 * 线程创建方式2：实现了 Runnable 接口
 */
public class MyRun implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello MyRun!");
	}

}
