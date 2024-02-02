package w10.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Click me!");
		frame.add(button);

		button.addActionListener(new ClickListener());

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
