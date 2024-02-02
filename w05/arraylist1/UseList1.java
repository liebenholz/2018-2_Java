package w5.arraylist1;

/**
 * w5.arratlist1 ��Ű���� ArrayIntList �׽�Ʈ
 *
 */
public class UseList1 {

	public static void main(String[] args) {
		
		// ��ü ����
		ArrayIntList list = new ArrayIntList();
		
		// 10���� ���� add
		System.out.println("add(index, value)�� �̿��� �迭�� �� ä���.");
		for(int i = 0; i < 10; i++)
			list.add(i, 9 - i);
		System.out.println(list.toString());
		
		// ���� �߰��� add
		System.out.println("add(value)�� �̿��� ���� �ϳ��� �߰��Ѵ�.");
		list.add(22);
		System.out.println(list.toString());
		
		// �ε����� �ְ� �濡 �ִ� ���ڸ� get
		System.out.println("get(index) �׽�Ʈ");
		System.out.println(list.get(3));
		
		// �ش� index�� value�� ��ü 
		System.out.println("set(index, value)�� �̿��� 9�� �濡 11�� �ִ´�.");
		list.set(9, 11);
		System.out.println(list.toString());
		
		// size ���ϱ�
		System.out.println("size() �׽�Ʈ");
		System.out.println("���� �� = " + list.size());
		
		// �迭 �� value ����
		System.out.println("remove(index)�� �̿��Ͽ� ���Ҹ� ��� �����Ѵ�.");
		for(int i = list.size() - 1; i >= 0; i--)
			list.remove(i);
		System.out.println(list.toString());
		
		// �迭�� ����°�?
		System.out.println("isEmpty() �׽�Ʈ");
		System.out.println("��� �����Ǿ���? " + list.isEmpty());
		
	}
}
