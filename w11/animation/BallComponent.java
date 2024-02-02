package w11.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class BallComponent extends JComponent{
	private static final long serialVersionUID = 1L;

	final static int COMP_WIDTH = 400;
	final static int COMP_HEIGHT = 300;

	final int GROUND_DEPTH = 20;	// �ٴ� �β�
	final int ANIMATION_INVERTAL = 30;	// ȭ�� ������ ����

	final double INITIAL_POSITION_X = 20.0;
	final double INITIAL_POSITION_Y = 20.0;
	final double BALL_DIAMETER = 16.0;

	final double GRAVITY  = 1.0;	// �߷°��
	final double DEGRADATION = 2.0;	// ������

	private Ball ball;
	private int groundLevel;	// �ٴ� ����
	private boolean done = false;

	public BallComponent() {
		super();
		ball = new Ball(INITIAL_POSITION_X, INITIAL_POSITION_Y, 
				BALL_DIAMETER, Color.BLUE, this);
		setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
	}

	public void startAnimation() {
		class Bouncer implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(done) return;
				else {
					ball.move();
					if (ball.xPosition + BALL_DIAMETER > getWidth())
						done = true;
					repaint();
				}
			}
		}
		Bouncer bouncer = new Bouncer();
		Timer t = new Timer(ANIMATION_INVERTAL, bouncer);
		t.start();
	}
	
	class Ball {
		private Color color;
		private double diameter;
		private double xPosition;
		private double yPosition;
		private double ySpeed = 1.0;	// y���� �ʱ�ӷ�
		private double xSpeed = 2.0;	// x���� �ʱ�ӷ�
		private BallComponent comp;		// ������Ʈ
		
		public Ball(double xPos, double yPos, double bDia, Color bColor, BallComponent bComp) {
			xPosition = xPos;
			yPosition = yPos;
			diameter = bDia;
			color = bColor;
			comp = bComp;
		}
		
		public void draw(Graphics2D g) {
			Ellipse2D.Double e = new Ellipse2D.Double(xPosition, yPosition , diameter, diameter);
			g.setColor(color);
			g.fill(e);
		}

		public void move() {
			ySpeed += GRAVITY;
			xPosition += xSpeed;
			yPosition += ySpeed;
			
			int groundLevel = comp.getGroundLevel();
			if (yPosition >= (groundLevel - diameter) && ySpeed > 0) {
				yPosition = groundLevel - diameter;
				ySpeed = -ySpeed + DEGRADATION;
			}
			
		}
		
		public double getXPosition() {
			return xPosition;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle r = new Rectangle(0, getGroundLevel(), getWidth(), GROUND_DEPTH);
		g2.setColor(Color.BLACK);
		g2.fill(r);
		ball.draw(g2);
	}

	public int getGroundLevel() {
		groundLevel = getHeight() - GROUND_DEPTH;
		return groundLevel;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bounce Ball");
		BallComponent bounce = new BallComponent();
		frame.add(bounce);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		bounce.startAnimation();
	}

}
