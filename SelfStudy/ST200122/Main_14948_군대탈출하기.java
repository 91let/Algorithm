package ST200122;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14948_군대탈출하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][][] check = new boolean[n][m][2];
		final int[] dr = {-1, 1, 0, 0, -2, 2, 0, 0}, dc = {0, 0, -1, 1, 0, 0, -2, 2};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pq.add(new int[] {0, 0, map[0][0], 0});
		check[0][0][0] = true;
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if(tmp[0] == n - 1 && tmp[1] == m - 1) {
				System.out.println(tmp[2]);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int tr = tmp[0] + dr[d], tc = tmp[1] + dc[d];
				if(tr < 0 || tr > n - 1 || tc < 0 || tc > m - 1 || check[tr][tc][tmp[3]]) continue;
				check[tr][tc][tmp[3]] = true;
				pq.add(new int[] {tr, tc, (tmp[2] > map[tr][tc])? tmp[2]: map[tr][tc], tmp[3]});
			}
			if(tmp[3] == 0) {
				for (int d = 4; d < 8; d++) {
					int tr = tmp[0] + dr[d], tc = tmp[1] + dc[d];
					if(tr < 0 || tr > n - 1 || tc < 0 || tc > m - 1 || check[tr][tc][1]) continue;
					check[tr][tc][1] = true;
					pq.add(new int[] {tr, tc, (tmp[2] > map[tr][tc])? tmp[2]: map[tr][tc], 1});
				}
			}
		}
	}

}