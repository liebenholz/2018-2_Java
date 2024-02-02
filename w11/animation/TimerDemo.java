package w11.animation;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) throws InterruptedException {

		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Task performed on: " + new Date() + "\n" +
						"Thread's name: " + Thread.currentThread().getName());
			}
		};
		Timer timer = new Timer("Timer");

		long delay = 3000L;

		System.out.println(delay + "ms 후에 시간 표출");
		timer.schedule(task, delay);

		System.out.println("Thread's name: " + Thread.currentThread().getName() + "\n");

	}

}