package w10.p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Viewer {
	
	private static final int FRAME_WIDTH = 250; 
	private static final int FRAME_HEIGHT = 80; 
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		
		// 여러 부품을 옆으로 늘어놓으려면 Panel에 부품을 넣어야 한다.
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me!");
		panel.add(button);
		
		// Local inner class에서 바깥 클래스의 지역변수를 사용하려면
		// 바깥 클래스의 지역변수를 final로 선언해야 한다.
		final JLabel label = new JLabel("버튼 클릭 수 : 0");
		panel.add(label);
		
		frame.add(panel);
		
		// Local inner class 형태로 선언된 ActionListener
		class ClickListener implements ActionListener {
			private int n;	// 버튼 클릭 수 카운트를 위한 필드
			public void actionPerformed(ActionEvent event) {
				n++; // 카운트 증가
				//label 사용
				label.setText("버튼 클릭 수 : " + n);
			}
		}
		
		// 액션리스너를 만들어 버튼을 등록함
		// 사용자가 버튼을 클릭하면 액션리스너의 actionPerformed 메소드가 실행됨.
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		// 프레임 헤드에 있는 빨간색 x 버튼을 클릭하면
		// 프로그램이 종료되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면이 나타나도록 설정
		frame.setVisible(true);

	}

}
