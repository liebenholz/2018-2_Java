package week3.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AsListTest {

	public static void main(String[] args) {
		
		// 5번
		System.out.println("리스트");
		List<Integer> list = Arrays.asList(1, -3, -7, 5);
		System.out.println(list);
		
		// 무엇을 반환하는지 api에 적혀있지 않으므로 다음과 같이 적어서는 안 된다.
		/*
		ArrayList<Integer> list = Array.asList(1, 3, 5, 7);
		LinkedList<Integer> list = Array.asList(1, 3, 5,7);
		*/
		System.out.println();
		
		System.out.println("Natural Ordering에 의해 정렬된 리스트");
		Collections.sort(list);
		System.out.println(list);
		System.out.println();
		
		System.out.println("절대값을 기준으로(Absolute Ordering) 정렬된 리스트");
		Collections.sort(list, new AbsoluteComparator());
		System.out.println(list);
		
	}

}

class AbsoluteComparator implements Comparator<Integer> {
	
	public int compare(Integer a, Integer b) {
		if(a < 0) a*=-1;
		if(b < 0) b*=-1;
		
		if(a > b) return 1;
		else if(a < b) return -1;
		else return 0;
	}
	
}
