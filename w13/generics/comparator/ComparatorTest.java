package w13.generics.comparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("������", 60, 2018001));
		studentList.add(new Student("������", 30, 2018004));
		studentList.add(new Student("������", 30, 2018002));
		studentList.add(new Student("������", 35, 2018003));
		System.out.println(studentList);

		// HumanComparator�� �̿��Ͽ� studentList�� �����Ѵ�.
		studentList.sort(new HumanComparator());
		System.out.println("HumanComparator ��� : " 
				+ studentList);

		// StudentComparator�� �̿��Ͽ� studentList�� �����Ѵ�.
		studentList.sort(new StudentComparator());
		System.out.println("StudentComparator ��� : " 
				+ studentList);
	}

}
