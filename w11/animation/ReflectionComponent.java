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

public class ReflectionComponent extends JComponent{
	private static final long serialVersionUID = 1L;
	
	final static int COMP_WIDTH = 300;
	final static int COMP_HEIGHT = 400;
	
	final static int RECT_WIDTH = 20;
	final static int RECT_HEIGHT = 30;
	
	private Rectangle r;
	
	public ReflectionComponent() {
		super();
		r = new Rectangle(RECT_WIDTH, RECT_HEIGHT);
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
	}
	
	public void startAnimation() {
		class listener implements ActionListener {
			
			private int speed_x = 1;
			private int speed_y = 1;
			
			public void actionPerformed(ActionEvent e) {
				r.translate(speed_x, speed_y);
				if(r.getX() + RECT_WIDTH > getWidth() || r.getX() < 0)
					speed_x *= -1;
				if(r.getY() + RECT_HEIGHT > getHeight() || r.getY() < 0)
					speed_y *= -1;
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
		g2.draw(r);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Reflection Component");
		ReflectionComponent reflect = new ReflectionComponent();
		frame.add(reflect);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		reflect.startAnimation();
	}
}
