package w2.tictactoe.oo.enumeration;

/**
 * 바둑판.
 */
public class Board {

	private char[][] grid;	// 돌을 놓는 판.

	private Seed currentPlayer;
	private int x, y;

	/**
	 * 구성자.
	 * 배열을 만들고 공백문자로 채운다.
	 * @param size 바둑판 크기.
	 */

	public Board(int size) {
		// 배열을 만든다.
		grid = new char[size][size];
		// 배열을 공백문자로 채운다.
		for(int i = 0; i < size; i++)
			for(int j = 0; j <size; j++)
				grid[i][j] = ' ';
	}

	/**
	 * 주어진 위치에 주어진 선수의 돌을 돟는다.
	 * 주어진 위치가 유효한 경우에만 돌을 놓는다.
	 * 주어진 위치가 유효해서 돌을 제대로 놓았으면 true,
	 * 주어진 위치가 유효하지 않아 돌을 놓지 못했다면 false를 반환한다.
	 * @param player 선수('X' 또는 'O')
	 * @param x 돌을 놓는 x좌표
	 * @param y 돌을 놓는 y좌표
	 * @return 제대로 돌을 놓았다면 true, 그렇지 않다면 false.
	 */
	public boolean putStone(Seed player, int x, int y) {
		// 누가 돌을 놓았는지 기억해준다.
		currentPlayer = player;

		// 돌의 위치를 기억해준다. 
		// 객체 내의 필드를 의미하며, this를 빼면 지역변수 x, y가 입력된다.
		this.x = x;
		this.y = y;

		boolean success = false;	// 우선 실패한 상태라고 하자.
		if (inputValid()) {
			switch (player) {
			case CROSS :
				grid[x][y] = 'X';
				break;
			case NOUGHT :
				grid[x][y] = 'O';
			}
			success = true;
		}
		return success;
	}

	/**
	 * 게임의 상태를 확인한다.
	 * @return 게임의 상태.
	 */
	public GameState checkState() {
		GameState state = GameState.PLAYING;		// 우선 "게임 중"이라고 하다
		if (won(currentPlayer)) {		// 방금 돌을 놓은 선수가 이긴 경우
			switch (currentPlayer) {
			case CROSS :
				state = GameState.CROSS_WON;
				break;
			case NOUGHT :
				state = GameState.NOUGHT_WON;
			}	
		}
		else if (boardFull())		// 방금 돌을 놓았으나 이기지 않은 경우
			state = GameState.DRAW;		// 비김
		return state;				// 게임의 상황을 반환한다.
	}

	/**
	 * 바둑판의 크기를 반환한다.
	 * @return 바둑판 크기.
	 */
	public int getsize() {
		return grid.length;
	}

	/*
	 * (x, y)에 돌을 놓을 수 있는지 판별한다.
	 * @return 좌표가 유효하면 true, 그렇지 않으면 false를 반환한다.
	 */
	private boolean inputValid() {

		int size = getsize();
		boolean valid = true;

		if (x < 0 || x > size-1 || y < 0 || y > size-1)
			valid = false;
		else if (grid[x][y] != ' ')
			valid = false;
		return valid;
	}

	/*
	 * 한 쪽이 이겼는지 검사한다.
	 * @param player 최근돌을 놓은 선수.
	 * @return 한 쪽이 이겼으면 true, 그렇지 않으면 false.
	 */
	private boolean won(Seed player) {

		char currentMark = grid[x][y]; 	//최근에 놓은 돌의 모양.
		boolean won = false;
		int size = getsize();
		int i = 0, j = 0;
		int count;

		// 세로 승리 여부
		for (i = 0; i < size; i++) {
			count = 0;
			for (j = 0; j < size; j++) {
				if (grid[i][j] == currentMark)
					count++;
			}
			if (count == size)
				won = true;
		}
		// 가로 승리 여부
		for (i = 0; i < size; i++) {
			count = 0;
			for (j = 0; j < size; j++) {
				if (grid[j][i] == currentMark)
					count++;
			}
			if (count == size)
				won = true;
		}

		// 대각선 승리 여부
		count = 0;
		if (x==y) {
			for (i = 0; i < size; i++) {
				if (grid[i][i] == currentMark)
					count++;
				if (count == size)
					won = true;
			}
		}

		// 역대각선 승리 여부
		count = 0;
		if (x + y == size - 1) {
			for (i = 0; i < size; i++) {
				if (grid[i][size - i - 1] == currentMark)
					count++;
				if (count == size)
					won = true;
			}
		}
		return won;
	}

	/**
	 * 바둑판이 꽉 찼는가?
	 * @return 꽉 찼다면 true, 그렇지 않으면 false.
	 */
	private boolean boardFull() {

		int size = getsize();
		boolean full = true;

		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (grid[i][j] == ' ')
					full = false;
		return full;
	}

	/**
	 * 바둑판과 돌을 화면에 그린다.
	 */
	public void print() {

		int size = getsize();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print("  ");
				System.out.print(grid[i][j]);
				if (j != size-1)
					System.out.print("|");
			}
			System.out.println();
			if (i != size-1) {
				for (int k = 0; k < size-1; k++)
					System.out.print("---|");
				System.out.println("---");
			}
		}
	}
}
