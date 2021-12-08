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
 * 线程创建方式5：带返回值的任务执行
 * 使用线程池和Callable接口
 */
public class MyCallTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newCachedThreadPool();
		//用Future来接收任务返回的结果
		Future<String> f = service.submit(new MyCall());
		//阻塞获取结果
		String s = f.get();
		System.out.println(s);
		service.shutdown();
	}

}
