package ST200108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][M + 2];
		for (int i = M + 1; i != -1; --i) {
			map[0][i] = map[N + 1][i] = 2;
		}
		for (int i = 1; i < N + 1; i++) {
			String tmp = '2' + br.readLine() + '2';
			for (int j = 0; j < M + 2; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		pq.add(new int[] {0, 1, 1});
		map[1][1] = 2;
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if(tmp[1] == N && tmp[2] == M) {
				System.out.println(tmp[0]);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int tr = tmp[1] + dr[d], tc = tmp[2] + dc[d];
				if(map[tr][tc] != 2) {
					pq.add(new int[] {tmp[0] + map[tr][tc], tr, tc});
					map[tr][tc] = 2;
				}
			}
		}
	}

}
