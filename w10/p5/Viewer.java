package w10.p5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// �̿ϼ�?
@SuppressWarnings("serial")
public class Viewer extends JFrame implements ActionListener{

	private static final int FRAME_WIDTH = 250; 
	private static final int FRAME_HEIGHT = 80;
	JPanel panel;
	JButton button;
	final JLabel label;
	private int n = 0;

	public Viewer() {
		// ���� ��ǰ�� ������ �þ�������� Panel�� ��ǰ�� �־�� �Ѵ�.
		panel = new JPanel();
		button = new JButton("Click me!");
		panel.add(button);

		// Local inner class���� �ٱ� Ŭ������ ���������� ����Ϸ���
		// �ٱ� Ŭ������ ���������� final�� �����ؾ� �Ѵ�.
		label = new JLabel("��ư Ŭ�� �� : 0");
		panel.add(label);

		add(panel);
		
		button.addActionListener(this);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		n++; // ī��Ʈ ����
		//label ���
		label.setText("��ư Ŭ�� �� : " + n);
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
