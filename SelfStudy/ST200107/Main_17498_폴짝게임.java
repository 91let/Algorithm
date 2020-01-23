package ST200107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17498_폴짝게임 {

	static int N, M, D;
	static int[][] data, dp_map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		data = new int[N][M];
		dp_map = new int[N][M];
		for (int i = 0; i < M; i++) {
			data[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				dp_map[i][j] = Integer.MIN_VALUE;
			}
		}
		
		for (int insert_row = 1; insert_row < N; insert_row++) {
			for (int insert_col = 0; insert_col < M; insert_col++) {
				for (int row = (insert_row - D > -1) ? insert_row - D : 0; row < insert_row; row++) {
					for (int col = insert_col - D + 1; col < insert_col + D; col++) {
						if(col < 0 || col > M - 1) continue;
						if(insert_row - row + Math.abs(insert_col - col) > D) continue;
						dp_map[insert_row][insert_col] = Math.max(dp_map[insert_row][insert_col], dp_map[row][col] + data[row][col] * data[insert_row][insert_col]);
					}
				}
			}
		}
		int Ans = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			Ans = Integer.max(Ans, dp_map[N - 1][i]);
		}
		System.out.println(Ans);
	}

}
