package w1_2277;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/** 
 * 전역변수(global variable)를 사용하여 함수를 단순화.
 */
public class TicTacToe5 {

	// 게임 상태를 나타내는 상수 
	static final int PLAYING = 0;		// 게임 진행중.
	static final int DRAW = 1;		// 비김.
	static final int CROSS_WON = 2;		// X 선수 승. 
	static final int NOUGHT_WON = 3;	// O 선수 승.

	static final int SIZE = 5;
	static char[][] board = new char[SIZE][SIZE];
	static Scanner scan = new Scanner(System.in);

	static char currentMark;
	static int x, y;
	static int state;

	public static void main(String[] args) throws InterruptedException {

		initGame();			// 게임을 초기화한다.
		printBoard();		// 바둑판을 화면에 그린다.

		boolean end = false;

		while (!end) {
			// 사람의 차례.
			humanPlay();
			printBoard();		 // 바둑판을 화면에 그린다.	
			checkGame();
			if (state != PLAYING) {
				end = true;
				continue;
			}

			TimeUnit.SECONDS.sleep(1);  // 프로그램 실행을 1초 동안 멈춘다. InterruptedException을 던지는 수가 있다. ****
			
			// 컴퓨터의 차례.
			computerPlay();
			printBoard();		 // 바둑판을 화면에 그린다.	
			checkGame();
			if (state != PLAYING) 
				end = true;
		}
		printResult();			// 누가 승리했는지, 혹은 무승부인지를 알려준다.
		scan.close();
	}

	/**
	 * 현재 바둑판의 상태를 화면에 출력한다.
	 * 입력된 SIZE 크기의 바둑판을 그린다.
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
	 * (x, y)에 돌을 놓을 수 있는지 판별한다.
	 * @return 좌표가 유효하면 true, 그렇지 않으면 false를 반환한다.
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
	 * 사람으로부터 입력을 받아 바둑판에 놓는다
	 */
	static void humanPlay() {
		currentMark = 'X';
		System.out.print("다음 수의 좌표를 입력하시오: ");
		x = scan.nextInt();
		y = scan.nextInt();

		while(!inputValid()) {	// 입력이 올바르지 않은 경우
			System.out.print("올바른 위치가 아닙니다. 다시 입력하시오: ");
			x = scan.nextInt();
			y = scan.nextInt();
		}
		board[x][y] = 'X';
	}

	/**
	 * 컴퓨터가 돌을 놓는다.
	 */
	static void computerPlay() {
		Random r = new Random();
		do {				// 유효한 숫자가 나타날 때까지 무작위로 위치를 선정한다. 
			x = r.nextInt(SIZE);
			y = r.nextInt(SIZE);
		} while (!inputValid());
		board[x][y] = 'O';
	}

	/**
	 * 게임의 상태를 체크한다.
	 */
	static void checkGame() {
		char currentMark = board[x][y]; 	//최근에 놓은 돌의 모양.
		boolean won = false;
		int i = 0, j = 0;
		int count;
		
		// 세로 승리 여부
		for (i = 0; i < SIZE; i++) {
			count = 0;
			for (j = 0; j < SIZE; j++) {
				if (board[i][j] == currentMark)
					count++;
			}
			if (count == SIZE)
				won = true;
		}
		// 가로 승리 여부
		for (i = 0; i < SIZE; i++) {
			count = 0;
			for (j = 0; j < SIZE; j++) {
				if (board[j][i] == currentMark)
					count++;
			}
			if (count == SIZE)
				won = true;
		}
		
		// 대각선 승리 여부
		count = 0;
		if (x==y) {
			for (i = 0; i < SIZE; i++) {
				if (board[i][i] == currentMark)
					count++;
				if (count == SIZE)
					won = true;
			}
		}
		
		// 역대각선 승리 여부
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
		if (won) state = (currentMark == 'X') ? CROSS_WON : NOUGHT_WON; // 승부가 났음
		else if (boardFull()) state = DRAW;		// 비김
		else state = PLAYING;	// 게임 진행중
	}

	/**
	 * 바둑판이 꽉 찼는가?
	 * @return 꽉찼으면 true, 그렇지 않으면 false.
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
	 * 게임을 초기화한다.
	 */
	static void initGame() {

		System.out.println("Tic-Tac-Toe 게임입니다.");
		System.out.println("사람이 X, 컴퓨터가 O입니다.");

		// 바둑판(배열) 초기화 (바둑판은 배열 자체로서 화면에 저절로 나타나지 않는다.)
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				board[i][j] = ' ';
		
		// 상태를 초기화한다.
		state = PLAYING;
	}

	/**
	 * 게임이 종료되었을 떄 그 결과를 출력한다.
	 */
	static void printResult() {
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