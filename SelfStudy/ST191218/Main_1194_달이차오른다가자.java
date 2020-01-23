package ST191218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), qs = -1, qe = -1, count = 0;
		int[] q = new int[N * M * 64];
		int[] dn = {-1, 1, 0, 0}, dm = {0, 0, -1, 1};
		boolean[][][] check = new boolean[N + 2][M + 2][64];
		char[][] map = new char[N + 2][M + 2];
		for (int i = 0; i < M + 2; i++) map[0][i] = map[N + 1][i] = '#';
		for (int i = 1; i < N + 1; i++) {
			map[i] = ('#' + br.readLine() + '#').toCharArray();
			for (int j = 1; j < M + 1; j++) {
				if(map[i][j] == '0') {
					check[i][j][0] = true;
					map[i][j] = '.';
					q[++qe] = i << 6 | j;
				}
			}
		}
		while(qs != qe) {
			int q_size = qe - qs;
			++count;
			while(--q_size != -1) {
				int tmp = q[++qs];
				int key = tmp >> 12;
				int n = (tmp >> 6) % 64;
				int m = tmp % 64;
				for (int d = 0; d < 4; d++) {
					int tn = n + dn[d];
					int tm = m + dm[d];
					if(check[tn][tm][key]) continue;
					else if(map[tn][tm] == '.') {
						check[tn][tm][key] = true;
						q[++qe] = key << 12 | tn << 6 | tm;
					}
					else if(map[tn][tm] > 96) {
						check[tn][tm][key] = true;
						q[++qe] = (key | (1 << (map[tn][tm] - 'a'))) << 12 | tn << 6 | tm;
					}
					else if(map[tn][tm] > 64) {
						if(((key >> (map[tn][tm] - 'A')) & 1) != 1) continue;
						check[tn][tm][key] = true;
						q[++qe] = key << 12 | tn << 6 | tm;
					}
					else if(map[tn][tm] == '1') {
						System.out.println(count);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(-1);
	}

}
