package w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CollectionsExcerise {

	public static void main(String[] args) {

		final int N = 100;		// ���� �߻� ����
		final int MAX = 10;		// ������ �ִ� + 1
								// MAX�� 10�� ��� 10 �̸��� ������ ����
		Random random = new Random();

		System.out.println("N(���� �߻� ����) = " + N);
		System.out.println("MAX(���� �ִ� + 1) = " + MAX);

		// 0 �̻� MAX �̸� ���� ������ N�� �߻����� ����Ʈ�� �����Ѵ�.
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) 
			list.add(random.nextInt(MAX));

		// ����Ʈ�� ����Ѵ�.
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println();
		
		// Collections�� �̿��� sort�� �� Iterator�� �̿��� �ٽ� ��� 
		System.out.println("list - ������������ ���ĵ� ����");
		Collections.sort(list);
		
		it = list.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println();
		
		// Set�� �̿��� �ߺ� ����
		System.out.println("set - �ߺ��� ������ ���� ����");
		Set<Integer> set = new HashSet<>(list);
		set.addAll(list);
		
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();
		
		// �ش� �������� ���� �� �� �ߺ��Ǿ����� Map�� �����Ѵ�.
		System.out.println("list�� �� ���ڵ��� �� �� �ߺ��Ǿ��°�?");
		System.out.println("map - ���� : �ߺ��� (�ߺ��� 1�� �߸���� �ʾҴٴ� ��)");
		
		Map<Integer, Integer> map = new HashMap<>();
		iterator = list.iterator();
		int count = 0;
		for (Integer i : set) {
			it = list.iterator();	// i�� �̽�Ʈ�� �� �� ����ִ��� �����Ѵ�.
			while (it.hasNext())
				if (it.next().equals(i))
					count ++;
			map.put(i, count);		// �ʿ� �����ϰ� count ����.
			count = 0;
		}
		
		Set<Integer> keys = map.keySet();
		it = keys.iterator();
		Integer key;
		while(it.hasNext()) {
			key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();
		
		// �ߺ��� ��������
		System.out.println("�ߺ��� ��������");
		int[] histogram = new int[N+1];
		int value;
		int max = 0;
		it = keys.iterator();
		while(it.hasNext()) {
			key = it.next();
			value = map.get(key);
			histogram[value]++;
			if (max < value) max= value;
		}
		
		for (int i = 1; i <= max; i++)
			System.out.println(i + "�ߺ� : " + histogram[i] + "��");
		
	}

}
