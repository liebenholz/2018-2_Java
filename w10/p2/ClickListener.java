package w10.p2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

//Local inner class ���·� ����� ActionListener
public class ClickListener implements ActionListener {
	private int n;	// ��ư Ŭ�� �� ī��Ʈ�� ���� �ʵ�
	JLabel label;
	ClickListener(JLabel lb){
		label = lb;
	}
	public void actionPerformed(ActionEvent event) {
		n++; // ī��Ʈ ����
		//label ���
		label.setText("��ư Ŭ�� �� : " + n);
	}
}
