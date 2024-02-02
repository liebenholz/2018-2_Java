package w11;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Triangle {

	private double xLeft;
	private double yTop;
	
	public static final double WIDTH = 50;
	public static final double HEIGHT = 50;
	
	public Triangle(double x, double y) {
		xLeft = x;
		yTop = y;
	}
	
	public void render(Graphics2D g) {
		// 꼭지점
		Point2D.Double p1 = new Point2D.Double(xLeft, yTop);
		Point2D.Double p2 = new Point2D.Double(xLeft, yTop + WIDTH);
		Point2D.Double p3 = new Point2D.Double(xLeft + WIDTH , yTop + HEIGHT);
		// 선분
		Line2D.Double l1 = new Line2D.Double(p1, p2);
		Line2D.Double l2 = new Line2D.Double(p1, p3);
		Line2D.Double l3 = new Line2D.Double(p2, p3);
		
		// 세 변을 그림
		g.draw(l1);		g.draw(l2);		g.draw(l3);
	}
}
