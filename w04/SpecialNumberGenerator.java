package w4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SpecialNumberGenerator {
	
	/**
	 * Ã¹ n°³ÀÇ ¼Ò¼ö¸¦ Ã£¾Æ³½´Ù. nÀº 1 ÀÌ»óÀÌ¾î¾ß ÇÔ.
	 * @param n ÁÖ¾îÁø °¹¼ö (n >= 1)
	 * @return ¯Àº ¼Ò¼öµéÀÌ µé¾îÀÖ´Â Collection.
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
	 * ÀÌ¹Ì Ã£Àº ¼Ò¼öµéÀÌ ÁÖ¾îÁ³À» ¶§ ±× ´ÙÀ½ ¼Ò¼ö¸¦ Ã£´Â´Ù.
	 * @param primes ÀÌ¹Ì Ã£Àº ¼Ò¼öµéÀÌ µé¾îÀÖ´Â ¸®½ºÆ®.
	 * @return Ã£Àº ´ÙÀ½ ¼Ò¼ö.
	 */
	private long getNextPrime(List<Long> primes) {
		// ¸®½ºÆ®¿¡ ÀÖ´Â ¼öµéÀº ¼Ò¼öÀÌ´Ù.
		// ±× ¼Ò¼öµé Áß °¡Àå Å« ¼öº¸´Ù ´õ Å« ÀÚ¿¬¼öµé Áß¿¡¼­ »õ ¼Ò¼ö¸¦ Ã£´Â´Ù.
		int currentIndex = primes.size() - 1;			// ¸®½ºÆ® ¸¶Áö¸· ¿ø¼ÒÀÇ ÀÎµ¦½º
		long currentPrime = primes.get(currentIndex);	// ¸®½ºÆ® ¸¶Áö¸· ¿ø¼Ò
		long i = currentPrime + 1;		// i ÀÌ»óÀÇ ¼ö Áß¿¡¼­ Ã¹ ¼Ò¼ö¸¦ Ã£´Â´Ù.
		boolean found = false;
		
		while (!found) {
			// i°¡ ¸®½ºÆ®¿¡ ÀÖ´Â ¼Ò¼öµé Áß ¾î´Â ÇÏ³ª·Î ³ª´©¾î ¶³¾îÁö¸é i´Â ¼Ò¼ö°¡ ¾Æ´Ï´Ù.
			int j;
			for (j = 0; j < currentIndex; j++)
				if(i % primes.get(j) == 0) break;
			
			// break¿¡ ÀÇÇØ for-loopÀ» ºüÁ®³ª¿Ô´ÂÁö¿¡ µû¶ó
			if (j == currentIndex) found = true;
			else i++;
		}
		return i;
	}
	
	/**
	 * Ã¹ n°³ÀÇ ¸ø³­ÀÌ¼ö¸¦ Ã£¾Æ³½´Ù. nÀº 1 ÀÌ»óÀÌ¾î¾ß ÇÑ´Ù.
	 * @param n ÁÖ¾îÁø °¹¼ö (n >= 1)
	 * @return Ã£Àº ¸ø³­ÀÌ¼öµéÀÌ µé¾î ÀÖ´Â Collection. 
	 */
	public Collection<Long> getUglies (int n) {

		// SortedSet Å¸ÀÔ º¯¼ö ¼±¾ğ, TreeSet<Long> ÀÎ½ºÅÏ½º ±¸¼º.
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
		System.out.println("¸ø³­ÀÌ¼ö : " + ugly);
		System.out.println();
		
		// (°¡) 500°³ÀÇ ¼Ò¼ö
		Collection<Long> prime = generator.getPrimes(500);
		System.out.println("¼Ò¼ö : " + prime);
		
		// (³ª) 130°³ÀÇ ¸ø³­ÀÌ¼ö
		ugly = generator.getUglies(130);
		System.out.println("¸ø³­ÀÌ¼ö : " + ugly);
		System.out.println();
			
		// (´Ù) (°¡)ÀÇ ¼Ò¼ö¿Í (³ª)ÀÇ ±³ÁıÇÕ
		prime.retainAll(ugly);
		System.out.println("Intersection : " + prime);
		System.out.println();
		
		// (¶ó) (°¡)ÀÇ ¼Ò¼ö¿Í (³ª)ÀÇ ÇÕÁıÇÕ
		prime = generator.getPrimes(500);
		prime.addAll(ugly);
		SortedSet<Long> union = new TreeSet<>(prime);
		System.out.println("Union : " + union);
		System.out.println();
		
		// (¸¶) ÇÕÁıÇÕ Á¤·Ä ÈÄ ¾Õ 20°³ Ãâ·Â
		List<Long> printList = new ArrayList<>(union);
		ListIterator<Long> itList = printList.listIterator();
		count = 0;
		
		System.out.print("Union ¾Õ 20°³ ¼ö : ");
		while (count < 20) {
			System.out.print(itList.next() + " ");
			count++;
		}
		System.out.println();
		
		// (¹Ù) ÇÕÁıÇÕ Á¤·Ä ÈÄ µÚ 10°¡ Ãâ·Â
		itList = printList.listIterator(union.size() - 10);
		System.out.print("Union µÚ 10°³ ¼ö : ");
		while (itList.hasNext()) {
			System.out.print(itList.next() + " ");
		}
	}
}
