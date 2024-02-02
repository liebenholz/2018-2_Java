package w11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CustomRectangleComponent extends JComponent{
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 200;
	static final int HEIGHT = 200;
	
	static final int RECT_WIDTH = 100;
	static final int RECT_HEIGHT = 100;
	
	ColoredRectangle rect;
	
	public CustomRectangleComponent() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		rect = new ColoredRectangle((getWidth() - RECT_WIDTH) / 2,
				(getHeight() - RECT_HEIGHT) / 2, RECT_WIDTH, RECT_HEIGHT);
		g2.setColor(rect.getColor());
		g2.fill(rect);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Custom Rectangle Component");
		frame.add(new CustomRectangleComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
