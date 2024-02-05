package w13.generics.comparator;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

	// ����� �̸��� ���̸� ���ʷ� ���Ѵ�.
	@Override
	public int compare(Human h1, Human h2) {
		if(h1.name.equals(h2.name)) {
			if(h1.num > h2.num) return 1;
			else if(h1.num < h2.num) return -1;
			else return 0;
		}
		return h1.name.compareTo(h2.name);
	}
	
}


