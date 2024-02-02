package w10.p5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 미완성?
@SuppressWarnings("serial")
public class Viewer extends JFrame implements ActionListener{

	private static final int FRAME_WIDTH = 250; 
	private static final int FRAME_HEIGHT = 80;
	JPanel panel;
	JButton button;
	final JLabel label;
	private int n = 0;

	public Viewer() {
		// 여러 부품을 옆으로 늘어놓으려면 Panel에 부품을 넣어야 한다.
		panel = new JPanel();
		button = new JButton("Click me!");
		panel.add(button);

		// Local inner class에서 바깥 클래스의 지역변수를 사용하려면
		// 바깥 클래스의 지역변수를 final로 선언해야 한다.
		label = new JLabel("버튼 클릭 수 : 0");
		panel.add(label);

		add(panel);
		
		button.addActionListener(this);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		n++; // 카운트 증가
		//label 사용
		label.setText("버튼 클릭 수 : " + n);
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
