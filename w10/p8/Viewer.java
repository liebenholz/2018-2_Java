package w10.p8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Viewer extends JFrame {

	private static final int FRAME_WIDTH = 550; 
	private static final int FRAME_HEIGHT = 80;
	private JButton button1 = new JButton("A") ;
	private JButton button2 = new JButton("B") ;
	private JLabel label1 = new JLabel("��ư Ŭ�� �� : 0");
	private JLabel label2 = new JLabel("��ư Ŭ�� �� : 0");

	public Viewer() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		ActionListener lis = new ClickListener();
		button1.addActionListener(lis);
		button2.addActionListener(lis);
		
		panel.add(button1);	panel.add(label1);
		panel.add(button2);	panel.add(label2);
		
		frame.add(panel);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class ClickListener implements ActionListener{
		private int n1, n2;	// �� ��ư�� ī����
		// �̺�Ʈ�� �߻��Ͽ� �� �޼ҵ尡 ȣ��� �� ActionEvent ��ü�� �Ķ���ͷ� ����.
		// ACtionEvent ��ü�� ��ü������ � �̺�Ʈ�� �Ͼ���� ���� ������ ���´�.
		// ActionEvent���� getSource() �޼ҵ带 ȣ���ϸ� �̺�Ʈ �ҽ��� �˷��ش�.
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == button1) {
				n1++;   label1.setText("��ư Ŭ�� �� : " + n1);
			}
			else if (arg0.getSource() == button2) {
				n2++;   label2.setText("��ư Ŭ�� �� : " + n2);
			}
		}
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
