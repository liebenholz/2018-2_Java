package w2.tictactoe.oo.enumeration;

import java.util.concurrent.TimeUnit;

public class Game {

	public static final int SIZE = 3;

	private GameState state;		// 현재 게임의 상태.

	private Board board;	// 바둑판
	private Human human;	// 사람
	private Computer computer;	// 컴퓨터

	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game();
		game.run();
	}

	/**
	 * 게임을 실행한다.
	 */
	private void run() throws InterruptedException {

		initGame();			// 게임을 초기화한다.
		board.print();		// 바둑판을 화면에 그린다.

		boolean end = false;

		while (!end) {
			// 사람의 차례.
			human.play();
			board.print();		 // 바둑판을 화면에 그린다.	
			state = board.checkState();
			if (state != GameState.PLAYING) {
				end = true;
				continue;
			}

			TimeUnit.SECONDS.sleep(1);  // 프로그램 실행을 1초 동안 멈춘다. InterruptedException을 던지는 수가 있다. ****

			// 컴퓨터의 차례.
			computer.play();
			board.print();		 // 바둑판을 화면에 그린다.	
			state = board.checkState();
			if (state != GameState.PLAYING) 
				end = true;
		}
		printResult();			// 누가 승리했는지, 혹은 무승부인지를 알려준다.
	}

	/**
	 * 게임을 초기화한다.
	 */
	private void initGame() {
		board = new Board(SIZE);
		human = new Human(board);
		computer = new Computer(board);

		System.out.println("Tic-Tac-Toe 게임입니다.");
		System.out.println("사람이 X, 컴퓨터가 O입니다.");
	}
	
	/**
	 * 게임의 결과를 출력한다.
	 */
	private void printResult() {
		switch (state) {
		case CROSS_WON :
			System.out.println("당신이 이겼습니다. 축하합니다");
			break;
		case NOUGHT_WON :
			System.out.println("당신이 졌습니다. 다시 도전하세요.");
			break;
		case DRAW :
			System.out.println("비겼습니다. 막상막하군요.");
		}
	}
}
