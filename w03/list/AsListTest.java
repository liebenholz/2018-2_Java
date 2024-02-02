package week3.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AsListTest {

	public static void main(String[] args) {
		
		// 5��
		System.out.println("����Ʈ");
		List<Integer> list = Arrays.asList(1, -3, -7, 5);
		System.out.println(list);
		
		// ������ ��ȯ�ϴ��� api�� �������� �����Ƿ� ������ ���� ����� �� �ȴ�.
		/*
		ArrayList<Integer> list = Array.asList(1, 3, 5, 7);
		LinkedList<Integer> list = Array.asList(1, 3, 5,7);
		*/
		System.out.println();
		
		System.out.println("Natural Ordering�� ���� ���ĵ� ����Ʈ");
		Collections.sort(list);
		System.out.println(list);
		System.out.println();
		
		System.out.println("���밪�� ��������(Absolute Ordering) ���ĵ� ����Ʈ");
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
