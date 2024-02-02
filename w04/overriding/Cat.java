package w4.overriding;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Cat implements Comparable<Cat>{

	int age;
	String name;
	
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	/**
	 * 나이 순으로 정렬하는 compareTo 메소드
	 */
	public int compareTo(Cat other) {
		if (name != other.name) {
			if(age > other.age) return 1;
			else return -1;
		}
		else return 0;
	}
	
	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		
		Set<Cat> s = new HashSet<>();
		s.add(new Cat(1, "나비"));
		s.add(new Cat(2, "왕눈"));
		s.add(new Cat(1, "나비"));
		s.add(new Cat(5, "나비"));
		s.add(new Cat(4, "야옹"));
		s.add(new Cat(4, "실눈"));
		System.out.println(s);
		
		// 이름순으로 정렬, 이름이 같으면 나이 순으로
		SortedSet<Cat> ss = new TreeSet<>(new CatComparator());
		ss.addAll(s);
		System.out.println(ss);
		
		// 나이순으로 정렬
		ss = new TreeSet<>(s);
		System.out.println(ss);
	}
}
