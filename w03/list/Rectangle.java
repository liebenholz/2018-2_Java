package week3.list;

public class Rectangle implements Measurable, Comparable<Rectangle> {
	
	private double width, height;
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	// 사각형의 크기를 결정
	public void setDimension(double w, double h) {
		width = w;
		height = h;
	}
	
	public double getMeasure() {
		return width*height;
	}
	
	public int compareTo(Rectangle o) {
		if(width * height > o.getMeasure()) return 1;
		else if(width * height < o.getMeasure()) return -1;
		else return 0;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle [width=%,.1f, height=%,.1f]", width, height);
	}
}
