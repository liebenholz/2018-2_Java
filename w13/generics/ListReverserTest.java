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

		// LisrReverser.reverse �޼ҵ带 �̿��Ͽ�
		// List<Double>�� ���� ������ �ٲ� �� �ֳ�?

		// Double�� Number�� ���ԵǾ��ֱ� ������ �����ϴ�
	}

}
