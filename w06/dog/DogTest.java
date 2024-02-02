package w6.dog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DogTest {
	
	public static void main(String[] args) {
		
		Dog dog = new Jindo("������", "����");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
//		dog.getAverageWeight();		// ������ ����. Dog Ÿ���� getAveraeWeight �޼ҵ带 �������� �ʴ´�. 
		Jindo jindo = (Jindo)dog;
		System.out.println("�������� ��� ���� : " + jindo.getAverageWeight());

		dog = new Yorki("�Ϳ��");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
		Yorki yorki = (Yorki)dog;
		System.out.println("��ũ���׸����� ��� ���� : " + yorki.getAverageWeight());
		
		System.out.println();
		
		// 1.5
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Jindo("������", "����"));
		dogs.add(new Jindo("������", "�Ͼ�"));
		dogs.add(new Yorki("�Ϳ��"));
		dogs.add(new Yorki("������"));
		
		for (Dog d : dogs)
			System.out.println(d.toString() + " " + d.speak());
	
	}
}