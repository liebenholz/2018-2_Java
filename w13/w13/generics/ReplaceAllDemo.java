package w13.generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class ReplaceAllDemo {

	public static void main(String[] args) {

		List<Object> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-1);
		list.add(3);
		System.out.println("List<Integer> : " + list);
		
		System.out.println("모든 3을 30으로 교체");
		Collections.replaceAll(list, 3, 30);
		System.out.println(list);
		System.out.println();
		
		list.removeAll(list);
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(-1.0);
		list.add(3.0);
		System.out.println("List<Float> : " + list);
		
		System.out.println("모든 3.0을 30.0으로 교체");
		Collections.replaceAll(list, 3.0, 30.0);
		System.out.println(list);
		System.out.println();
		
		list.removeAll(list);
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		list.add("봄");
		list.add("봄");
		System.out.println("List<String> : " + list);
		
		System.out.println("모든 \"봄\"을 \"여름\"으로 교체");
		Collections.replaceAll(list, "봄", "여름");
		System.out.println(list);
		System.out.println();

	}
}
