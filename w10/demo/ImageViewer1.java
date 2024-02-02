package w10.demo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageViewer1 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("ImageViewer");
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("카라멜 유튜브 구독과 좋아요"));
		
		frame.add(panel);
		
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);

	}

}
