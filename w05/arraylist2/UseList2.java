package w5.arraylist2;

/**
 * w5.arratlist2 패키지의 ArrayIntList 테스트
 *
 */
public class UseList2 {

	public static void main(String[] args) {

		ArrayIntList list;
		
		try {
			list = new ArrayIntList(-1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		list = new ArrayIntList();
		
		// add
		list.add(12);
		list.add(-9);
		list.add(33);
		list.add(1024);
		System.out.println(list);
		
		// 해당 index에 value add
		list.add(0, 121);
		list.add(3, 444);
		System.out.println(list);
		
		// get
		System.out.println(list.get(3));
		
		// indexOf
		list.add(0, 18);
		System.out.println("18의 인덱스(indexOf): " + list.indexOf(18));
		System.out.println("28의 인덱스(indexOf): " + list.indexOf(28));
		
		// contains
		System.out.println("18을 포함하는가?(contains) " + list.contains(18));
		System.out.println("28을 포함하는가?(contains) " + list.contains(28));
		
		list.remove(1);
		System.out.println(list);
		System.out.println();
		
		// ArrayIndexOutOfBoundsException -- checkIndex
		try { list.add(-1, 100); }
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try { list.add(6, 100); }
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try { list.get(7); }
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try { list.remove(8); }
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try { list.set(9,190000); }
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

}
