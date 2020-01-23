package ST200117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17244_아맞다우산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][] check = new int[N][M];
		int X_count = 0, count = 0, qs = -1, qe = -1;
		int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1}, start = null;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'S') {
					start = new int[] {i, j, 0};
					map[i][j] = '.';
					check[i][j] = 1;
				}else if(map[i][j] == 'X') {
					map[i][j] = (char)X_count++;
				}
			}
		}
		
		int[][] q = new int[N * M * (int)Math.pow(2, X_count)][3];
		q[++qe] = start;
		
		flag: while(true) {
			++count;
			for (int i = qe - qs; i != 0; --i) {
				int[] tmp = q[++qs];
				for (int d = 0; d < 4; d++) {
					int tr = tmp[0] + dr[d], tc = tmp[1] + dc[d], status = tmp[2];
					if(map[tr][tc] == '#' || ((check[tr][tc] >> status) & 1) == 1) continue;
					else if(map[tr][tc] == 'E') {
						if(status == (int)Math.pow(2, X_count) - 1) break flag;
						else continue;
					}
					check[tr][tc] |= (1 << status);
					if(map[tr][tc] != '.') status |= 1 << (map[tr][tc]);
					q[++qe] = new int[] {tr, tc, status};
				}
			}
		}
		System.out.println(count);
	}

}
