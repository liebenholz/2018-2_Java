package w12;
import java.util.Date;

/**
 * �λ��� �ݺ��ؼ� ����ϴ� Runnable Ŭ����.
 */
class GreetingRunnable implements Runnable {

	private static final int REPETITIONS = 30;
	private static final int DELAY = 1000;

	private String greeting;

	/**
	 * ������.
	 * @param aGreeting �λ�.
	 */
	public GreetingRunnable(String aGreeting) {
		greeting = aGreeting;
	}

	public void run() {
		try {
			for (int i = 1; i <= REPETITIONS; i++) {
				Date now = new Date();
				System.out.println(now + " " + greeting);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {	}	// ������.
	}
}

/**
 * �� ���� �����带 ���ķ� �����Ŵ.
 */
public class GreetingThreadTester2 {
	public static void main(String[] args) {
		GreetingRunnable r1 = new GreetingRunnable("�ȳ�?");
		GreetingRunnable r2 = new GreetingRunnable("����!");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}