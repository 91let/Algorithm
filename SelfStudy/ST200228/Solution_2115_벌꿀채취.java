package ST200228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	
	static int N, M, C, Ans;
	static int A, B;
	static int[][] map, maxMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			makeMaxMap();
			
			sb.append('#').append(++t).append(' ').append(getMax()).append('\n');
		}
		System.out.print(sb);
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N + 1 - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) return;
		if(cnt == M) {
			maxMap[i][j - M] = Math.max(maxMap[i][j - M], powSum);
			return;
		}
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}
	
	private static int getMax() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N + 1 - M; j++) {
				for (int j2 = j + M; j2 < N + 1 - M; j2++) {
					max = Math.max(max, maxMap[i][j] + maxMap[i][j2]);
				}
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N + 1 - M; j2++) {
						max = Math.max(max, maxMap[i][j] + maxMap[i2][j2]);
					}
				}
			}
		}
		return max;
	}
	
}
