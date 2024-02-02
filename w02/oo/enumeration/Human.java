package w2.tictactoe.oo.enumeration;

import java.util.Scanner;

/**
 * 게임에 참가하는 사람
 */
public class Human {

	/**
	 * 구성자
	 */
	private Board board;
	private Scanner scan = new Scanner(System.in);

	public Human(Board board) {
		this.board = board;
	}

	/**
	 * 적당한 위치를 선정하며 바둑한에 돌을 놓는다.
	 */
	public void play() {

		boolean success = false;
		int x, y;

		while(!success) {
			System.out.print("좌표를 입력하세요 : ");
			x = scan.nextInt();
			y = scan.nextInt();
			if (board.putStone(Seed.CROSS, x, y))
				success = true;
			else System.out.println("그곳에 놓을 수 없습니다.");
		}
	}
}
