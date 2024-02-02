package w13.generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class ReplaceAllDemo {

	public static void main(String[] args) {

		List<Object> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-1);
		list.add(3);
		System.out.println("List<Integer> : " + list);
		
		System.out.println("��� 3�� 30���� ��ü");
		Collections.replaceAll(list, 3, 30);
		System.out.println(list);
		System.out.println();
		
		list.removeAll(list);
		list.add(1.0);
		list.add(2.0);
		list.add(3.0);
		list.add(-1.0);
		list.add(3.0);
		System.out.println("List<Float> : " + list);
		
		System.out.println("��� 3.0�� 30.0���� ��ü");
		Collections.replaceAll(list, 3.0, 30.0);
		System.out.println(list);
		System.out.println();
		
		list.removeAll(list);
		list.add("��");
		list.add("����");
		list.add("����");
		list.add("�ܿ�");
		list.add("��");
		list.add("��");
		System.out.println("List<String> : " + list);
		
		System.out.println("��� \"��\"�� \"����\"���� ��ü");
		Collections.replaceAll(list, "��", "����");
		System.out.println(list);
		System.out.println();

	}
}
