package w11.animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTester {
	public static void main(String[] args) {
		
		class CountDown implements ActionListener {
			
			public CountDown(int initialCount) {
				count = initialCount;
			}

			public void actionPerformed(ActionEvent event) {
				if (count >= 0)
					System.out.println(count);
				if (count == 0)
					System.out.println("발사!");
				count--;
			}

			private int count;
		}

		CountDown listener = new CountDown(5);

		final int DELAY = 1000; 
		Timer t = new Timer(DELAY, listener);
		t.start();

		// 대화창을 띄우고 사용자가 버튼을 클릭할 때까지 기다린다.
		// 기다리는 동안 프로그램이 그 다음 문장으로 넘어가지 않고 멈추어 있다.
		JOptionPane.showMessageDialog(null, "종료?");
		System.exit(0);
		
	}
}
