package w11;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CustomComponent extends JComponent{

	// �������� ó�� �׷��� ��
	// ���������� ��ҵǾ��ٰ� ������ ��
	// ������ ũ�Ⱑ ���� �� ȣ��ȴ�.
	public void paintComponent(Graphics g) {
		// �ý����� �� �޼ҵ带 ȣ���� �� g�� �� �޼ҵ忡 �Ѱܵд�.
		// g�� �� component�� ��Ÿ���� �׸� �����̴�.
		// �Ķ���� g�� Ÿ���� Graphics������ �����δ� Graphics2D ��ü�� �Ѿ�´�.
		// Graphics2D�� Graphics�� ����Ŭ�����̴�.
		// Graphics2D�� Graphics���� ����� �����Ƿ� Graphics2D Ÿ������ ����ȯ�Ͽ� ����Ѵ�.
		Graphics2D g2 = (Graphics2D) g;
		// (x, y, width, height)
		Rectangle box = new Rectangle(0, 0, 200, 200);
		// �� ������Ʈ�� �簢���� �׸���.
		g2.draw(box);
		box = new Rectangle(50, 50, 100, 100);
		g2.draw(box);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setTitle("Custom Component");
		CustomComponent comp = new CustomComponent();
		frame.add(comp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
