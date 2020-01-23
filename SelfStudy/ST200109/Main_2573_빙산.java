package ST200109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

	static int N, M, map[][], minus[][], ans = -1, q[];
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new int[N * M];
		map = new int[N][M];
		minus = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(!divided()) {
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					minus[i][j] = 0;
					if(map[i][j] == 0) continue;
					for (int d = 0; d < 4; d++) {
						if(map[i + dr[d]][j + dc[d]] == 0) --minus[i][j];
					}
					if(-minus[i][j] > map[i][j]) minus[i][j] = -map[i][j];
				}
			}
			++ans;
		}
		System.out.println(ans);
	}

	private static boolean divided() {
		boolean[][] check = new boolean[N][M];
		int count = 0;
		for (int i = N - 2; i > 0; --i) {
			for (int j = M - 2; j > 0; --j) {
				if(map[i][j] == 0 || check[i][j]) continue;
				if(++count == 2) return true;
				int qs = -1, qe = -1;
				q[++qe] = i * 300 + j;
				map[i][j] += minus[i][j];
				check[i][j] = true;
				while(qs != qe){
					int tmp = q[++qs];
					for (int d = 0; d < 4; d++) {
						int tr = tmp / 300 + dr[d];
						int tc = tmp % 300 + dc[d];
						if(map[tr][tc] == 0 || check[tr][tc]) continue;
						check[tr][tc] = true;
						map[tr][tc] += minus[tr][tc];
						q[++qe] = tr * 300 + tc;
					}
				}
			}
		}
		if(count == 0) {
			ans = 0;
			return true;
		}
		return false;
	}

}
