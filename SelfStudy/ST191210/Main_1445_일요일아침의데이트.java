package ST191210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1445_일요일아침의데이트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), st_n = 0, st_m = 0, fi_n = 0, fi_m = 0;
		char[][] map = new char[N][M];
		int[] dn = {-1, 1, 0, 0}, dm = {0, 0, -1, 1}, tmp;
		for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'g') {
					for (int d = 0; d < 4; d++) {
						int tn = i + dn[d], tm = j + dm[d];
						if(tn < 0 || tm < 0 || tn > N - 1 || tm > M - 1 || map[tn][tm] != '.') continue;
						map[tn][tm] = 'G';
					}
				}else if(map[i][j] == 'S') {
					st_n = i;
					st_m = j;
				}else if(map[i][j] == 'F') {
					fi_n = i;
					fi_m = j;
				}
			}
		}
		map[fi_n][fi_m] = '.';
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) return o1[2] - o2[2];//g
				else if(o1[3] != o2[3]) return o1[3] - o2[3];//G
				else return o1[4] - o2[4];//이동횟수
			}
		});
		
		pq.offer(new int[] {st_n, st_m, 0, 0, 0});
		map[st_n][st_m] = 'X';
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			if(tmp[0] == fi_n && tmp[1] == fi_m) {
				System.out.println(tmp[2] + " " + tmp[3]);
				System.exit(0);
			}
			for (int d = 0; d < 4; d++) {
				int tn = tmp[0] + dn[d], tm = tmp[1] + dm[d];
				if(tn < 0 || tm < 0 || tn > N - 1 || tm > M - 1 || map[tn][tm] == 'X') continue;
				if(map[tn][tm] == '.') {
					pq.offer(new int[] {tn, tm, tmp[2], tmp[3], tmp[4] + 1});
				}else if(map[tn][tm] == 'G') {
					pq.offer(new int[] {tn, tm, tmp[2], tmp[3] + 1, tmp[4] + 1});
				}else {
					pq.offer(new int[] {tn, tm, tmp[2] + 1, tmp[3], tmp[4] + 1});
				}
				map[tn][tm] = 'X';
			}
		}
	}

}
