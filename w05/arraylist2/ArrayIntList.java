package w5.arraylist2;

import java.util.Arrays;

/**
 * �������� ������ �� �ִ� ArrayList.
 *
 */
public class ArrayIntList {

	// �ʱ� �迭 ũ��
	private static final int INITIAL_CAPACITY = 10;

	// �ʵ�
	private int size;		// ���� ��
	private int[] element;	// �迭

	/**
	 * Initial_Capacity ũ���� �迭�� ������ ��
	 * size�� 0���� �����Ѵ�.
	 */
	public ArrayIntList() {
		super();
		element = new int[INITIAL_CAPACITY];
		this.size = 0;
	}
	
	/**
	 * �־��� ũ���� �迭�� �����ϰ�
	 * size�� 0���� �����Ѵ�
	 * @param capacity �ʱ� �뷮 (0 �̻��̾�� ��)
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0) throw new IllegalArgumentException("capacity�� ������ �ƴϾ�� �� : " + capacity);
		size = 0;
		element = new int[capacity];
	}

	/**
	 * �־��� ���� �̽�Ʈ�� �־��� �ε��� �濡 �����Ѵ�.
	 * ���� �迭�� �̹� �� �� ���¸� �迭�� ũ�⸦ ���δ�.
	 * index�� 0 �̻�, size ���Ͽ��� �Ѵ�.
	 * @param index �ε���
	 * @param value ������ ��
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
	 * �־��� ���� ����Ʈ�� �������� �߰��Ѵ�.
	 * �迭�� �̹� �� �� ���¶�� �迭�� ũ�⸦ ���δ�.
	 * @param value �߰��� ��
	 */
	public void add(int value) {
		checkResize();
		element[size] = value;
		size++;
	}

	/**
	 * �־��� �δ����� ���� �д´�
	 * index�� 0 �̻�, size �̸��̶�� �����Ѵ�.
	 * @param index �ε���
	 * @return ���� ��
	 */
	public int get(int index) {
		checkIndex(index, 0, size - 1);
		return element[index];
	}

	/**
	 * �־��� �ε����� ���� �����Ѵ�.
	 * index�� 0 �̻�, size �̸��̶�� �����Ѵ�.
	 * @param index �ε���
	 * @param value ��
	 */
	public void set(int index, int value) {
		checkIndex(index, 0, size - 1);
		element[index] = value;
	}

	/**
	 * ������ ���� ������ �˾Ƴ���.
	 * @return ������ ��
	 */
	public int size() {
		return size;
	}

	/**
	 * �� ����Ʈ�ΰ�?
	 * @return �� ����Ʈ�̸� true, �ƴϸ� false
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else return false;
	}

	/**
	 * �־��� �ε����� ���� �����ϰ� �� ���Ŀ� �ִ� ������
	 * ������ �� ĭ�� �ű��.
	 * index�� 0 �̻�, size �̸��̶�� �����Ѵ�.
	 * @param index �ε���
	 */
	public void remove(int index) {
		checkIndex(index, 0, size - 1);
		for(int i = index; i < size - 1; i++)
			element[i] = element[i+1];
		size--;
	}

	/**
	 * ����Ʈ�� �Ʒ� ������ ���ڿ��� ��ȯ�ܴ�.
	 * "[12, 34, -102, 1]"
	 * ���� �� ���ڿ��̸� "[]"�� ��ȯ�Ѵ�. 
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
	 * �迭�� �� á������ �̻��� ��
	 * �� á�� ������ �迭�� ũ�⸦ �� ��� �÷��ش�.
	 */
	private void checkResize() {
		if (size >= element.length)
			element = Arrays.copyOf(element, element.length * 2);
	}
	
	/**
	 * private helper method
	 * �ε����� �־��� ���� ���� �ִ��� �˻��Ѵ�
	 * min �̻��̰� max �����̸� ��ȿ.
	 * @param index �ε���
	 * @param min �ּڰ�
	 * @param max �ִ�
	 */
	private void checkIndex(int index, int min, int max) {
		if (index < min || index > max) 
			throw new ArrayIndexOutOfBoundsException("index�� �ùٸ��� ���� : " + index);
	}
	
	/**
	 * �ش� ���� �����ϸ� �ε����� ��ȯ�Ѵ�.
	 * @param index �ε���
	 * @return �����ϸ� �ش� �ε�����, �ƴϸ� -1
	 */
	public int indexOf(int index) {
		for(int i = 0; i < size - 1; i++)
			if(element[i] == index) return i;
		return -1;
	}
	
	/**
	 * �ش� �ε����� �迭�� �����ϰ� �ִ����� �˾Ƴ���.
	 * @param obj �ش� ����
	 * @return �����ϸ� true, �ƴϸ� false
	 */
	public boolean contains(int obj) {
		if(indexOf(obj) == -1) return false;
		else return true;	
	}
}

