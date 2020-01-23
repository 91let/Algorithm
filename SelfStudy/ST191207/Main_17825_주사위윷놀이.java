package ST191207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17825_주사위윷놀이 {
	
	static int ANS = 0;
	
	static int[] dices = new int[10];
	//							0		1		2		3		4		5		6		7			8		9		10		11			12		13		14		15			16		17		18		19			20		21
	static int[][][] board = {{{0, 0}, {2, 0}, {4, 0}, {6, 0}, {8, 0}, {10, 0}, {12, 0}, {14, 0}, {16, 0}, {18, 0}, {20, 0}, {22, 0}, {24, 0}, {26, 0}, {28, 0}, {30, 0}, {32, 0}, {34, 0}, {36, 0}, {38, 0}, {40, 0}, {0, 0}},
	//							0		1		2			3		4
							{{10, 0}, {13, 0}, {16, 0}, {19, 0}, {25, 0}},
	//							0		1		2			3		4		5		6
							{{20, 0}, {22, 0}, {24, 0}, {25, 0}, {30, 0}, {35, 0}, {40, 0}},
							{{30, 0}, {28, 0}, {27, 0}, {26, 0}, {25, 0}}};
	
	static void init() {
		for (int i = 0; i < 21; i++) {
			board[0][i][1] = 0;
		}
		for (int i = 0; i < 5; i++) {
			board[1][i][1] = 0;
		}
		for (int i = 0; i < 6; i++) {
			board[2][i][1] = 0;
		}
		for (int i = 0; i < 5; i++) {
			board[3][i][1] = 0;
		}
	}
	
	static class marker{
		int pos[], point;
		boolean moveable;
		public marker() {
			pos = new int[] {0, 0};
			point = 0;
			moveable = true;
		}
		
		public boolean move(int dice) {
			if(!moveable) return false;
			board[pos[0]][pos[1]][1] = 0;
			pos[1] += dice;
			if(pos[0] == 0 && pos[1] == 5) {
				pos[0] = 1;
				pos[1] = 0;
			}
			if(pos[0] == 0 && pos[1] == 10) {
				pos[0] = 2;
				pos[1] = 0;
			}
			if(pos[0] == 0 && pos[1] == 15) {
				pos[0] = 3;
				pos[1] = 0;
			}
			if(pos[0] == 1 && pos[1] > 3) {
				pos[0] = 2;
				pos[1] -= 1;
			}
			if(pos[0] == 3 && pos[1] > 3) {
				pos[0] = 2;
				pos[1] -= 1;
			}
			if(pos[0] == 2 && pos[1] > 5) {
				pos[0] = 0;
				pos[1] += 14;
			}
			if(pos[1] > 20) {
				moveable = false;
			}else {
				if(board[pos[0]][pos[1]][1] == 1) return false;
				else {
					board[pos[0]][pos[1]][1] = 1;
					point += board[pos[0]][pos[1]][0];
				}
			}
			
			return true;
		}
	}

	private static void simul() {
		for (int i = 1048576; i < 1310720; i++) {
			init();
			go(Integer.toString(i, 4));
		}
	}
	
	private static void go(String string) {
		marker[] markers = new marker[4];
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			markers[i] = new marker();
		}
		for (int i = 0; i < 10; i++) {
			if(!markers[string.charAt(i + 1) - '0'].move(dices[i])) return;
		}
		for (int i = 0; i < 4; i++) {
			sum += markers[i].point;
		}
		ANS = Math.max(sum, ANS);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for (int i = 0; i < 10; i++) dices[i] = input.charAt(i * 2) - '0'; 
		simul();
		System.out.println(ANS);
	}

}
