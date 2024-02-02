package w10.p4;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	
	private JButton button;	// �ν��Ͻ� �ʵ�
	
	// ������
	public ButtonFrame() {
		
		// ��� "����"�� ���� ���� ������.
		button = new JButton("Ŭ���ϼ���.");
		
		// ButtonFrame �ڽſ��� button�� add��.
		// this.add(button)�� �ٿ� ���� ����.
		add(button);
		
		// �Ʒ� ����鿡�Ե� ���� ������ �����.
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonFrame();
	}
}