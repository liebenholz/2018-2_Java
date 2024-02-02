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
		
		// ���� ��ǰ�� ������ �þ�������� Panel�� ��ǰ�� �־�� �Ѵ�.
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me!");
		panel.add(button);
		
		// Local inner class���� �ٱ� Ŭ������ ���������� ����Ϸ���
		// �ٱ� Ŭ������ ���������� final�� �����ؾ� �Ѵ�.
		final JLabel label = new JLabel("��ư Ŭ�� �� : 0");
		panel.add(label);
		
		frame.add(panel);
		
		// Local inner class ���·� ����� ActionListener
		class ClickListener implements ActionListener {
			private int n;	// ��ư Ŭ�� �� ī��Ʈ�� ���� �ʵ�
			public void actionPerformed(ActionEvent event) {
				n++; // ī��Ʈ ����
				//label ���
				label.setText("��ư Ŭ�� �� : " + n);
			}
		}
		
		// �׼Ǹ����ʸ� ����� ��ư�� �����
		// ����ڰ� ��ư�� Ŭ���ϸ� �׼Ǹ������� actionPerformed �޼ҵ尡 �����.
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		// ������ ��忡 �ִ� ������ x ��ư�� Ŭ���ϸ�
		// ���α׷��� ����ǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ȭ���� ��Ÿ������ ����
		frame.setVisible(true);

	}

}
