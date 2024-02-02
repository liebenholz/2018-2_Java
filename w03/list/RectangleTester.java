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
		
		// 1��
		System.out.println("�迭 ���, for-each loop �̿�");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();

		System.out.println("ArrayList ���, for-each loop �̿�");
		for(Rectangle rect : rectList)
			System.out.println(rect);
		System.out.println();

		System.out.println("ArrayList ���, Iterator �̿�");
		Iterator<Rectangle> it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();


		System.out.println("ArrayList�� ù �簢���� ũ�⸦ (1.0, 2.0)���� ����");
		rectList.get(0).setDimension(1.0, 2.0);		// <------------------------
		System.out.println();

		System.out.println("�迭 ���, for-each loop �̿�");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();
		
		System.out.println("ArrayList ���, Iterator �̿�");
		it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();


		System.out.println("ArrayList�� ù �簢���� ũ�⸦ (5.0, 5.0)���� ����");
		rectList.set(0, new Rectangle(5.0, 5.0));	// <------------------------
		System.out.println();

		System.out.println("�迭 ���, for-each loop �̿�");
		for(Rectangle rect : rectArray)
			System.out.println(rect);
		System.out.println();
		
		System.out.println("ArrayList ���, Iterator �̿�");
		it = rectList.iterator();
		while(it.hasNext()) {
			Rectangle rect = it.next();
			System.out.println(rect);
		}
		System.out.println();
		
		// 4��
		System.out.println("���� ------------");
		System.out.println(Arrays.toString(rectArray));
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("ArrayList�� ù �簢���� ũ�Ⱑ (0.1, 200.0)�� �� �簢������ ��ü�Ѵ�.");
		rectList.set(0, new Rectangle(0.1, 200.0));
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("������ ��������(natural ordering) ����-----------");
		Collections.sort(rectList);
		System.out.println(rectList);
		System.out.println();
		
		System.out.println("�밢�� ���̸� ��������(DiagonalComparator) ����-----------");
		Collections.sort(rectList, new DiagonalComparator());
		System.out.println(rectList);
		System.out.println();
		
	}

	public static void main(String[] args) {
		RectangleTester tester = new RectangleTester();
		tester.test();
	}
	
}
