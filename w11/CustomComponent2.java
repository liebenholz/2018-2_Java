package w11;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CustomComponent2 extends JComponent{
	private static final long serialVersionUID = 1L;
	
	final int WIDTH = 200;
	final int HEIGHT = 200;
	
	// ������
	public CustomComponent2() {
		super();
		// LayoutManager�� ������Ʈ�� preferredSize��
		// �ִ��� �����Ͽ� ��ǰ�� ũ�⸦ �������ش�.
		// JComponent�� �⺻ preferredSize�� 0�̹Ƿ�
		// �Ʒ� ������ �����ϸ� ������Ʈ�� ȭ�鿡 ��Ÿ���� ����
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box =  new Rectangle(50, 50, 100, 100);
		g2.setColor(Color.ORANGE);
		g2.fill(box);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(10.0f));
		box = new Rectangle(0, 0, getWidth()-1, getHeight()-1); 
		g2.draw(box);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Custom Component");
		frame.add(new CustomComponent2());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
