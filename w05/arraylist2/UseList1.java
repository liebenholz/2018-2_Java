package w5.arraylist2;

public class UseList1 {

	public static void main(String[] args) {
		
		ArrayIntList list = new ArrayIntList();
		
		System.out.println("add(index, value)�� �̿��� �迭�� �� ä���.");
		for(int i = 0; i < 10; i++)
			list.add(i, 9 - i);
		System.out.println(list.toString());
		
		System.out.println("add(value)�� �̿��� ���� �ϳ��� �߰��Ѵ�.");
		list.add(22);
		System.out.println(list.toString());
		
		System.out.println("set(index, value)�� �̿��� 9�� �濡 11�� �ִ´�.");
		list.set(9, 11);
		System.out.println(list.toString());
		
		System.out.println("size() �׽�Ʈ");
		System.out.println("���� �� = " + list.size());
		
		System.out.println("remove(index)�� �̿��Ͽ� ���Ҹ� ��� �����Ѵ�.");
		for(int i = list.size() - 1; i >= 0; i--)
			list.remove(i);
		System.out.println(list.toString());
		
		System.out.println("isEmpty() �׽�Ʈ");
		System.out.println("��� �����Ǿ���? " + list.isEmpty());
		
	}
}
