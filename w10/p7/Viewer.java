package w10.p7;

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
	private JLabel label1 = new JLabel(button1.getText() + "버튼 클릭 수 : 0");
	private JLabel label2 = new JLabel(button2.getText() + "버튼 클릭 수 : 0");

	public Viewer() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		button1.addActionListener(new ClickListener(button1, label1));
		button2.addActionListener(new ClickListener(button2, label2));
		
		panel.add(button1);	panel.add(label1);
		panel.add(button2);	panel.add(label2);
		
		frame.add(panel);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Viewer();
	}
}
