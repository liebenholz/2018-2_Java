package w2.tictactoe.oo.enumeration;

import java.util.Scanner;

/**
 * ���ӿ� �����ϴ� ���
 */
public class Human {

	/**
	 * ������
	 */
	private Board board;
	private Scanner scan = new Scanner(System.in);

	public Human(Board board) {
		this.board = board;
	}

	/**
	 * ������ ��ġ�� �����ϸ� �ٵ��ѿ� ���� ���´�.
	 */
	public void play() {

		boolean success = false;
		int x, y;

		while(!success) {
			System.out.print("��ǥ�� �Է��ϼ��� : ");
			x = scan.nextInt();
			y = scan.nextInt();
			if (board.putStone(Seed.CROSS, x, y))
				success = true;
			else System.out.println("�װ��� ���� �� �����ϴ�.");
		}
	}
}
