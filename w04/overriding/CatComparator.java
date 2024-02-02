package w4.overriding;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat>{
	
	/**
	 * 이름순으로 정렬, 이름이 같으면 나이 순으로 정렬하는 compare 메소드.
	 */
	public int compare(Cat c1, Cat c2) {
		if(c1.name.equals(c2.name)) {
			if(c1.getAge() > c2.getAge()) return 1;
			else return -1;
		}
		else return c1.name.compareTo(c2.name);
	}

}