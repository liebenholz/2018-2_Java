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

		// Set은 순서 개념이 없기 때문에 다양한 형식으로 출력될 수 있다.
		// HashSet의 원소들을 Hashcode를 계산하여 값의 동일 여부를 확인하기 때문에
		// hashcode가 같지 않으면 무조건 두 객체는 같지 않은 것이다.
		// 첫번째와 세번째 고양이는 hashcode가 다르기 때문에 같은 것으로 생각하지 않는다.

		Set<Cat> s = new HashSet<>();
		s.add(new Cat(1, "나비"));
		s.add(new Cat(2, "왕눈"));
		s.add(new Cat(1, "나비"));
		System.out.println(s);
	}
}
