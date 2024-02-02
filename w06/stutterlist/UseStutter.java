package w6.stutterlist;

public class UseStutter {
	
	public static void main(String[] args) {
		
		// ���Ҹ� add�ϸ� �� ���Ұ� �� �� add�Ǵ� StutterIntList�� �����Ѵ�.
		// �ߺ����� 3�� StutterIntList!
		StutterIntList list = new StutterIntList(3);

		list.add(7);     
		System.out.println(list); // [7, 7, 7]
		
		list.add(-1);    // �� �ڿ� �߰��Ѵ�.
		System.out.println(list);	// [7, 7, 7, -1, -1, -1]
		
		list.add(2, 5);  // 2�� �濡 5�� �����ϵ� �� �� �����Ѵ�.
		System.out.println(list);	// [7, 7, 5, 5, 5, 7, -1, -1, -1]

		list.add(3);  
		System.out.println(list);	// [7, 7, 5, 5, 5, 7, -1, -1, -1, 3, 3, 3]

		list.remove(4);  // remove�� ���� �� ���� remove�Ѵ�. (4�� �濡 �ִ� ��!)
		System.out.println(list);	// [7, 7, 5, 5, 7, -1, -1, -1, 3, 3, 3]

		// �� StutterIntList�� �ߺ��� (stretch factor) --> 3
		System.out.println("Stretch factor = " + list.getStretch());   
		System.out.println();

		// �� StutterIntList�� 5�� �� ���� ��� �ֳ�?
		System.out.println("5�� " + list.count(5) + "�� ��� �ִ�.");   
		System.out.println();
		
		list.add(5);  
		System.out.println("5�� " + list.count(5) + "�� ��� �ִ�.");   

		// ������ ���� �� �� ���̳� ��� �ֳ�?
		System.out.println(list.counts());
		
		list = new StutterIntList(0);	// �ߺ����� 0�̹Ƿ� 
		list.add(7);     				// 7�� 0�� add�ȴ�!
		System.out.println(list);	// []
		System.out.println();
		
//		// ���� �ߺ����� ������ �ʴ´�.
//		list = new StutterIntList(-1);	// Exception �߻�!
	}
}
