package w10.basic;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class FrameViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame("ImageViewer"); 
		frame.setSize(300, 200);

		JLabel label1 = new JLabel("label - text image�� ������ �� ���");
		label1.setBorder(new LineBorder(Color.RED, 5));
		JLabel label2 = new JLabel("�� ��° ��");
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(label2);
		frame.add(panel);

		frame.setVisible(true);
	}
}
