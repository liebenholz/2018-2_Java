package w12;

import javax.swing.JOptionPane;

public class GreetingThreadTester4 {
	
	Thread t1;
	Thread t2;
	
	void startThreads() {
		GreetingRunnable r1 = new GreetingRunnable("안녕?");
		GreetingRunnable r2 = new GreetingRunnable("바이!");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
	
	void interruptThread() {
		// main 스레드가 실행하는 문장.
		// main 스레드는 사용자가 대화창의 확인 버튼을 클릭할 때까지 이 문장에 멈추어있다.
		// 확인 버튼을 클릭하면 다음에 있는 if 문장으로 넘어간다.
		String input = JOptionPane.showInputDialog(
				"어떤 인삿말을 하고 끝낼까요?");
		if (input.equals("안녕?"))
			t1.interrupt();
		else if (input.equals("바이!"))
			t2.interrupt();
	}
	
	public static void main(String[] args) {
		GreetingThreadTester4 tester = new GreetingThreadTester4();
		tester.startThreads();
		tester.interruptThread();
		tester.interruptThread();
	}
}