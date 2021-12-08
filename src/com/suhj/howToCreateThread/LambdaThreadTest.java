/**
 * 
 */
package com.suhj.howToCreateThread;

/**
 * @author Haojie
 * 创建线程方式3：传递Lambda 表达式
 */
public class LambdaThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("Hello Lambda!");
		}).start();
	}

}
