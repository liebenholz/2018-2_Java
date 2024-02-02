package w2.tictactoe.oo.enumeration;

/**
 * Enumeration은 기본타입과 클래스터럼 타입으로 사용된다.
 * 
 * (예)
 * int i = 1;
 * String s = "문자열";
 * Seed player = Seed.CROSS;
 * 
 */
public class SeedTest {

	public static void main(String[] args) {

		Seed player;
		
		player = Seed.CROSS;
		player = Seed.NOUGHT;
		// 위 두 값 외에는 어떤 것을 대입하더라도 컴파일이 안 됨!
		
		play(player);	// NOUGHT가 출력됨.
		
		// 사용 예 1
		if (player == Seed.NOUGHT) {
			System.out.println("yes");	// 출력됨
		}

		// 사용 예 2
		switch(player) {
		case CROSS :
			System.out.println("player == CROSS");
			break;
		case NOUGHT :
			System.out.println("player == NOUGHT");
			break;
		}
	}
	
	// 파라미터 p는 Seed 타입
	// p에는 Seed.CROSS와 Seed.NOUGHT만 들어갈 수 있다.
	static void play(Seed p) {
		System.out.println(p);
	}

}
