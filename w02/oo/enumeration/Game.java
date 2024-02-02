package w2.tictactoe.oo.enumeration;

import java.util.concurrent.TimeUnit;

public class Game {

	public static final int SIZE = 3;

	private GameState state;		// ���� ������ ����.

	private Board board;	// �ٵ���
	private Human human;	// ���
	private Computer computer;	// ��ǻ��

	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		game.run();
	}

	/**
	 * ������ �����Ѵ�.
	 */
	private void run() throws InterruptedException {

		initGame();			// ������ �ʱ�ȭ�Ѵ�.
		board.print();		// �ٵ����� ȭ�鿡 �׸���.

		boolean end = false;

		while (!end) {
			// ����� ����.
			human.play();
			board.print();		 // �ٵ����� ȭ�鿡 �׸���.	
			state = board.checkState();
			if (state != GameState.PLAYING) {
				end = true;
				continue;
			}

			TimeUnit.SECONDS.sleep(1);  // ���α׷� ������ 1�� ���� �����. InterruptedException�� ������ ���� �ִ�. ****

			// ��ǻ���� ����.
			computer.play();
			board.print();		 // �ٵ����� ȭ�鿡 �׸���.	
			state = board.checkState();
			if (state != GameState.PLAYING) 
				end = true;
		}
		printResult();			// ���� �¸��ߴ���, Ȥ�� ���º������� �˷��ش�.
	}

	/**
	 * ������ �ʱ�ȭ�Ѵ�.
	 */
	private void initGame() {
		board = new Board(SIZE);
		human = new Human(board);
		computer = new Computer(board);

		System.out.println("Tic-Tac-Toe �����Դϴ�.");
		System.out.println("����� X, ��ǻ�Ͱ� O�Դϴ�.");
	}
	
	/**
	 * ������ ����� ����Ѵ�.
	 */
	private void printResult() {
		switch (state) {
		case CROSS_WON :
			System.out.println("����� �̰���ϴ�. �����մϴ�");
			break;
		case NOUGHT_WON :
			System.out.println("����� �����ϴ�. �ٽ� �����ϼ���.");
			break;
		case DRAW :
			System.out.println("�����ϴ�. �����ϱ���.");
		}
	}
}
