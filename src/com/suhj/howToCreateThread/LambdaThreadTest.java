/**
 * 
 */
package com.suhj.howToCreateThread;

/**
 * @author Haojie
 * �����̷߳�ʽ3������Lambda ���ʽ
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
