package w11.mouse;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RectangleComponent extends JComponent{

	private static final long serialVersionUID = 1L;

	final static int COMP_WIDTH = 400;
	final static int COMP_HEIGHT = 400;

	private Rectangle box;
	
	private static final int BOX_WIDTH = 20;
	private static final int BOX_HEIGHT = 30;
	
	public RectangleComponent() {
		super();
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
		box = new Rectangle();
		box.setBounds(0, 0, BOX_WIDTH, BOX_HEIGHT);
		
		class MyListener extends MouseAdapter {
			public void mousePressed(MouseEvent event) {
				int x = event.getX();
				int y = event.getY();
				box.setLocation(x, y);
				repaint();
			}
		}
		MouseListener listener = new MyListener();
		addMouseListener(listener);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(box);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Rectangle Component");
		frame.add(new RectangleComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
