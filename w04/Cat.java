package w4;

import java.util.HashSet;
import java.util.Set;

public class Cat {

	int age;
	String name;

	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {

		// Set�� ���� ������ ���� ������ �پ��� �������� ��µ� �� �ִ�.
		// HashSet�� ���ҵ��� Hashcode�� ����Ͽ� ���� ���� ���θ� Ȯ���ϱ� ������
		// hashcode�� ���� ������ ������ �� ��ü�� ���� ���� ���̴�.
		// ù��°�� ����° ����̴� hashcode�� �ٸ��� ������ ���� ������ �������� �ʴ´�.

		Set<Cat> s = new HashSet<>();
		s.add(new Cat(1, "����"));
		s.add(new Cat(2, "�մ�"));
		s.add(new Cat(1, "����"));
		System.out.println(s);
	}
}
