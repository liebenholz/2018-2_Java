package w6.stutterlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StutterIntList extends ArrayIntList {

	// "stretch factor(반복도)" - 원소를 추가할 때 몇 개씩이나 추가하게 될 것인가?
	private int stretch;
	
	/**
	 * 구성자
	 * 주어진 stretch factor와 주어진 용량을 갖는 리스트를 구성한다.
	 * @param stretch 반복도. {@literal stretch >= 0}
	 * @param capacity 용량(배열의 크기). {@literal stretch >= 0} 
	 */
	public StutterIntList(int stretch, int capacity) {
		super(capacity);	// ArrayIntist 클래스의 구성자를 호출함
		
		if (stretch < 0) throw new IllegalArgumentException("반복되는 음수일 수 없습니다:" + stretch);
		this.stretch = stretch;	// 이 클래스에서 추가로 선언한 필드를 초기화함
	}
	
	/**
	 * 구성자.
	 * 주어진 stretch factor와 주어진 용량을 갖는 리스트를 구성한다.
	 * @param stretch 반복도. {@literal stretch >= 0}
	 */
	public StutterIntList(int stretch) {
		this(stretch, DEFAULT_CAPACITY);	// 클래스의 다른 구성자를 호출한다.
	}
	
	/**
	 * 주어진 값을 주어진 위치에 추가하되 stretch factor 수 만큼 추가한다. 
	 */
	public void add(int index, int value) {
		for (int i = 1; i <= stretch; i++)
			super.add(index, value);
	}
	
	/**
	 * 주어진 값을 리스트에 추가하되 stretch factor 수 만큼 추가한다.
	 */
	public void add(int value) {
		add(size,value);
	}
	
	/**
	 * 이 StutterIntList의 stretch factor를 반환한다.
	 * @return stretch factor
	 */
	public int getStretch() {
		return stretch;
	}
	
	/**
	 * 주어진 값이 이 리스트에 몇 개나 있는지 알아낸다
	 * @param value 주어진 값
	 * @return 리스트에 value가 몇 개 있는가?
	 */
	public int count(int value) {
		int num = 0;
		for (int i = 0; i < size; i++)
			if (element[i] == value)
				num++;
		return num;
	}
	
	/**
	 * 이 리스트에 들어있는 값이 각가 몇 개씩이나 들어 있는지 알려준다
	 * @return 리스트에 value 값이 몇 개 씩이나 들어있는가?를 저장한 Map
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
