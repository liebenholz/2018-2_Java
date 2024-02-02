package w11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TriangleComponent extends JComponent{
	private static final long serialVersionUID = 1L;
	
	final static int COMP_WIDTH = 200;
	final static int COMP_HEIGHT = 200;
	
	Triangle t;
	
	public TriangleComponent() {
		super();
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		t = new Triangle(0, 0);
		t.render(g2);
		t = new Triangle(getWidth() - Triangle.WIDTH, getHeight() - Triangle.HEIGHT);
		t.render(g2);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Triangle Component");
		frame.add(new TriangleComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
