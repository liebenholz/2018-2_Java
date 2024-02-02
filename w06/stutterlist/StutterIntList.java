package w6.stutterlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StutterIntList extends ArrayIntList {

	// "stretch factor(�ݺ���)" - ���Ҹ� �߰��� �� �� �����̳� �߰��ϰ� �� ���ΰ�?
	private int stretch;
	
	/**
	 * ������
	 * �־��� stretch factor�� �־��� �뷮�� ���� ����Ʈ�� �����Ѵ�.
	 * @param stretch �ݺ���. {@literal stretch >= 0}
	 * @param capacity �뷮(�迭�� ũ��). {@literal stretch >= 0} 
	 */
	public StutterIntList(int stretch, int capacity) {
		super(capacity);	// ArrayIntist Ŭ������ �����ڸ� ȣ����
		
		if (stretch < 0) throw new IllegalArgumentException("�ݺ��Ǵ� ������ �� �����ϴ�:" + stretch);
		this.stretch = stretch;	// �� Ŭ�������� �߰��� ������ �ʵ带 �ʱ�ȭ��
	}
	
	/**
	 * ������.
	 * �־��� stretch factor�� �־��� �뷮�� ���� ����Ʈ�� �����Ѵ�.
	 * @param stretch �ݺ���. {@literal stretch >= 0}
	 */
	public StutterIntList(int stretch) {
		this(stretch, DEFAULT_CAPACITY);	// Ŭ������ �ٸ� �����ڸ� ȣ���Ѵ�.
	}
	
	/**
	 * �־��� ���� �־��� ��ġ�� �߰��ϵ� stretch factor �� ��ŭ �߰��Ѵ�. 
	 */
	public void add(int index, int value) {
		for (int i = 1; i <= stretch; i++)
			super.add(index, value);
	}
	
	/**
	 * �־��� ���� ����Ʈ�� �߰��ϵ� stretch factor �� ��ŭ �߰��Ѵ�.
	 */
	public void add(int value) {
		add(size,value);
	}
	
	/**
	 * �� StutterIntList�� stretch factor�� ��ȯ�Ѵ�.
	 * @return stretch factor
	 */
	public int getStretch() {
		return stretch;
	}
	
	/**
	 * �־��� ���� �� ����Ʈ�� �� ���� �ִ��� �˾Ƴ���
	 * @param value �־��� ��
	 * @return ����Ʈ�� value�� �� �� �ִ°�?
	 */
	public int count(int value) {
		int num = 0;
		for (int i = 0; i < size; i++)
			if (element[i] == value)
				num++;
		return num;
	}
	
	/**
	 * �� ����Ʈ�� ����ִ� ���� ���� �� �����̳� ��� �ִ��� �˷��ش�
	 * @return ����Ʈ�� value ���� �� �� ���̳� ����ִ°�?�� ������ Map
	 */
	public Map<Integer, Integer> counts() {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < size; i++) {
			set.add(element[i]);
		}
		
		Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				Integer e = it.next();
				map.put(e, count(e));
			}

		return map;
	}
}
