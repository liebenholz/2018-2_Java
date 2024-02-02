package w5;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

	/**
	 * 두 리스트의 교집합을 구한다.
	 * @param list1
	 * @param list2
	 * @return 교집합이 들어 있는 새로운 list
	 */
	public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(list1);
		list.retainAll(list2);

		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		for(int i = 0; i < 10; i++) 
			list1.add(2 * i);

		for(int i = 0; i < 15; i++) 
			list2.add(3 * i);
		
		System.out.println(list1);
		System.out.println(list2);
		
		// intersection을 이용
		List<Integer> interList = new ArrayList<Integer>();
		interList = intersection(list1, list2);
		System.out.println(interList);
	}

}
