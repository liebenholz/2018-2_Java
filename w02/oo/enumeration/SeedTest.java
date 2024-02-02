package w2.tictactoe.oo.enumeration;

/**
 * Enumeration�� �⺻Ÿ�԰� Ŭ�����ͷ� Ÿ������ ���ȴ�.
 * 
 * (��)
 * int i = 1;
 * String s = "���ڿ�";
 * Seed player = Seed.CROSS;
 * 
 */
public class SeedTest {

	public static void main(String[] args) {

		Seed player;
		
		player = Seed.CROSS;
		player = Seed.NOUGHT;
		// �� �� �� �ܿ��� � ���� �����ϴ��� �������� �� ��!
		
		play(player);	// NOUGHT�� ��µ�.
		
		// ��� �� 1
		if (player == Seed.NOUGHT) {
			System.out.println("yes");	// ��µ�
		}

		// ��� �� 2
		switch(player) {
		case CROSS :
			System.out.println("player == CROSS");
			break;
		case NOUGHT :
			System.out.println("player == NOUGHT");
			break;
		}
	}
	
	// �Ķ���� p�� Seed Ÿ��
	// p���� Seed.CROSS�� Seed.NOUGHT�� �� �� �ִ�.
	static void play(Seed p) {
		System.out.println(p);
	}

}
