package w6.sortedlist3;

public class SimpleTest {

	public static void main(String[] args) {

		System.out.println("1단계 구현 테스트 ========");
		Level1();
		System.out.println("2단계 구현 테스트 ========");
		Level2();
		
		System.out.println("3단계 구현 테스트 ========");
		System.out.println("중복금지 true의 용량 5인 SortedIntList");
		SortedIntList s = new SortedIntList(5);
		System.out.println(s);
		System.out.println("33, 12, -9, 1024, 1024, 1024 add");
		s.add(33); s.add(12); s.add(-9); 
		s.add(1024); s.add(1024); s.add(1024);
		System.out.println(s);
		//
		System.out.println("getUnique() 테스트");
		System.out.println("uniqueness : " + s.getUnique());
		//
		System.out.println("setUnique(true) 테스트");
		s.setUnique(true);
		System.out.println(s);
		//
		System.out.println("setUnique(false) 테스트");
		s.setUnique(false);
		System.out.println(s);
		//
		System.out.println("5, -9 add");
		s.add(5); s.add(-9);
		System.out.println(s);
		
	}

	public static void Level1() {
		System.out.println("네 개의 구성자 테스트 ---------------");
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
		
		System.out.println("초기 용량이 5인 SortedIntList");
		SortedIntList s = new SortedIntList(5);
		//
		System.out.println("add(value) 테스트 - 정렬, 용량 자동 증가 확인");
		s.add(33); s.add(12); s.add(-9); 
		s.add(1024); s.add(1024); s.add(1024);
		System.out.println(s);
		//
		System.out.println("add(index, value) 테스트");
		try { s.add(1, 512); }
		catch(UnsupportedOperationException e) {
			System.out.println(e);
		}
	
		System.out.println();
		// ------------------
		
		System.out.println("remove(index) 테스트 - 1번 방 삭제");
		s.remove(1);
		System.out.println(s);
		//
		System.out.println("indexOf(value) 테스트");
		System.out.println("33의 인덱스 : " + s.indexOf(33));
		//
		System.out.println("contains(value) 테스트");
		System.out.println("33을 포함하나? : " + s.contains(33));
		System.out.println("333을 포함하나? : " + s.contains(333));
		// 
		System.out.println("max() 테스트");
		System.out.println("최댓값 : " + s.max());
		System.out.println("min() 테스트");
		System.out.println("최솟값 : " + s.min());
		System.out.println();
	}
	
	public static void Level2() {
		System.out.println("중복금지 true의 용량 5인 SortedIntList");
		SortedIntList s = new SortedIntList(true, 5);
		System.out.println(s);
		//
		System.out.println("add(value) 테스트 - 정렬, 중복금지 확인");
		s.add(33); s.add(12); s.add(-9); 
		s.add(1024); s.add(1024); s.add(1024);
		System.out.println(s);
	}
}
