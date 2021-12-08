/**
 * 
 */
package com.suhj.howToCreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Haojie
 * �̴߳�����ʽ4��ʹ���̳߳�
 */
public class MyThreadPool {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(() -> {
			System.out.println("Hello, My ThreadPool!");
		});
		service.shutdown();
	}

}
