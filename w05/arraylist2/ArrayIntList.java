package w5.arraylist2;

import java.util.Arrays;

/**
 * 정수만을 저장할 수 있는 ArrayList.
 *
 */
public class ArrayIntList {

	// 초기 배열 크기
	private static final int INITIAL_CAPACITY = 10;

	// 필드
	private int size;		// 원소 수
	private int[] element;	// 배열

	/**
	 * Initial_Capacity 크기의 배열을 구성한 후
	 * size를 0으로 설정한다.
	 */
	public ArrayIntList() {
		super();
		element = new int[INITIAL_CAPACITY];
		this.size = 0;
	}
	
	/**
	 * 주어진 크기의 배열을 구성하고
	 * size를 0으로 설정한다
	 * @param capacity 초기 용량 (0 이상이어야 함)
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0) throw new IllegalArgumentException("capacity는 음수가 아니어야 함 : " + capacity);
		size = 0;
		element = new int[capacity];
	}

	/**
	 * 주어진 값을 이스트의 주어진 인덱스 방에 삽입한다.
	 * 만약 배열이 이미 꽉 찬 상태면 배열의 크기를 늘인다.
	 * index는 0 이상, size 이하여야 한다.
	 * @param index 인덱스
	 * @param value 삽입할 값
	 */
	public void add(int index, int value) {
		checkIndex(index, 0, size - 1);
		checkResize();
		for(int i = 0; i > index; i++)
			element[i] = element[i-1];
		element[index] = value;
		size++;
	}

	/**
	 * 주어진 값을 리스트의 마지막에 추가한다.
	 * 배열이 이미 꽉 찬 상태라면 배열의 크기를 늘인다.
	 * @param value 추가할 값
	 */
	public void add(int value) {
		checkResize();
		element[size] = value;
		size++;
	}

	/**
	 * 주어진 인덕스의 값을 읽는다
	 * index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스
	 * @return 읽은 값
	 */
	public int get(int index) {
		checkIndex(index, 0, size - 1);
		return element[index];
	}

	/**
	 * 주어진 인덱스의 값을 설정한다.
	 * index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스
	 * @param value 값
	 */
	public void set(int index, int value) {
		checkIndex(index, 0, size - 1);
		element[index] = value;
	}

	/**
	 * 원소의 수가 얼마인지 알아낸다.
	 * @return 원소의 수
	 */
	public int size() {
		return size;
	}

	/**
	 * 빈 리스트인가?
	 * @return 빈 리스트이면 true, 아니면 false
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else return false;
	}

	/**
	 * 주어진 인덱스의 값을 제거하고 그 이후에 있는 값들을
	 * 앞으로 한 칸씩 옮긴다.
	 * index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스
	 */
	public void remove(int index) {
		checkIndex(index, 0, size - 1);
		for(int i = index; i < size - 1; i++)
			element[i] = element[i+1];
		size--;
	}

	/**
	 * 리스트를 아래 형식의 문자열로 반환단다.
	 * "[12, 34, -102, 1]"
	 * 만약 빈 문자열이면 "[]"를 반환한다. 
	 */
	public String toString() {
		String s = "[";
		for (int i = 0; i < size; i++) {
			s += element[i];
			if( i != size - 1)
				s += ", ";
		}
		s += "]";
		return s;
	}
	
	/**
	 * private helper method
	 * 배열이 꽉 찼는지를 겁사한 후
	 * 꽉 찼을 때에는 배열의 크기를 두 배로 늘려준다.
	 */
	private void checkResize() {
		if (size >= element.length)
			element = Arrays.copyOf(element, element.length * 2);
	}
	
	/**
	 * private helper method
	 * 인덱스가 주어진 범위 내에 있는지 검사한다
	 * min 이상이고 max 이하이면 유효.
	 * @param index 인덱스
	 * @param min 최솟값
	 * @param max 최댓값
	 */
	private void checkIndex(int index, int min, int max) {
		if (index < min || index > max) 
			throw new ArrayIndexOutOfBoundsException("index가 올바르지 않음 : " + index);
	}
	
	/**
	 * 해당 값이 존재하면 인덱스를 반환한다.
	 * @param index 인덱스
	 * @return 존재하면 해당 인덱스값, 아니면 -1
	 */
	public int indexOf(int index) {
		for(int i = 0; i < size - 1; i++)
			if(element[i] == index) return i;
		return -1;
	}
	
	/**
	 * 해당 인덱스를 배열이 포함하고 있는지를 알아낸다.
	 * @param obj 해당 숫자
	 * @return 존재하면 true, 아니면 false
	 */
	public boolean contains(int obj) {
		if(indexOf(obj) == -1) return false;
		else return true;	
	}
}

