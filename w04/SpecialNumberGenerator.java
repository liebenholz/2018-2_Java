package w4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SpecialNumberGenerator {
	
	/**
	 * ù n���� �Ҽ��� ã�Ƴ���. n�� 1 �̻��̾�� ��.
	 * @param n �־��� ���� (n >= 1)
	 * @return ���� �Ҽ����� ����ִ� Collection.
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
	 * �̹� ã�� �Ҽ����� �־����� �� �� ���� �Ҽ��� ã�´�.
	 * @param primes �̹� ã�� �Ҽ����� ����ִ� ����Ʈ.
	 * @return ã�� ���� �Ҽ�.
	 */
	private long getNextPrime(List<Long> primes) {
		// ����Ʈ�� �ִ� ������ �Ҽ��̴�.
		// �� �Ҽ��� �� ���� ū ������ �� ū �ڿ����� �߿��� �� �Ҽ��� ã�´�.
		int currentIndex = primes.size() - 1;			// ����Ʈ ������ ������ �ε���
		long currentPrime = primes.get(currentIndex);	// ����Ʈ ������ ����
		long i = currentPrime + 1;		// i �̻��� �� �߿��� ù �Ҽ��� ã�´�.
		boolean found = false;
		
		while (!found) {
			// i�� ����Ʈ�� �ִ� �Ҽ��� �� ��� �ϳ��� ������ �������� i�� �Ҽ��� �ƴϴ�.
			int j;
			for (j = 0; j < currentIndex; j++)
				if(i % primes.get(j) == 0) break;
			
			// break�� ���� for-loop�� �������Դ����� ����
			if (j == currentIndex) found = true;
			else i++;
		}
		return i;
	}
	
	/**
	 * ù n���� �����̼��� ã�Ƴ���. n�� 1 �̻��̾�� �Ѵ�.
	 * @param n �־��� ���� (n >= 1)
	 * @return ã�� �����̼����� ��� �ִ� Collection. 
	 */
	public Collection<Long> getUglies (int n) {

		// SortedSet Ÿ�� ���� ����, TreeSet<Long> �ν��Ͻ� ����.
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
		System.out.println("�����̼� : " + ugly);
		System.out.println();
		
		// (��) 500���� �Ҽ�
		Collection<Long> prime = generator.getPrimes(500);
		System.out.println("�Ҽ� : " + prime);
		
		// (��) 130���� �����̼�
		ugly = generator.getUglies(130);
		System.out.println("�����̼� : " + ugly);
		System.out.println();
			
		// (��) (��)�� �Ҽ��� (��)�� ������
		prime.retainAll(ugly);
		System.out.println("Intersection : " + prime);
		System.out.println();
		
		// (��) (��)�� �Ҽ��� (��)�� ������
		prime = generator.getPrimes(500);
		prime.addAll(ugly);
		SortedSet<Long> union = new TreeSet<>(prime);
		System.out.println("Union : " + union);
		System.out.println();
		
		// (��) ������ ���� �� �� 20�� ���
		List<Long> printList = new ArrayList<>(union);
		ListIterator<Long> itList = printList.listIterator();
		count = 0;
		
		System.out.print("Union �� 20�� �� : ");
		while (count < 20) {
			System.out.print(itList.next() + " ");
			count++;
		}
		System.out.println();
		
		// (��) ������ ���� �� �� 10�� ���
		itList = printList.listIterator(union.size() - 10);
		System.out.print("Union �� 10�� �� : ");
		while (itList.hasNext()) {
			System.out.print(itList.next() + " ");
		}
	}
}
