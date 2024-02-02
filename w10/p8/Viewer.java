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
	private JLabel label1 = new JLabel("버튼 클릭 수 : 0");
	private JLabel label2 = new JLabel("버튼 클릭 수 : 0");

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
		private int n1, n2;	// 각 버튼의 카운터
		// 이벤트가 발생하여 이 메소드가 호출될 때 ActionEvent 객체가 파라미터로 전달.
		// ACtionEvent 객체는 구체적으로 어떤 이벤트가 일어났는지 상세한 정보를 갖는다.
		// ActionEvent에게 getSource() 메소드를 호출하면 이벤트 소스를 알려준다.
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == button1) {
				n1++;   label1.setText("버튼 클릭 수 : " + n1);
			}
			else if (arg0.getSource() == button2) {
				n2++;   label2.setText("버튼 클릭 수 : " + n2);
			}
		}
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
