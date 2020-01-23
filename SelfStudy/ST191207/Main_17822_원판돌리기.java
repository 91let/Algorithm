package ST191207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {

	static int N, M, plate[][], q[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()), x, d, k, calc, ans = 0;
		plate = new int[N + 1][M];
		q = new int[N * M][2];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken()) % M;
			calc = (d != 1) ? k : M - k;
			for (int j = x; j < N; j += x) {
				int[] tmp = new int[M];
				for (int r = 0; r < M; r++) {
					tmp[(r + calc) % M] = plate[j][r];
				}
				plate[j] = tmp;
			}
			if (!delete()) balance();
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += plate[i][j];
			}
		}
		System.out.println(ans);
	}

	private static boolean delete() {
		boolean result = false;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int num = plate[i][j];
				if (num != 0) {
					if (plate[i - 1][j] == num || plate[i][(j + 1) % M] == num || plate[i][(j + M - 1) % M] == num || plate[i + 1][j] == num) {
						int qs = -1, qe = -1;
						plate[i][j] = 0;
						q[++qe] = new int[] { i, j };
						while (qs != qe) {
							int[] tmp = q[++qs];
							int ti = tmp[0], tj = tmp[1];
							if (plate[ti + 1][tj] == num) {
								plate[ti + 1][tj] = 0;
								q[++qe] = new int[] { ti + 1, tj };
								result = true;
							}
							if (plate[ti - 1][tj] == num) {
								plate[ti - 1][tj] = 0;
								q[++qe] = new int[] { ti - 1, tj };
								result = true;
							}
							if (plate[ti][(tj + 1) % M] == num) {
								plate[ti][(tj + 1) % M] = 0;
								q[++qe] = new int[] { ti, (tj + 1) % M };
								result = true;
							}
							if (plate[ti][(tj + M - 1) % M] == num) {
								plate[ti][(tj + M - 1) % M] = 0;
								q[++qe] = new int[] { ti, (tj + M - 1) % M };
								result = true;
							}
						}
					}
				}
			}
		}
		return result;
	}

	private static void balance() {
		int sum = 0, cnt = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (plate[i][j] != 0) {
					cnt++;
					sum += plate[i][j];
				}
			}
		}
		if (cnt == 0) return;
		double avg = sum / (double) cnt;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (plate[i][j] != 0) {
					if (plate[i][j] > avg) plate[i][j]--;
					else if (plate[i][j] < avg) plate[i][j]++;
				}
			}
		}
	}

}
