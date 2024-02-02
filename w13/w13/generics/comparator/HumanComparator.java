package w13.generics.comparator;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

	// 사람의 이름과 나이를 차례로 비교한다.
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


