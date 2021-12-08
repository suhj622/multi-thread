/**
 * 
 */
package com.suhj.howToCreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Haojie
 * 
 * 线程创建方式6：使用Thread 和 FutureTask
 */
public class MyFutureTaskTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//使用 FutureTask 创建线程
		FutureTask<String> task = new FutureTask<>(new MyCall());
		Thread t = new Thread(task);
		t.start();
		System.out.println(task.get());
	}

}
