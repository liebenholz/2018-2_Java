package w6.sortedlist3;

/**
 * �������� ������ �� �ִ� ArrayList, �� ��° ����.
 * Version 3.
 * �� ��° �������� �Ʒ� ������ �����.
 * - DEFAULT_CAPACITY, size, element �ʵ尡 protected�� �����.
 *   (����Ŭ�������� �� �ʵ忡 ������ �� �ְ� ��.)
 */

import java.util.Arrays;  

public class ArrayIntList {
	
	protected static final int DEFAULT_CAPACITY = 10;

	// fields
	protected int size;
	protected int[] element;

	/**
	 * INITIAL_CAPACITY ũ���� �迭�� �����ϰ�
	 * size�� 0���� �����Ѵ�.
	 */
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);   // call the (int) constructor
	}

	/**
	 * �־��� �뷮�� �� ����Ʈ�� �����Ѵ�.
	 * @param capacity �ʱ� �뷮. {@literal capacity >= 0}.
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity�� ������ �ƴϾ�� ��: " + capacity);
		}
		size = 0;
		element = new int[capacity];
	}

	/**
	 * �־��� ���� ����Ʈ�� �������� �߰��Ѵ�.
	 * ���� �迭�� �̹� �� �� �����̸� �迭�� ũ�⸦ ���δ�.
	 * @param value �߰��� ��.
	 */
	public void add(int value) {
		add(size, value);
	}

	/**
	 * �־��� ���� ����Ʈ�� �־��� �ε��� �濡 �����Ѵ�.
	 * ���� �迭�� �̹� �� �� �����̸� �迭�� ũ�⸦ ���δ�.
	 * @param index �ε���. {@literal 0 <= index <= size}
	 * @param value ������ ��.
	 */
	public void add(int index, int value) {

		checkIndex(index, 0, size);
		// �� üũ�� ��������� �ε����� ���� ���������� ������ ����.

		checkResize();

		// slide elements to the right to make room
		for (int i = size; i > index; i--) {
			element[i] = element[i - 1];
		}

		// insert the value in the hole we just made
		element[index] = value;
		size++;

	}

	/**
	 * �־��� �ε����� ���� �д´�.
	 * @param index �ε���. {@literal 0 <= index < size}.
	 * @return �־��� �ε��� ��ġ�� �ִ� ��.
	 */
	public int get(int index) {

		checkIndex(index, 0, size - 1);
		// �� üũ�� ��������� �ε����� ���� ���������� ������ ����.

		return element[index];
	}

	/**
	 * �־��� �ε����� ���� �����Ѵ�.
	 * @param index �ε���. {@literal 0 <= index <= size}
	 * @param value ��.
	 */
	public void set(int index, int value) {

		checkIndex(index, 0, size);
		// �� üũ�� ��������� �ε����� ���� ���������� ������ ����.

		element[index] = value;
	}

	/**
	 * ������ ���� ������ �˾Ƴ���.
	 * @return ������ ��.
	 */
	public int size() {
		return size;
	}

	/**
	 * �� ����Ʈ�ΰ�?
	 * @return �� ����Ʈ�ΰ�� true, �׷��� ������ false.
	 */
	public boolean isEmpty() {
		return size == 0;  
	}

	/**
	 * �־��� �ε����� ���� �����ϰ� �� ���Ŀ� �ִ� ������
	 * ������ �� ĭ�� �̵��Ѵ�.
	 * @param index �ε���. {@literal 0 <= index < size}.
	 */
	public void remove(int index) {

		checkIndex(index, 0, size - 1);
		// �� üũ�� ��������� �ε����� ���� ���������� ������ ����.

		for (int i = index; i < size - 1; i++) {
			element[i] = element[i + 1];
		}
		size--;
	}

	/**
	 * �־��� ���� ����Ʈ���� �� �� �濡 �ִ��� �˾ƺ���.
	 * ���� ���� �� ������ �� �� ù ��° ���� �� ��ȣ�� ��ȯ�Ѵ�.
	 * @param value ã�� ��.
	 * @return �� ��ȣ, ���� ���� ���ٸ� -1.
	 */
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (element[i] == value) {
				return i;
			}
		}
		return -1;   // not found
	}

	/**
	 * �־��� ���� ����Ʈ�� ��� �ֳ�?
	 * @param value ��.
	 * @return ���� ����Ʈ�� ��� ������ true, �׷��� ������ false.
	 */
	public boolean contains(int value) {
		return indexOf(value) >= 0;
	}

	/**
	 * ����Ʈ�� �Ʒ� ������ ���ڿ��� ��ȯ�Ѵ�.
	 * "[12, 34, -102, 1]"
	 * ���� �� ���ڿ��̸� "[]"�� ��ȯ�Ѵ�.
	 */
	public String toString() {
		if (size > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i < size - 1; i++)
				sb.append(element[i] + ", ");
			sb.append(element[size - 1] + "");
			sb.append("]");
			return sb.toString();
		}
		else
			return "[]";
	}
	
	/**
	 * private helper method.
	 * �迭�� �� á���� �˻��ϰ�
	 * �� �� ��� �迭�� ũ�⸦ �ι�� �ÿ��ش�.
	 */
	private void checkResize() {

		if (size == element.length) {
			// resize the array
			element = Arrays.copyOf(element, 2 * size);
		}
	}

	/**
	 * private helper method.
	 * �ε����� �־��� ���� ���� �ִ��� �˻��Ѵ�.
	 * min �̻��̰� max �����̸� ��ȿ�ϴ�.
	 * @param index �ε���.
	 * @param min �ּҰ�.
	 * @param max �ִ밪.
	 */
	private void checkIndex(int index, int min, int max) {
		if (index < min || index > max) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

}
