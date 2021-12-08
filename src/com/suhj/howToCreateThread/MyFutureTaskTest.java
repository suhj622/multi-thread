/**
 * 
 */
package com.suhj.howToCreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Haojie
 * 
 * �̴߳�����ʽ6��ʹ��Thread �� FutureTask
 */
public class MyFutureTaskTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//ʹ�� FutureTask �����߳�
		FutureTask<String> task = new FutureTask<>(new MyCall());
		Thread t = new Thread(task);
		t.start();
		System.out.println(task.get());
	}

}
