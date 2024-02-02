package w13.generics.comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	// HumanComparator�� �̿��Ͽ� �л��� ������μ� ���� ���Ѵ�.
	// ��, �̸��� ���̸� ���ʷ� ���Ѵ�.
	// ���� �̸��� ���̰� ���ٸ� �й��� ���Ѵ�.
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
