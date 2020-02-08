package ST200208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] board = new int[5][5];
		int[] call_num = new int[26];
		int count = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 6; j++) {
				call_num[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int b = 1; b < 26; b++) {
			search: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(board[i][j] == call_num[b]) {
						board[i][j] = 0;
						if((board[i][0] | board[i][1] | board[i][2] | board[i][3] | board[i][4]) == 0) ++count;
						if((board[0][j] | board[1][j] | board[2][j] | board[3][j] | board[4][j]) == 0) ++count;
						if(i == j) {
							if((board[0][0] | board[1][1] | board[2][2] | board[3][3] | board[4][4]) == 0) ++count;
						}
						if(i == 4 - j) {
							if((board[0][4] | board[1][3] | board[2][2] | board[3][1] | board[4][0]) == 0) ++count;
						}
						break search;
					}
				}
			}
			if(count > 2) {
				System.out.println(b);
				break;
			}
		}
	}

}
