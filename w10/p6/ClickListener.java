package w10.p6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ClickListener implements ActionListener{
	private int n;
	JLabel label;
	
	public ClickListener(JLabel l) {
		label = l;
	}
	
	public void actionPerformed(ActionEvent event) {
		n++;
		label.setText("버튼 클릭 수 : " + n);
	}
}
