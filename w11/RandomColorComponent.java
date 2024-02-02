package w11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class RandomColorComponent extends JComponent{

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 150;
	static final int HEIGHT = 150;
	final int CIRCLE_WIDTH = 100;
	final int CIRCLE_HEIGHT = 100;
	private Random r = new Random();
	
	public RandomColorComponent() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ellipse 
		= new Ellipse2D.Double((WIDTH-CIRCLE_WIDTH) / 2,
				(HEIGHT - CIRCLE_HEIGHT) / 2, CIRCLE_WIDTH, CIRCLE_HEIGHT);
		Color color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
		g2.setColor(color);
		g2.fill(ellipse);
		Rectangle rect = new Rectangle(0, 0, WIDTH - 1, HEIGHT - 1);
		g2.draw(rect);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setTitle("Random Color Component");
		panel.setBorder(new LineBorder(Color.RED));
		panel.add(new RandomColorComponent());
		panel.add(new RandomColorComponent());
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
