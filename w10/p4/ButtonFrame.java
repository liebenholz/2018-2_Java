package w10.p4;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	
	private JButton button;	// 인스턴스 필드
	
	// 구성자
	public ButtonFrame() {
		
		// 가운데 "데모"가 적힌 라벨을 구성함.
		button = new JButton("클릭하세요.");
		
		// ButtonFrame 자신에게 button을 add함.
		// this.add(button)을 줄여 적은 것임.
		add(button);
		
		// 아래 문장들에게도 같은 설명이 적용됨.
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonFrame();
	}
}