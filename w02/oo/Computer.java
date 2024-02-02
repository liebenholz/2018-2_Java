package w2.tictactoe.oo;

import java.util.Random;

/**
 * 거임에 참가하는 컴퓨터.
 * 사람을 상대한다.
 */
public class Computer {

	// Board 인스턴스를 카리키기 위한 참조변수 (필드).
	private Board board;

	public Computer(Board board) {
		this.board = board;
	}

	/**
	 * 적당한 위치를 선정하며 바둑한에 돌을 놓는다.
	 * 입력된 위치가 유효하지 않으면 새로운 위치를 선정하여 다시 돌을 놓는다.
	 */
	public void play() {
		int x, y;
		Random r = new Random();
		do {
			x = r.nextInt(board.getsize());
			y = r.nextInt(board.getsize());
		} while(!board.putStone('O', x, y));
	}
}
