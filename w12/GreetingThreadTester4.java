package w12;

import javax.swing.JOptionPane;

public class GreetingThreadTester4 {
	
	Thread t1;
	Thread t2;
	
	void startThreads() {
		GreetingRunnable r1 = new GreetingRunnable("�ȳ�?");
		GreetingRunnable r2 = new GreetingRunnable("����!");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
	
	void interruptThread() {
		// main �����尡 �����ϴ� ����.
		// main ������� ����ڰ� ��ȭâ�� Ȯ�� ��ư�� Ŭ���� ������ �� ���忡 ���߾��ִ�.
		// Ȯ�� ��ư�� Ŭ���ϸ� ������ �ִ� if �������� �Ѿ��.
		String input = JOptionPane.showInputDialog(
				"� �λ��� �ϰ� �������?");
		if (input.equals("�ȳ�?"))
			t1.interrupt();
		else if (input.equals("����!"))
			t2.interrupt();
	}
	
	public static void main(String[] args) {
		GreetingThreadTester4 tester = new GreetingThreadTester4();
		tester.startThreads();
		tester.interruptThread();
		tester.interruptThread();
	}
}