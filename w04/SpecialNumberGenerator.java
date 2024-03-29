package w4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SpecialNumberGenerator {
	
	/**
	 * 첫 n개의 소수를 찾아낸다. n은 1 이상이어야 함.
	 * @param n 주어진 갯수 (n >= 1)
	 * @return 칮은 소수들이 들어있는 Collection.
	 */
	public Collection<Long> getPrimes (int n) {
		List<Long> primes = new ArrayList<>();
		primes.add(2L);
		long nextPrime = -1;
		while(primes.size() < n) {
			nextPrime = getNextPrime(primes);
			primes.add(nextPrime);
		}
		return primes;
	}
	
	/**
	 * 이미 찾은 소수들이 주어졌을 때 그 다음 소수를 찾는다.
	 * @param primes 이미 찾은 소수들이 들어있는 리스트.
	 * @return 찾은 다음 소수.
	 */
	private long getNextPrime(List<Long> primes) {
		// 리스트에 있는 수들은 소수이다.
		// 그 소수들 중 가장 큰 수보다 더 큰 자연수들 중에서 새 소수를 찾는다.
		int currentIndex = primes.size() - 1;			// 리스트 마지막 원소의 인덱스
		long currentPrime = primes.get(currentIndex);	// 리스트 마지막 원소
		long i = currentPrime + 1;		// i 이상의 수 중에서 첫 소수를 찾는다.
		boolean found = false;
		
		while (!found) {
			// i가 리스트에 있는 소수들 중 어는 하나로 나누어 떨어지면 i는 소수가 아니다.
			int j;
			for (j = 0; j < currentIndex; j++)
				if(i % primes.get(j) == 0) break;
			
			// break에 의해 for-loop을 빠져나왔는지에 따라
			if (j == currentIndex) found = true;
			else i++;
		}
		return i;
	}
	
	/**
	 * 첫 n개의 못난이수를 찾아낸다. n은 1 이상이어야 한다.
	 * @param n 주어진 갯수 (n >= 1)
	 * @return 찾은 못난이수들이 들어 있는 Collection. 
	 */
	public Collection<Long> getUglies (int n) {

		// SortedSet 타입 변수 선언, TreeSet<Long> 인스턴스 구성.
		SortedSet<Long> set = new TreeSet<>();
		Long arr[] = {2L, 3L, 5L};
		Long now = 1L;
		set.add(1L);
		
		while(set.size() < n) {
			for(Long i : arr) set.add(now * i);
			Long next = now;
			do next++; 
			while(set.tailSet(now).size() < set.tailSet(now).size());
			now = set.tailSet(next).first();
		}
		
		while(set.size() > n)
			set.remove(set.last());
		
		return set;
	}
	
	public static void main(String[] args) {
		SpecialNumberGenerator generator = new SpecialNumberGenerator();
		Collection<Long> c = generator.getPrimes(500);
		
		List<Long> list = new ArrayList<>(c);
		ListIterator<Long> lit= list.listIterator(list.size());
		int count = 0;
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
			if(++count >= 10) break;
		}
		System.out.println();
		
		Collection<Long> ugly = generator.getUglies(20);
		System.out.println("못난이수 : " + ugly);
		System.out.println();
		
		// (가) 500개의 소수
		Collection<Long> prime = generator.getPrimes(500);
		System.out.println("소수 : " + prime);
		
		// (나) 130개의 못난이수
		ugly = generator.getUglies(130);
		System.out.println("못난이수 : " + ugly);
		System.out.println();
			
		// (다) (가)의 소수와 (나)의 교집합
		prime.retainAll(ugly);
		System.out.println("Intersection : " + prime);
		System.out.println();
		
		// (라) (가)의 소수와 (나)의 합집합
		prime = generator.getPrimes(500);
		prime.addAll(ugly);
		SortedSet<Long> union = new TreeSet<>(prime);
		System.out.println("Union : " + union);
		System.out.println();
		
		// (마) 합집합 정렬 후 앞 20개 출력
		List<Long> printList = new ArrayList<>(union);
		ListIterator<Long> itList = printList.listIterator();
		count = 0;
		
		System.out.print("Union 앞 20개 수 : ");
		while (count < 20) {
			System.out.print(itList.next() + " ");
			count++;
		}
		System.out.println();
		
		// (바) 합집합 정렬 후 뒤 10가 출력
		itList = printList.listIterator(union.size() - 10);
		System.out.print("Union 뒤 10개 수 : ");
		while (itList.hasNext()) {
			System.out.print(itList.next() + " ");
		}
	}
}
