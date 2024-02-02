package w12;

import java.util.Date;

/**
 * 인삿말을 반복해서 출력하기.
 * Thread의 서브클래스를 선언하고 run 메소드를 엎어쓰기한 후, 이 서브클래스 인스턴스를 start시키는 방법
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
		} catch (InterruptedException exception) {	}	// 무시함.
	}
}

public class GreetingThreadTester1 {

	public static void main(String[] args) {
		Thread t1 = new GreetingThread("안녕?");
		Thread t2 = new GreetingThread("바이!");
		t1.start();
		t2.start();
	} 
}
