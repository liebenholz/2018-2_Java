package w10.p2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

//Local inner class 형태로 선언된 ActionListener
public class ClickListener implements ActionListener {
	private int n;	// 버튼 클릭 수 카운트를 위한 필드
	JLabel label;
	ClickListener(JLabel lb){
		label = lb;
	}
	public void actionPerformed(ActionEvent event) {
		n++; // 카운트 증가
		//label 사용
		label.setText("버튼 클릭 수 : " + n);
	}
}
