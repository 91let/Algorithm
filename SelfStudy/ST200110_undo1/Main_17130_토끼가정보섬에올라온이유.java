package ST200110_undo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17130_토끼가정보섬에올라온이유 {

	static boolean end = false;
	static String[] map;
	static int[][] dp;
	static boolean[][] check;
	static int[] dr = {-1, 0, 1};
	static int N, M, Ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int row_up = -1, row_down = -1, col = -1;
		map = new String[N];
		dp = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
			for (int j = 0; j < M; j++) {
				if(map[i].charAt(j) =='R') {
					row_up = i;
					row_down = i + 1;
					col = j;
					check[i][j] = true;
				}
			}
		}
		while(col != M - 1) {
			for (int row = row_up; row < row_down; row++) {
				int now = dp[row][col];
				int next_col = col + 1;
				if(map[row].charAt(col) == '#' || !check[row][col]) continue;
				for (int d = 0; d < 3; d++) {
					dp_calc(row, col, row + dr[d], col + 1);
				}
			}
			if(row_up > 0) --row_up;
			if(row_down < N) ++row_down;
			++col;
		}
		if(end) System.out.println(Ans);
		else System.out.println(-1);
	}

	private static void dp_calc(int row, int col, int next_row, int next_col) {
		if(next_row < 0 || next_row == N || map[next_row].charAt(next_col) == '#') return;
		int now_dp = dp[row][col];
		check[next_row][next_col] = true;
		if(map[next_row].charAt(next_col) == '.') {
			dp[next_row][next_col] = Math.max(dp[next_row][next_col], now_dp);
		}
		else if(map[next_row].charAt(next_col) == 'O') {
			dp[next_row][next_col] = Math.max(dp[next_row][next_col], now_dp);
			Ans = Math.max(Ans, dp[next_row][next_col]);
			end = true;
		}
		else if(map[next_row].charAt(next_col) == 'C') {
			dp[next_row][next_col] = Math.max(dp[next_row][next_col], now_dp + 1);
		}
	}

}
