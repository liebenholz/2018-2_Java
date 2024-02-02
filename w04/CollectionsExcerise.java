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

		final int N = 100;		// 난수 발생 갯수
		final int MAX = 10;		// 난수의 최댓값 + 1
								// MAX가 10인 경우 10 미만의 난수를 생성
		Random random = new Random();

		System.out.println("N(난수 발생 갯수) = " + N);
		System.out.println("MAX(난수 최댓값 + 1) = " + MAX);

		// 0 이상 MAX 미만 정수 난수를 N개 발생시켜 리스트에 저장한다.
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) 
			list.add(random.nextInt(MAX));

		// 리스트를 출력한다.
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println();
		
		// Collections를 이용해 sort한 후 Iterator를 이용해 다시 출력 
		System.out.println("list - 오름차순으로 정렬된 난수");
		Collections.sort(list);
		
		it = list.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
		}
		System.out.println();
		
		// Set을 이용해 중복 제거
		System.out.println("set - 중복을 제거한 난수 집합");
		Set<Integer> set = new HashSet<>(list);
		set.addAll(list);
		
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();
		
		// 해당 난수들이 각각 몇 번 중복되었는지 Map에 저장한다.
		System.out.println("list의 각 숫자들은 몇 번 중복되었는가?");
		System.out.println("map - 숫자 : 중복도 (중복도 1은 중목되지 않았다는 뜻)");
		
		Map<Integer, Integer> map = new HashMap<>();
		iterator = list.iterator();
		int count = 0;
		for (Integer i : set) {
			it = list.iterator();	// i가 이스트에 몇 번 들어있는지 조사한다.
			while (it.hasNext())
				if (it.next().equals(i))
					count ++;
			map.put(i, count);		// 맵에 저장하고 count 리셋.
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
		
		// 중복도 도수분포
		System.out.println("중복도 도수분포");
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
			System.out.println(i + "중복 : " + histogram[i] + "개");
		
	}

}
