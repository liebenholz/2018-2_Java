package w11.mouse;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CircleComponent extends JComponent{

	private static final long serialVersionUID = 1L;

	final static int COMP_WIDTH = 400;
	final static int COMP_HEIGHT = 400;

	private boolean firstClick = true;
	private double centerX;
	private double centerY;
	private List<Ellipse2D.Double> circleList;

	public CircleComponent() {
		super();
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
		circleList = new ArrayList<Ellipse2D.Double>();
		
		class MyMouseListener extends MouseAdapter {
			public void mousePressed(MouseEvent event) {
				int x = event.getX();
				int y = event.getY();
				if(firstClick) {
					setCenterPosition(x, y);
					firstClick = false;
				}
				else if(!firstClick) {
					drawCircle(x, y);
					firstClick = true;
				}
			}
		}
		MouseListener listener = new MyMouseListener();
		addMouseListener(listener);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Ellipse2D.Double e : circleList)
			g2.draw(e);
	}
	
	public void setCenterPosition(double x, double y) {
		centerX = x;
		centerY = y;
	}
	
	public void drawCircle(double x, double y) {
		double radius = Math.sqrt
				(Math.pow(centerX - x, 2.0) + Math.pow(centerY - y, 2.0));
		double diameter = radius * 2.0;
		Ellipse2D.Double ellipse 
		= new Ellipse2D.Double(centerX - radius, centerY - radius, diameter, diameter);
		circleList.add(ellipse);
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Circle Component");
		frame.add(new CircleComponent());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
