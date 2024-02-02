package w10.p4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// �̿ϼ�?
@SuppressWarnings("serial")
public class Viewer extends JFrame{

	private static final int FRAME_WIDTH = 250; 
	private static final int FRAME_HEIGHT = 80; 

	public Viewer() {
		// ���� ��ǰ�� ������ �þ�������� Panel�� ��ǰ�� �־�� �Ѵ�.
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me!");
		panel.add(button);

		// Local inner class���� �ٱ� Ŭ������ ���������� ����Ϸ���
		// �ٱ� Ŭ������ ���������� final�� �����ؾ� �Ѵ�.
		final JLabel label = new JLabel("��ư Ŭ�� �� : 0");
		panel.add(label);

		add(panel);

		// �׼Ǹ����ʸ� ����� ��ư�� �����
		// ����ڰ� ��ư�� Ŭ���ϸ� �׼Ǹ������� actionPerformed �޼ҵ尡 �����.
		ActionListener listener = new ActionListener() {
			private int n;	// ��ư Ŭ�� �� ī��Ʈ�� ���� �ʵ�	
			public void actionPerformed(ActionEvent event) {
				n++; // ī��Ʈ ����
				//label ���
				label.setText("��ư Ŭ�� �� : " + n);
			}
		};
		button.addActionListener(listener);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Viewer();
	}

}
