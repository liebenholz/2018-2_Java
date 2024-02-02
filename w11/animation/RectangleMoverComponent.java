package w11.animation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class RectangleMoverComponent extends JComponent{
	private static final long serialVersionUID = 1L;
	
	final static int COMP_WIDTH = 300;
	final static int COMP_HEIGHT = 400;
	
	final static int RECT_WIDTH = 20;
	final static int RECT_HEIGHT = 30;
	
	final int SPEED_X = 1;
	final int SPEED_Y = 1;
	
	private Rectangle r;
	private int x = 0;
	private int y = 0;
	
	public RectangleMoverComponent() {
		super();
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
		class listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}
		final int DELAY = 10;
		listener actionListener = new listener();
		Timer t = new Timer(DELAY, actionListener);
		t.start();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		r = new Rectangle(x, y, RECT_WIDTH, RECT_HEIGHT);
		x += SPEED_X;
		y += SPEED_Y;
		g2.draw(r);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Rectangle Mover Component");
		frame.add(new RectangleMoverComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
