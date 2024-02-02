package w2.tictactoe.oo.enumeration;

/**
 * �ٵ���.
 */
public class Board {

	private char[][] grid;	// ���� ���� ��.

	private Seed currentPlayer;
	private int x, y;

	/**
	 * ������.
	 * �迭�� ����� ���鹮�ڷ� ä���.
	 * @param size �ٵ��� ũ��.
	 */

	public Board(int size) {
		// �迭�� �����.
		grid = new char[size][size];
		// �迭�� ���鹮�ڷ� ä���.
		for(int i = 0; i < size; i++)
			for(int j = 0; j <size; j++)
				grid[i][j] = ' ';
	}

	/**
	 * �־��� ��ġ�� �־��� ������ ���� ���´�.
	 * �־��� ��ġ�� ��ȿ�� ��쿡�� ���� ���´�.
	 * �־��� ��ġ�� ��ȿ�ؼ� ���� ����� �������� true,
	 * �־��� ��ġ�� ��ȿ���� �ʾ� ���� ���� ���ߴٸ� false�� ��ȯ�Ѵ�.
	 * @param player ����('X' �Ǵ� 'O')
	 * @param x ���� ���� x��ǥ
	 * @param y ���� ���� y��ǥ
	 * @return ����� ���� ���Ҵٸ� true, �׷��� �ʴٸ� false.
	 */
	public boolean putStone(Seed player, int x, int y) {
		// ���� ���� ���Ҵ��� ������ش�.
		currentPlayer = player;

		// ���� ��ġ�� ������ش�. 
		// ��ü ���� �ʵ带 �ǹ��ϸ�, this�� ���� �������� x, y�� �Էµȴ�.
		this.x = x;
		this.y = y;

		boolean success = false;	// �켱 ������ ���¶�� ����.
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
	 * ������ ���¸� Ȯ���Ѵ�.
	 * @return ������ ����.
	 */
	public GameState checkState() {
		GameState state = GameState.PLAYING;		// �켱 "���� ��"�̶�� �ϴ�
		if (won(currentPlayer)) {		// ��� ���� ���� ������ �̱� ���
			switch (currentPlayer) {
			case CROSS :
				state = GameState.CROSS_WON;
				break;
			case NOUGHT :
				state = GameState.NOUGHT_WON;
			}	
		}
		else if (boardFull())		// ��� ���� �������� �̱��� ���� ���
			state = GameState.DRAW;		// ���
		return state;				// ������ ��Ȳ�� ��ȯ�Ѵ�.
	}

	/**
	 * �ٵ����� ũ�⸦ ��ȯ�Ѵ�.
	 * @return �ٵ��� ũ��.
	 */
	public int getsize() {
		return grid.length;
	}

	/*
	 * (x, y)�� ���� ���� �� �ִ��� �Ǻ��Ѵ�.
	 * @return ��ǥ�� ��ȿ�ϸ� true, �׷��� ������ false�� ��ȯ�Ѵ�.
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
	 * �� ���� �̰���� �˻��Ѵ�.
	 * @param player �ֱٵ��� ���� ����.
	 * @return �� ���� �̰����� true, �׷��� ������ false.
	 */
	private boolean won(Seed player) {

		char currentMark = grid[x][y]; 	//�ֱٿ� ���� ���� ���.
		boolean won = false;
		int size = getsize();
		int i = 0, j = 0;
		int count;

		// ���� �¸� ����
		for (i = 0; i < size; i++) {
			count = 0;
			for (j = 0; j < size; j++) {
				if (grid[i][j] == currentMark)
					count++;
			}
			if (count == size)
				won = true;
		}
		// ���� �¸� ����
		for (i = 0; i < size; i++) {
			count = 0;
			for (j = 0; j < size; j++) {
				if (grid[j][i] == currentMark)
					count++;
			}
			if (count == size)
				won = true;
		}

		// �밢�� �¸� ����
		count = 0;
		if (x==y) {
			for (i = 0; i < size; i++) {
				if (grid[i][i] == currentMark)
					count++;
				if (count == size)
					won = true;
			}
		}

		// ���밢�� �¸� ����
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
	 * �ٵ����� �� á�°�?
	 * @return �� á�ٸ� true, �׷��� ������ false.
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
	 * �ٵ��ǰ� ���� ȭ�鿡 �׸���.
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
