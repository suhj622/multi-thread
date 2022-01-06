import com.suhj.threadState.SleepHelper;

/**
 * 
 */

/**
 * @author Haojie
 * ���� interrupt �� sync
 * �������߳̾������Ĺ����У��̲߳��ᱻ interrupt ���
 */
public class Interrupt_and_sync {
	
	private static Object o = new Object();

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{
			synchronized(o) {
				SleepHelper.sleepSeconds(10);
			}
		});
		
		t1.start();
		
		SleepHelper.sleepSeconds(1);
		
		Thread t2 = new Thread(()->{
			synchronized(o) {
				
			}
			
			System.out.println("t2 end!");
		});
		
		t2.start();
		
		SleepHelper.sleepSeconds(1);
		
		t2.interrupt();
		System.out.println("t2 thread:" + t2.isInterrupted());

	}

}
