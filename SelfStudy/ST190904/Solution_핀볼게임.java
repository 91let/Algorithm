package ST190904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_핀볼게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] map;
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ArrayList<int[]> WH = new ArrayList<int[]>();
			int max = 0;
			int N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				map[0][i] = 5;
				map[i][0] = 5;
				map[N + 1][i] = 5;
				map[i][N + 1] = 5;
			}
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 6) WH.add(new int[] {6, i, j});
					if(map[i][j] == 7) WH.add(new int[] {7, i, j});
					if(map[i][j] == 8) WH.add(new int[] {8, i, j});
					if(map[i][j] == 9) WH.add(new int[] {9, i, j});
					if(map[i][j] == 10) WH.add(new int[] {10, i, j});
				}
			}
			boolean[] chi = new boolean[N+2];
			boolean[] chj = new boolean[N+2];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 2; j++) {
					if(map[i][j] == 0) {
						map[i][j] = -1;
						for (int d = 0; d < 4; d++) {
							if(d < 2 && chi[j]) continue;
							if(d > 1 && chj[i]) continue;
							int dir = d;
							int ti = i + di[dir];
							int tj = j + dj[dir];
							int point = 0;
							while(ti != i || tj != j){
								switch (map[ti][tj]) {
								case -1:
									ti = i;
									tj = j;
									break;
								case 0:
									ti += di[dir];
									tj += dj[dir];
									break;
								case 1:
									++point;
									switch (dir) {
									case 0:
										dir = 1;
										break;
									case 1:
										dir = 3;
										break;
									case 2:
										dir = 0;
										break;
									case 3:
										dir = 2;
										break;
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								case 2:
									++point;
									switch (dir) {
									case 0:
										dir = 3;
										break;
									case 1:
										dir = 0;
										break;
									case 2:
										dir = 1;
										break;
									case 3:
										dir = 2;
										break;
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								case 3:
									++point;
									switch (dir) {
									case 0:
										dir = 2;
										break;
									case 1:
										dir = 0;
										break;
									case 2:
										dir = 3;
										break;
									case 3:
										dir = 1;
										break;
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								case 4:
									++point;
									switch (dir) {
									case 0:
										dir = 1;
										break;
									case 1:
										dir = 2;
										break;
									case 2:
										dir = 3;
										break;
									case 3:
										dir = 0;
										break;
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								case 5:
									++point;
									switch (dir) {
									case 0:
										dir = 1;
										break;
									case 1:
										dir = 0;
										break;
									case 2:
										dir = 3;
										break;
									case 3:
										dir = 2;
										break;
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								case 6:
								case 7:
								case 8:
								case 9:
								case 10:
									for (int[] wh : WH) {
										if(wh[0] == map[ti][tj] && (wh[1] != ti || wh[2] != tj)) {
											ti = wh[1];
											tj = wh[2];
											break;
										}
									}
									ti += di[dir];
									tj += dj[dir];
									break;
								}
							}
							max = Math.max(max, point);
						}
						map[i][j] = 0;
						chi[j] = true;
						chj[i] = true;
					}
					else {
						chi[j] = false;
						chj[i] = false;
					}
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.print(sb);
	}
	
}
