package w13.generics;

import java.util.LinkedList;
import java.util.List;

class GenericReverser {
	public static <E> void reverse(List<E> list) {
		List<E> listc = new LinkedList<>(list);
		list.clear();
		for (int i = listc.size() - 1; i >= 0 ; i--)
			list.add(listc.get(i));
	}
}
public class GenericReverserTest {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-1);
		list.add(3);
		System.out.println(list);

		GenericReverser.reverse(list);
		System.out.println(list);
		System.out.println();
		
		List<Double> listd = new LinkedList<>();
		listd.add(1.1);
		listd.add(2.2);
		listd.add(3.3);
		listd.add(-1.1);
		listd.add(3.3);
		System.out.println(listd);
		
		GenericReverser.reverse(listd);
		System.out.println(listd);
		System.out.println();
		
	}

}
