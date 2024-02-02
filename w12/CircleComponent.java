package w12;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * �� �� ���� �׷����� ������Ʈ.
 * ���� ������ ����� ä������.
 * ������Ʈ�� ���� �׷��� ������ �� ���� �׷�����.
 */
public class CircleComponent extends JComponent {
	
	private static final long serialVersionUID = 1L;

	static final int WIDTH = 150;	// ������Ʈ ũ��.
	static final int HEIGHT = 150;
	
	final int CIRCLE_WIDTH = 100;	// �� ũ��.
	final int CIRCLE_HEIGHT = 100;
	
	private Random r = new Random(); 
	
	public CircleComponent() {
		super();
		// ��ġ�����ڴ� ������Ʈ�� preferredSize�� �ִ��� �����Ͽ� �ڸ��� ��ġ��.
		// JComponent�� �⺻preferredSize�� 0�̹Ƿ� �Ʒ� ������ �����ϸ� ������Ʈ�� ȭ�鿡 ������ ����. 
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle1 = new Ellipse2D.Double(
				(WIDTH-CIRCLE_WIDTH)/2.0, (HEIGHT-CIRCLE_HEIGHT)/2.0, 
				CIRCLE_WIDTH, CIRCLE_HEIGHT);
		// �������� RGB ���� ����.
		g2.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
		// Graphics�� shape�� �׸� �� �ִ�. draw, fill �޼ҵ��� �Ķ���� Ÿ���� Shape�̴�.
		// Shape�� �������̽� �̸��̴�.
		// Ellipse2D.Double�� Shape�̴�.
		g2.fill(circle1);
	}

	public static void main(String[] args) {
		// CircleComponent �� ���� ����� ȭ�鿡 ���̰� ��.
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(new CircleComponent());
		frame.add(panel);
		panel.add(new CircleComponent());
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame = new JFrame();
		frame.setSize(200,  200);
		frame.setVisible(true);
	}
}