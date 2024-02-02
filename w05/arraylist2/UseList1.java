package w5.arraylist2;

public class UseList1 {

	public static void main(String[] args) {
		
		ArrayIntList list = new ArrayIntList();
		
		System.out.println("add(index, value)를 이용해 배열을 꽉 채운다.");
		for(int i = 0; i < 10; i++)
			list.add(i, 9 - i);
		System.out.println(list.toString());
		
		System.out.println("add(value)를 이용해 원소 하나를 추가한다.");
		list.add(22);
		System.out.println(list.toString());
		
		System.out.println("set(index, value)를 이용해 9번 방에 11을 넣는다.");
		list.set(9, 11);
		System.out.println(list.toString());
		
		System.out.println("size() 테스트");
		System.out.println("원소 수 = " + list.size());
		
		System.out.println("remove(index)를 이용하여 원소를 모두 삭제한다.");
		for(int i = list.size() - 1; i >= 0; i--)
			list.remove(i);
		System.out.println(list.toString());
		
		System.out.println("isEmpty() 테스트");
		System.out.println("모두 삭제되었나? " + list.isEmpty());
		
	}
}
