package w14.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

	// 1�� ���.
	public static void printPersonsOlderThan(
			List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	// 2�� ���.
	public static void printPersonsWithinAgeRange(
			List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// 3�� ���
	public interface CheckPerson {
		boolean test(Person p);          // p�� ���ǿ� �����ϴ��� �˻��Ѵ�.
	}

	public static void printPersons(
			List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// 6��. Predicate �������̽�
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

	// 7��. Predicate & Consumer �������̽�
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

	// Predicate, Function & Consumer �������̽�
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

	// 8��. ���׸��� Ȱ��
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

		System.out.println("��� ȸ��:");
		for (Person p : roster) {
			p.printPerson();
		}
		System.out.println();

		// 1�� ���.
		System.out.println("20�� �̻��� ȸ��:");
		printPersonsOlderThan(roster, 20);
		System.out.println();

		// 2�� ���.
		System.out.println("15�� �̻��̰� 20�� �̸��� ȸ��: ");
		printPersonsWithinAgeRange(roster, 15, 20);
		System.out.println();

		// 3�� ���. (1)
		System.out.println("18�� �̻��̰� 25�� ������ ���� ȸ��: ");
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

		// 3�� ���. (2)
		System.out.println("15�� �̻��̰� 19�� ������ ���� ȸ��: ");
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

		// 4�� ���. (�͸� �޼ҵ� ���)
		System.out.println("(�͸� Ŭ���� ���) 15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		printPersons(roster,new CheckPerson() {
			public boolean test(Person p) {    
				// Person p�� �־����� �� �� p�� ������ �����ϴ��� ���θ�
				// true or false�� ��ȯ�ϴ� �޼ҵ�.
				return p.getGender() == Person.Sex.FEMALE
						&& p.getAge() >= 15
						&& p.getAge() <= 19;
			}
		}
				);
		System.out.println();

		// 5�� ���. (���ٽ�)
		System.out.println("(���ٽ�) 15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		printPersons(roster, 
				// ���ٽ�
				(Person p) -> p.getGender() == Person.Sex.FEMALE 
				&& p.getAge() >= 15
				&& p.getAge() <= 19
				);
		System.out.println();

		// 6�� ���. (Predicate �������̽��� ���ٽ�)
		System.out.println("(Predicate �������̽��� ���ٽ�) "
				+ "15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		printPersonsWithPredicate(roster,
				// �Ķ���� p�� Ÿ���� �������� �ʾƵ� �ȴ�.
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19
				);
		System.out.println();

		// 7�� ���. (1. Predicate�� Consumer �������̽�)
		System.out.println("(Predicate�� Consumer �������̽�) "
				+ "15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		processPersons(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.printPerson()
				);
		System.out.println();

		// 7�� ���. (2. Predicate�� Function, Consumer �������̽�)
		System.out.println("(Predicate�� Function, Consumer �������̽�) "
				+ "15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		processPersonsWithFunction(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.getEmailAddress(),
				email -> System.out.println(email)
				);
		System.out.println();

		// 8�� ���. (���׸��� ���)
		System.out.println("(���׸��� ���) "
				+ "15�� �̻��̰� 19�� ������ ���� ȸ��: ");
		processElements(roster,
				p -> p.getGender() == Person.Sex.FEMALE
				&& p.getAge() >= 15
				&& p.getAge() <= 19,
				p -> p.getEmailAddress(),
				email -> System.out.println(email)
				);
		System.out.println();

		// 9�� ���. (��Ʈ���� ���տ��� ���)
		System.out.println("(��Ʈ���� ���տ��� ���) "
				+ "15�� �̻��̰� 19�� ������ ���� ȸ��: ");
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