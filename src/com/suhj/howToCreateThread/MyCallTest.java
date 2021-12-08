/**
 * 
 */
package com.suhj.howToCreateThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Haojie
 * �̴߳�����ʽ5��������ֵ������ִ��
 * ʹ���̳߳غ�Callable�ӿ�
 */
public class MyCallTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newCachedThreadPool();
		//��Future���������񷵻صĽ��
		Future<String> f = service.submit(new MyCall());
		//������ȡ���
		String s = f.get();
		System.out.println(s);
		service.shutdown();
	}

}
