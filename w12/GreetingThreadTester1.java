package w12;

import java.util.Date;

/**
 * �λ��� �ݺ��ؼ� ����ϱ�.
 * Thread�� ����Ŭ������ �����ϰ� run �޼ҵ带 ������� ��, �� ����Ŭ���� �ν��Ͻ��� start��Ű�� ���
 */
class GreetingThread extends Thread {

	private static final int REPETITIONS = 30;
	private static final int DELAY = 1000;

	private String greeting;



	public GreetingThread(String aGreeting) {
		greeting = aGreeting;
	}

	@Override
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

public class GreetingThreadTester1 {

	public static void main(String[] args) {
		Thread t1 = new GreetingThread("�ȳ�?");
		Thread t2 = new GreetingThread("����!");
		t1.start();
		t2.start();
	} 
}
