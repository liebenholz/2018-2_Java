package w13.generics.comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	// HumanComparator를 이용하여 학생을 사람으로서 먼저 비교한다.
	// 즉, 이름과 나이를 차례로 비교한다.
	// 만약 이름과 나이가 같다면 학번을 비교한다.
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.name.equals(o2.name)) {
			if(o1.num > o2.num) return 1;
			else if(o1.num < o2.num) return -1;
			else {
				if(o1.studentNum > o2.studentNum) return 1;
				else if(o1.studentNum < o2.studentNum) return -1;
				else return 0;
			}
			
		}
		return o1.name.compareTo(o2.name);
	}
}
