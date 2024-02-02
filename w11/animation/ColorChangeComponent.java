package w11.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ColorChangeComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	
	private Ellipse2D.Double e;
	private Random r = new Random();
	
	final static int COMP_WIDTH = 300;
	final static int COMP_HEIGHT = 300;
	final static double DIAMETER = 200.0;
	
	public ColorChangeComponent() {
		super();
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
		class listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}
		final int DELAY = 1000;
		listener actionListener = new listener();
		Timer t = new Timer(DELAY, actionListener);
		t.start();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		e = new Ellipse2D.Double((getWidth() - DIAMETER) / 2
				, (getHeight() - DIAMETER) / 2, DIAMETER, DIAMETER);
		Color color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
		g2.setColor(color);
		g2.fill(e);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Color Change Component");
		frame.add(new ColorChangeComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
