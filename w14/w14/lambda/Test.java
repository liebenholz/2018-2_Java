package w14.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

	// 1번 방법.
	public static void printPersonsOlderThan(
			List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	// 2번 방법.
	public static void printPersonsWithinAgeRange(
			List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// 3번 방법
	public interface CheckPerson {
		boolean test(Person p);          // p가 조건에 부합하는지 검사한다.
	}

	public static void printPersons(
			List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// 6번. Predicate 인터페이스
	interface Predicate<Person> {
		boolean test(Person t);
	}

	public static void printPersonsWithPredicate(
			List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// 7번. Predicate & Consumer 인터페이스
	public static void processPersons(
			List<Person> roster,
			Predicate<Person> tester,
			Consumer<Person> consumer) {
		for (Person p : roster) {
			if (tester.test(p)) {
				consumer.accept(p);
			}
		}
	}

	// Predicate, Function & Consumer 인터페이스
	public static void processPersonsWithFunction(
			List<Person> roster,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> consumer) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				consumer.accept(data);
			}
		}
	}

	// 8번. 제네릭스 활용
	public static <X, Y> void processElements(
			Iterable<X> source,
			Predicate<X> tester,
			Function <X, Y> mapper,
			Consumer<Y> consumer) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				consumer.accept(data);
			}
		}
	}

	public static void main(String[] args) {

		List<Person> roster = Person.createRoster();

		System.out.println("모든 회원:");
		for (Person p : roster) {
			p.printPerson();
		}
		System.out.println();

		// 1번 방법.
		System.out.println("20살 이상인 회원:");
		printPersonsOlderThan(roster, 20);
		System.out.println();

		// 2번 방법.
		System.out.println("15세 이상이고 20세 미만인 회원: ");
		printPersonsWithinAgeRange(roster, 15, 20);
		System.out.println();

		// 3번 방법. (1)
		System.out.println("18세 이상이고 25세 이하인 남자 회원: ");
		class CheckPersonEligibleForSelectiveService 
		implements CheckPerson {
			public boolean test(Person p) {
				return p.gender == Person.Sex.MALE &&
						p.getAge() >= 18 &&
						p.getAge() <= 25;
			}
		}
		printPersons(roster, new CheckPersonEligibleForSelectiveService());
		System.out.println();

		// 3번 방법. (2)
		System.out.println("15세 이상이고 19세 이하인 여자 회원: ");
		class CheckPersonEligibleForSelectiveService2 
		implements CheckPerson {
			public boolean test(Person p) {
				return p.gender == Person.Sex.FEMALE &&
						p.getAge() >= 15 &&
						p.getAge() <= 19;
			}
		}
		printPersons(roster, new CheckPersonEligibleForSelectiveService2());
		System.out.println();

		// 4번 방법. (익명 메소드 사용)
		System.out.println("(익명 클래스 사용) 15세 이상이고 19세 이하인 여자 회원: ");
		printPersons(roster,new CheckPerson() {
			public boolean test(Person p) {    
				// Person p가 주어졌을 때 그 p가 조건을 만족하는지 여부를
				// true or false로 반환하는 메소드.
				return p.getGender() == Person.Sex.FEMALE
						&& p.getAge() >= 15
						&& p.getAge() <= 19;
			}
		}
				);
		System.out.println();

		// 5번 방법. (람다식)
		System.out.println("(람다식) 15세 이상이고 19세 이하인 여자 회원: ");
		printPersons(roster, 
				// 람다식
				(Person p) -> p.getGender() == Person.Sex.FEMALE 
				&& p.getAge() >= 15
				&& p.getAge() <= 19
				);
		System.out.println();

		// 6번 방법. (Predicate 인터페이스와 람다식)
		System.out.println("(Predicate 인터페이스와 람다식) "
				+ "15세 이상이고 19세 이하인 여자 회원: ");
		printPersonsWithPredicate(roster,
				// 파라미터 p의 타입을 선언하지 않아도 된다.
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19
				);
		System.out.println();

		// 7번 방법. (1. Predicate와 Consumer 인터페이스)
		System.out.println("(Predicate와 Consumer 인터페이스) "
				+ "15세 이상이고 19세 이하인 여자 회원: ");
		processPersons(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.printPerson()
				);
		System.out.println();

		// 7번 방법. (2. Predicate와 Function, Consumer 인터페이스)
		System.out.println("(Predicate와 Function, Consumer 인터페이스) "
				+ "15세 이상이고 19세 이하인 여자 회원: ");
		processPersonsWithFunction(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.getEmailAddress(),
				email -> System.out.println(email)
				);
		System.out.println();

		// 8번 방법. (제네릭스 사용)
		System.out.println("(제네릭스 사용) "
				+ "15세 이상이고 19세 이하인 여자 회원: ");
		processElements(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.getEmailAddress(),
				email -> System.out.println(email)
				);
		System.out.println();

		// 9번 방법. (스트림과 집합연산 사용)
		System.out.println("(스트림과 집합연산 사용) "
				+ "15세 이상이고 19세 이하인 여자 회원: ");
		roster
		.stream()
		.filter(
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15                         
				&& p.getAge() <= 19)
		.map(p -> p.getEmailAddress())
		.forEach(email -> System.out.println(email));
		System.out.println();
	}

}