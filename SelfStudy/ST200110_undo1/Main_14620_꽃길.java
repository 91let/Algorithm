package ST200110_undo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620_꽃길 {

	static int N, map[][], ans = Integer.MAX_VALUE;
	static boolean[][] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i != N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j != N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		seed(N - 2, N - 2, 0, 0);
		System.out.println(ans);
	}

	private static void seed(int row, int col, int count, int G) {
		if(G - 1 > ans) return;
		if(count == 3) {
			ans = G;
			return;
		}
		for (int i = col; i != 0; --i) {
			if(planted(row, i)) continue;
			checker(row, i, true);
			seed(row, i, count + 1, G + sum_value(row, i));
			checker(row, i, false);
		}
		for (int i = row - 1; i != 0; --i) {
			for (int j = N - 2; j != 0; --j) {
				if(planted(i, j)) continue;
				checker(i, j, true);
				seed(i, j, count + 1, G + sum_value(i, j));
				checker(i, j, false);
			}
		}
	}
	
	private static int sum_value(int row, int col) {
		return map[row - 1][col] + map[row + 1][col] + map[row][col] + map[row][col - 1] + map[row][col + 1];
	}

	private static boolean planted(int row, int col) {
		return check[row - 1][col] || check[row + 1][col] || check[row][col] || check[row][col - 1] || check[row][col + 1];
	}
	
	private static void checker(int row, int col, boolean value) {
		check[row - 1][col] = check[row + 1][col] = check[row][col] = check[row][col - 1] = check[row][col + 1] = value;
	}

}

