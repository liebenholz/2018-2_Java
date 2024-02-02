package w12;

public class GreetingThreadTester3 {
	
	public static void main(String[] args) throws InterruptedException {
		GreetingRunnable r = new GreetingRunnable("¾È³ç?");
		Thread t = new Thread(r);
		t.start();
		
		Thread.sleep(5000);
		t.interrupt();
	}
}