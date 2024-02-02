package w1_2277;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/** 
 * ��������(global variable)�� ����Ͽ� �Լ��� �ܼ�ȭ.
 */
public class TicTacToe5 {

	// ���� ���¸� ��Ÿ���� ��� 
	static final int PLAYING = 0;		// ���� ������.
	static final int DRAW = 1;		// ���.
	static final int CROSS_WON = 2;		// X ���� ��. 
	static final int NOUGHT_WON = 3;	// O ���� ��.

	static final int SIZE = 5;
	static char[][] board = new char[SIZE][SIZE];
	static Scanner scan = new Scanner(System.in);

	static char currentMark;
	static int x, y;
	static int state;

	public static void main(String[] args) throws InterruptedException {

		initGame();			// ������ �ʱ�ȭ�Ѵ�.
		printBoard();		// �ٵ����� ȭ�鿡 �׸���.

		boolean end = false;

		while (!end) {
			// ����� ����.
			humanPlay();
			printBoard();		 // �ٵ����� ȭ�鿡 �׸���.	
			checkGame();
			if (state != PLAYING) {
				end = true;
				continue;
			}

			TimeUnit.SECONDS.sleep(1);  // ���α׷� ������ 1�� ���� �����. InterruptedException�� ������ ���� �ִ�. ****
			
			// ��ǻ���� ����.
			computerPlay();
			printBoard();		 // �ٵ����� ȭ�鿡 �׸���.	
			checkGame();
			if (state != PLAYING) 
				end = true;
		}
		printResult();			// ���� �¸��ߴ���, Ȥ�� ���º������� �˷��ش�.
		scan.close();
	}

	/**
	 * ���� �ٵ����� ���¸� ȭ�鿡 ����Ѵ�.
	 * �Էµ� SIZE ũ���� �ٵ����� �׸���.
	 */
	static void printBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print("  ");
				System.out.print(board[i][j]);
				if (j != SIZE-1)
					System.out.print("|");
			}
			System.out.println();
			if (i != SIZE-1) {
				for (int k = 0; k < SIZE-1; k++)
					System.out.print("---|");
				System.out.println("---");
			}
		}
	}

	/**
	 * (x, y)�� ���� ���� �� �ִ��� �Ǻ��Ѵ�.
	 * @return ��ǥ�� ��ȿ�ϸ� true, �׷��� ������ false�� ��ȯ�Ѵ�.
	 */
	static boolean inputValid() {
		boolean valid = true;
		if (x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1)
			valid = false;
		else if (board[x][y] != ' ')
			valid = false;
		return valid;
	}

	/**
	 * ������κ��� �Է��� �޾� �ٵ��ǿ� ���´�
	 */
	static void humanPlay() {
		currentMark = 'X';
		System.out.print("���� ���� ��ǥ�� �Է��Ͻÿ�: ");
		x = scan.nextInt();
		y = scan.nextInt();

		while(!inputValid()) {	// �Է��� �ùٸ��� ���� ���
			System.out.print("�ùٸ� ��ġ�� �ƴմϴ�. �ٽ� �Է��Ͻÿ�: ");
			x = scan.nextInt();
			y = scan.nextInt();
		}
		board[x][y] = 'X';
	}

	/**
	 * ��ǻ�Ͱ� ���� ���´�.
	 */
	static void computerPlay() {
		Random r = new Random();
		do {				// ��ȿ�� ���ڰ� ��Ÿ�� ������ �������� ��ġ�� �����Ѵ�. 
			x = r.nextInt(SIZE);
			y = r.nextInt(SIZE);
		} while (!inputValid());
		board[x][y] = 'O';
	}

	/**
	 * ������ ���¸� üũ�Ѵ�.
	 */
	static void checkGame() {
		char currentMark = board[x][y]; 	//�ֱٿ� ���� ���� ���.
		boolean won = false;
		int i = 0, j = 0;
		int count;
		
		// ���� �¸� ����
		for (i = 0; i < SIZE; i++) {
			count = 0;
			for (j = 0; j < SIZE; j++) {
				if (board[i][j] == currentMark)
					count++;
			}
			if (count == SIZE)
				won = true;
		}
		// ���� �¸� ����
		for (i = 0; i < SIZE; i++) {
			count = 0;
			for (j = 0; j < SIZE; j++) {
				if (board[j][i] == currentMark)
					count++;
			}
			if (count == SIZE)
				won = true;
		}
		
		// �밢�� �¸� ����
		count = 0;
		if (x==y) {
			for (i = 0; i < SIZE; i++) {
				if (board[i][i] == currentMark)
					count++;
				if (count == SIZE)
					won = true;
			}
		}
		
		// ���밢�� �¸� ����
		count = 0;
		if (x + y == SIZE - 1) {
			for (i = 0; i < SIZE; i++) {
				if (board[i][SIZE - i - 1] == currentMark)
					count++;
				if (count == SIZE)
					won = true;
			}
		}
		/*
		if (board[x][0] == currentMark && board[x][1] == currentMark && board[x][2] == currentMark)
			won = true;
		if (board[0][y] == currentMark && board[1][y] == currentMark && board[2][y] == currentMark)
			won = true;
		if (x == y)
			if (board[0][0] == currentMark && board[1][1] == currentMark && board[2][2] == currentMark)
				won = true;
		if (x + y == SIZE-1)
			if (board[0][2] == currentMark && board[1][1] == currentMark && board[2][0] == currentMark)
				won = true;
		*/
		if (won) state = (currentMark == 'X') ? CROSS_WON : NOUGHT_WON; // �ºΰ� ����
		else if (boardFull()) state = DRAW;		// ���
		else state = PLAYING;	// ���� ������
	}

	/**
	 * �ٵ����� �� á�°�?
	 * @return ��á���� true, �׷��� ������ false.
	 */
	static boolean boardFull() {
		boolean full = true;
		for (int i=0; i<SIZE; i++)
			for (int j=0; j<SIZE; j++)
				if (board[i][j] == ' ')
					full = false;
		return full;
	}

	/**
	 * ������ �ʱ�ȭ�Ѵ�.
	 */
	static void initGame() {

		System.out.println("Tic-Tac-Toe �����Դϴ�.");
		System.out.println("����� X, ��ǻ�Ͱ� O�Դϴ�.");

		// �ٵ���(�迭) �ʱ�ȭ (�ٵ����� �迭 ��ü�μ� ȭ�鿡 ������ ��Ÿ���� �ʴ´�.)
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				board[i][j] = ' ';
		
		// ���¸� �ʱ�ȭ�Ѵ�.
		state = PLAYING;
	}

	/**
	 * ������ ����Ǿ��� �� �� ����� ����Ѵ�.
	 */
	static void printResult() {
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