package week3.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RectangleTester {

	private void test() {
		Random r = new Random();
		Rectangle[] rectArray = new Rectangle[3];
		List<Rectangle> rectList = new ArrayList<>();

		for(int i = 0; i < 3; i++) {
			double w = r.nextDouble() * 100.0;
			double h = r.nextDouble() * 100.0;
			Rectangle rect = new Rectangle(w, h);
			rectArray[i] = rect;
			rectList.add(rect);
		}
		
		// 1번
		System.out.println("배열 출력, for-each loop 이용");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();

		System.out.println("ArrayList 출력, for-each loop 이용");
		for(Rectangle rect : rectList)
			System.out.println(rect);
		System.out.println();

		System.out.println("ArrayList 출력, Iterator 이용");
		Iterator<Rectangle> it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();


		System.out.println("ArrayList이 첫 사각형의 크기를 (1.0, 2.0)으로 변경");
		rectList.get(0).setDimension(1.0, 2.0);		// <------------------------
		System.out.println();

		System.out.println("배열 출력, for-each loop 이용");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();
		
		System.out.println("ArrayList 출력, Iterator 이용");
		it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();


		System.out.println("ArrayList이 첫 사각형의 크기를 (5.0, 5.0)으로 변경");
		rectList.set(0, new Rectangle(5.0, 5.0));	// <------------------------
		System.out.println();

		System.out.println("배열 출력, for-each loop 이용");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();
		
		System.out.println("ArrayList 출력, Iterator 이용");
		it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();
		
		// 4번
		System.out.println("정렬 ------------");
		System.out.println(Arrays.toString(rectArray));
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("ArrayList의 첫 사각형의 크기가 (0.1, 200.0)인 새 사각형으로 교체한다.");
		rectList.set(0, new Rectangle(0.1, 200.0));
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("면적을 기준으로(natural ordering) 정렬-----------");
		Collections.sort(rectList);
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("대각선 길이를 기준으로(DiagonalComparator) 정렬-----------");
		Collections.sort(rectList, new DiagonalComparator());
		System.out.println(rectList);
		System.out.println();
		
	}

	public static void main(String[] args) {
		RectangleTester tester = new RectangleTester();
		tester.test();
	}
	
}
