package week3.list;

import java.util.Comparator;

public class DiagonalComparator implements Comparator<Rectangle>{

	public int compare(Rectangle r1, Rectangle r2) {

		double square1 = r1.getWidth()*r1.getWidth() + r1.getHeight()*r1.getHeight();
		double square2 = r2.getWidth()*r2.getWidth() + r2.getHeight()*r2.getHeight();
		
		double diag1 = Math.sqrt(square1);
		double diag2 = Math.sqrt(square2);
		
		if(diag1 > diag2) return 1;
		else if(diag1 < diag2) return -1;
		else return 0;
	}
}
