package w6.sortedlist2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SortedIntList extends ArrayIntList {

	private boolean uniqueness; // �����ߺ���������
	
	/**
	 * ������
	 * �����ߺ���������(uniqueness)�� false�� ������
	 * �⺻ �뷮�� ����Ʈ�� �����Ѵ�.
	 */
	public SortedIntList() {
		this(false, DEFAULT_CAPACITY);
	}
	
	/**
	 * ������
	 * �־��� ���� ���� �����ߺ���������(uniqueness)�� ��������
	 * �⺻ �뷮�� ����Ʈ�� �����Ѵ�.
	 * @param unique �����ߺ���������
	 */
	public SortedIntList(boolean unique) {
		this(unique, DEFAULT_CAPACITY);
	}
	
	/**
	 * ������
	 * �־��� ���� ���� �����ߺ���������(uniqueness)�� ��������
	 * �ش� �뷮�� ����Ʈ�� �����Ѵ�.
	 * @param unique �����ߺ���������
	 * @param capacity �뷮
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		setUnique(unique);
	}
	
	/**
	 * ������
	 * �����ߺ���������(uniqueness)�� false�� ������
	 * �ش� �뷮�� ����Ʈ�� �����Ѵ�.
	 * @param capacity �뷮
	 */
	public SortedIntList(int capacity) {
		this(false, capacity);
	}

	@Override
	/**
	 * ���������� �����ǵ��� ����Ʈ�� value�� ����ִ´�
	 */
	public void add(int value) {
		int index = Arrays.binarySearch(element, 0, size, value);
		// �ߺ� Ȯ��
		if (getUnique() && indexOf(value) >= 0)
			return;
		
		if (index < 0)
			index = index * -1 - 1;
		super.add(index, value);
	}

	@Override
	/**
	 * �� �޼ҵ�� �������� �ʴ´�.(����ó��)
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * �����ߺ��������θ� Ȯ���Ѵ�.
	 * @return �����ߺ���������
	 */
	public boolean getUnique() {
		return uniqueness;
	}

	/**
	 * �̺� Ž���� �̿��ϵ��� �Ѵ�.
	 */
	public int indexOf(int value) {
		int i = Arrays.binarySearch(element, 0, size, value);
		if (i < 0) return -1;
		return i;
	}
	
	/**
	 * ����Ʈ �� �ִ밪�� ����Ѵ�.
	 * @return �ִ�
	 */
	public int max() {
		if (size == 0) throw new NoSuchElementException();
		return element[size - 1];
	}
	
	/**
	 * ����Ʈ �� �ּڰ��� ����Ѵ�.
	 * @return �ּڰ�
	 */
	public int min() {
		if (size == 0) throw new NoSuchElementException();
		return element[0];
	}
	
	/**
	 * �����ߺ��������θ� �����Ѵ�.
	 * @param unique �����ߺ���������(���� �� true)
	 */
	public void setUnique(boolean unique) {
		this.uniqueness = unique;
	}
	
	@Override
	/**
	 * ����Ʈ�� ������ ���� ����ϵ��� �Ѵ�.
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
