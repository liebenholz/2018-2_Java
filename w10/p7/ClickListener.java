package w10.p7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ClickListener implements ActionListener{
	private int n;
	JButton button;
	JLabel label;
	
	public ClickListener(JButton b, JLabel l) {
		label = l;
		button = b;
	}
	
	public void actionPerformed(ActionEvent event) {
		n++;
		label.setText(button.getText() +"버튼 클릭 수 : " + n);
	}
}
