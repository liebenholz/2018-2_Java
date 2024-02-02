package w6.dog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DogTest {
	
	public static void main(String[] args) {
		
		Dog dog = new Jindo("순둥이", "검정");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
//		dog.getAverageWeight();		// 컴파일 에러. Dog 타입은 getAveraeWeight 메소드를 지원하지 않는다. 
		Jindo jindo = (Jindo)dog;
		System.out.println("진돗개의 평균 무게 : " + jindo.getAverageWeight());

		dog = new Yorki("귀요미");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
		Yorki yorki = (Yorki)dog;
		System.out.println("요크셔테리어의 평균 무게 : " + yorki.getAverageWeight());
		
		System.out.println();
		
		// 1.5
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Jindo("순둥이", "검정"));
		dogs.add(new Jindo("막둥이", "하양"));
		dogs.add(new Yorki("귀요미"));
		dogs.add(new Yorki("딸랑이"));
		
		for (Dog d : dogs)
			System.out.println(d.toString() + " " + d.speak());
	
	}
}