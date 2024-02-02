package w11;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class ColoredRectangle extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	Random r = new Random();
	
	private Color color;
	
	/*
	 * 구성자
	 * 무작위로 정해진 색깔의 컬러 사각형을 구성한다.
	 */
	public ColoredRectangle(int x, int y, int w, int h) {
		setBounds(x, y, w, h);
		color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), r.nextFloat());
	}
	
	public Color getColor() {
		return color;
	}

}
