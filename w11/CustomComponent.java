package w11;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CustomComponent extends JComponent{

	// 프레임이 처음 그려질 때
	// 아이콘으로 축소되었다가 복원될 때
	// 프레임 크기가 변할 때 호출된다.
	public void paintComponent(Graphics g) {
		// 시스템이 이 메소드를 호출할 때 g를 이 메소드에 넘겨둔다.
		// g는 이 component를 나타내는 그림 도구이다.
		// 파라미터 g의 타입은 Graphics이지만 실제로는 Graphics2D 객체가 넘어온다.
		// Graphics2D는 Graphics의 서브클래스이다.
		// Graphics2D가 Graphics보다 기능이 많으므로 Graphics2D 타입으로 형변환하여 사용한다.
		Graphics2D g2 = (Graphics2D) g;
		// (x, y, width, height)
		Rectangle box = new Rectangle(0, 0, 200, 200);
		// 이 컴포넌트에 사각형을 그린다.
		g2.draw(box);
		box = new Rectangle(50, 50, 100, 100);
		g2.draw(box);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setTitle("Custom Component");
		CustomComponent comp = new CustomComponent();
		frame.add(comp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
