package ST191218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken()), short_cut = 100000, minTime = 100000, qs = -1, qe = -1, t = 0;
		int[] dn = {-1, 1, 0, 0}, dm = {0, 0, -1, 1}, q = new int[N * M];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) short_cut = N + M - 2 - i - j;
			}
		}
		
		q[++qe] = 0;
		map[0][0] = 1;
		flag : while(qs != qe) {
			if(++t > T) break;
			int q_size = qe - qs;
			while(--q_size != -1) {
				int n = q[++qs] / 100, m = q[qs] % 100;
				for (int d = 0; d < 4; d++) {
					int tn = n + dn[d], tm = m + dm[d];
					if(tn != -1 && tm != -1 && tn != N && tm != M && map[tn][tm] != 1) {
						if(map[tn][tm] == 2) minTime = Math.min(minTime, t + short_cut);
						if(tn == N - 1 && tm == M - 1) {
							minTime = Math.min(minTime, t);
							break flag;
						}
						map[tn][tm] = 1;
						q[++qe] = tn * 100 + tm;
					}
				}
			}
		}
		if(minTime > T) System.out.println("Fail");
		else System.out.println(minTime);
	}

}

