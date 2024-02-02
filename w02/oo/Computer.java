package w2.tictactoe.oo;

import java.util.Random;

/**
 * ���ӿ� �����ϴ� ��ǻ��.
 * ����� ����Ѵ�.
 */
public class Computer {

	// Board �ν��Ͻ��� ī��Ű�� ���� �������� (�ʵ�).
	private Board board;

	public Computer(Board board) {
		this.board = board;
	}

	/**
	 * ������ ��ġ�� �����ϸ� �ٵ��ѿ� ���� ���´�.
	 * �Էµ� ��ġ�� ��ȿ���� ������ ���ο� ��ġ�� �����Ͽ� �ٽ� ���� ���´�.
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
