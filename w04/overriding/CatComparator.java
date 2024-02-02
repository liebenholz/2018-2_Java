package w4.overriding;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat>{
	
	/**
	 * �̸������� ����, �̸��� ������ ���� ������ �����ϴ� compare �޼ҵ�.
	 */
	public int compare(Cat c1, Cat c2) {
		if(c1.name.equals(c2.name)) {
			if(c1.getAge() > c2.getAge()) return 1;
			else return -1;
		}
		else return c1.name.compareTo(c2.name);
	}

}