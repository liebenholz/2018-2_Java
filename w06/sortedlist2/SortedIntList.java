package w6.sortedlist2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SortedIntList extends ArrayIntList {

	private boolean uniqueness; // 원소중복금지여부
	
	/**
	 * 구성자
	 * 원소중복금지여부(uniqueness)가 false로 설정된
	 * 기본 용량의 리스트를 설정한다.
	 */
	public SortedIntList() {
		this(false, DEFAULT_CAPACITY);
	}
	
	/**
	 * 구성자
	 * 주어진 값에 따라 원소중복금지여부(uniqueness)가 정해지는
	 * 기본 용량의 리스트를 설정한다.
	 * @param unique 원소중복금지여부
	 */
	public SortedIntList(boolean unique) {
		this(unique, DEFAULT_CAPACITY);
	}
	
	/**
	 * 구성자
	 * 주어진 값에 따라 원소중복금지여부(uniqueness)가 정해지는
	 * 해당 용량의 리스트를 설정한다.
	 * @param unique 원소중복금지여부
	 * @param capacity 용량
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		setUnique(unique);
	}
	
	/**
	 * 구성자
	 * 원소중복금지여부(uniqueness)가 false로 설정된
	 * 해당 용량의 리스트를 설정한다.
	 * @param capacity 용량
	 */
	public SortedIntList(int capacity) {
		this(false, capacity);
	}

	@Override
	/**
	 * 오름차순이 유지되도록 리스트에 value를 집어넣는다
	 */
	public void add(int value) {
		int index = Arrays.binarySearch(element, 0, size, value);
		// 중복 확인
		if (getUnique() && indexOf(value) >= 0)
			return;
		
		if (index < 0)
			index = index * -1 - 1;
		super.add(index, value);
	}

	@Override
	/**
	 * 본 메소드는 지원하지 않는다.(예외처리)
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 원소중복금지여부를 확인한다.
	 * @return 원소중복금지여부
	 */
	public boolean getUnique() {
		return uniqueness;
	}

	/**
	 * 이분 탐색을 이용하도록 한다.
	 */
	public int indexOf(int value) {
		int i = Arrays.binarySearch(element, 0, size, value);
		if (i < 0) return -1;
		return i;
	}
	
	/**
	 * 리스트 내 최대값을 출력한다.
	 * @return 최댓값
	 */
	public int max() {
		if (size == 0) throw new NoSuchElementException();
		return element[size - 1];
	}
	
	/**
	 * 리스트 내 최솟값을 출력한다.
	 * @return 최솟값
	 */
	public int min() {
		if (size == 0) throw new NoSuchElementException();
		return element[0];
	}
	
	/**
	 * 원소중복금지여부를 설정한다.
	 * @param unique 월소중복금지여부(금지 시 true)
	 */
	public void setUnique(boolean unique) {
		this.uniqueness = unique;
	}
	
	@Override
	/**
	 * 리스트를 다음과 같이 출력하도록 한다.
	 * "S : [, , , ]"
	 * "S : [, , , ]U"
	 */
	public String toString() {
		String s = "S:";
		s += super.toString();
		if (getUnique()) s += "U";
		return s;
	}
	
}
