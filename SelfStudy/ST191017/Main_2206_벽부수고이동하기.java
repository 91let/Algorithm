package ST191017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	
	static class Q{
		int size, qs, qe;
		int[][] E;
		public Q(int size) {
			this.size = size;
			qs = -1;
			qe = -1;
			E = new int[this.size][4];
		}
		
		boolean isEmpty() {
			return qs == qe;
		}
		
		void in(int[] e) {
			if((qe + 1) % size == qs) return;
			E[++qe % size] = e;
		}
		
		int[] out() {
			if(isEmpty()) return null;
			return E[++qs % size];
		}
		
		int amount(){
			return (size + qe - qs) % size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] dn = {0, 1, 0, -1}, dm = {1, 0, -1, 0};
		int[][] memo = new int[N][M];
		int[][] map = new int[N][M];
		int[][] V = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		Q q = new Q(N * M);
		q.in(new int[] {0, 0, 2, 0});
		V[0][0] = 3;
		while(!q.isEmpty()) {
			int[] tmp = q.out();
			int n = tmp[0], m = tmp[1], w = tmp[2], count = tmp[3] + 1;
			if(tmp[0] == N - 1 && tmp[1] == M - 1) {
				System.out.println(count);
				System.exit(0);
			}
			w -= map[n][m];
			for (int d = 0; d != 4; ++d) {
				int tn = n + dn[d], tm = m + dm[d];
				if(tn != -1 && tm != -1 && tn != N && tm != M && memo[tn][tm] < w && w - map[tn][tm] > 0) {
					memo[tn][tm] = w;
					q.in(new int[] {tn, tm, w, count});
				}
			}
		}
		System.out.println(-1);
	}

}
