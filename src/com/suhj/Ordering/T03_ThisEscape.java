/**
 * 
 */
package com.suhj.Ordering;

/**
 * @author Haojie
 * ����this�����ݳ�
 */
public class T03_ThisEscape {
	
	private int num = 8;
	
	Thread t;
	
	public T03_ThisEscape() {
		t = new Thread(()->{
			//System.out.println(num);
			System.out.println(this.num);
		});
	}
	
	public void start() {
		t.start();
	}
	
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < Integer.MAX_VALUE; i ++) {
			T03_ThisEscape e = new T03_ThisEscape();
			if(e.num == 0) {
				System.out.println("�����ڰ��ʼ��״̬");
			};
		}
		
		System.in.read();
	}

}
