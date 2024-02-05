package w13.generics;

import java.util.LinkedList;
import java.util.List;

class ListReverser {
	public static void reverse(List<Number> list) {
		List<Number> listc = new LinkedList<>(list);
		list.clear();
		for (int i = listc.size() - 1; i >= 0 ; i--)
			list.add(listc.get(i));
	}
}
public class ListReverserTest {

	public static void main(String[] args) {

		List<Number> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-1);
		list.add(3);
		System.out.println(list);

		ListReverser.reverse(list);
		System.out.println(list);
		System.out.println();

		// LisrReverser.reverse 메소드를 이용하여
		// List<Double>의 원소 순서를 바꿀 수 있나?

		// Double은 Number에 포함되어있기 때문에 가능하다
	}

}
