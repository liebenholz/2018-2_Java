package w10.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ClickListener implements ActionListener {
	public ClickListener(JLabel label2) {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent event) {
		System.out.println("I was clicked.");
	}
}
