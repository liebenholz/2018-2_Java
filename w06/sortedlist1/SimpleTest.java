package w6.sortedlist1;

public class SimpleTest {

	public static void main(String[] args) {

		System.out.println("�� ���� ������ �׽�Ʈ ---------------");
		SortedIntList sil1 = new SortedIntList();
		System.out.println(sil1);
		SortedIntList sil2 = new SortedIntList(true);
		System.out.println(sil2);
		
		try { SortedIntList sil3 = new SortedIntList(true, -1); }
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try { SortedIntList sil4 = new SortedIntList(-1); }
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		System.out.println();
		// ------------------
		
		System.out.println("�ʱ� �뷮�� 5�� SortedIntList");
		SortedIntList s = new SortedIntList(5);
		//
		System.out.println("add(value) �׽�Ʈ - ����, �뷮 �ڵ� ���� Ȯ��");
		s.add(33); s.add(12); s.add(-9); 
		s.add(1024); s.add(1024); s.add(1024);
		System.out.println(s);
		//
		System.out.println("add(index, value) �׽�Ʈ");
		try { s.add(1, 512); }
		catch(UnsupportedOperationException e) {
			System.out.println(e);
		}
	
		System.out.println();
		// ------------------
		
		System.out.println("remove(index) �׽�Ʈ - 1�� �� ����");
		s.remove(1);
		System.out.println(s);
		//
		System.out.println("indexOf(value) �׽�Ʈ");
		System.out.println("33�� �ε��� : " + s.indexOf(33));
		//
		System.out.println("contains(value) �׽�Ʈ");
		System.out.println("33�� �����ϳ�? : " + s.contains(33));
		System.out.println("333�� �����ϳ�? : " + s.contains(333));
		// 
		System.out.println("max() �׽�Ʈ");
		System.out.println("�ִ� : " + s.max());
		System.out.println("min() �׽�Ʈ");
		System.out.println("�ּڰ� : " + s.min());
		System.out.println();
		
	}


}
