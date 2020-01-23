package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dw = { 0, 0, -1, 1 };
		int[] dh = { -1, 1, 0, 0 };
		/*
		 * start를 포함한 점들 사이의 최단 거리들을 구한다
		 * 2차배열 맵에서 최단거리를 구해서 ans 기록
		 */
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int ans = -1;
			
			if(w == 0 && h == 0) break;	//test_case 끝
			
			int p_c = 1;
			int[] ps = new int[11];
			
			char[][] m = new char[h][w];
			for (int i = 0; i < h; i++) {
				m[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if(m[i][j] == '*') {
						ps[p_c++] = i * 32 + j;
					}
					if(m[i][j] == 'o') {
						ps[0] = i * 32 + j;
					}
				}
			}
			
			int[][] p_m = new int[p_c][p_c];
			
			for (int i = 0; i < p_c; i++) {
				for (int j = i + 1; j < p_c; j++) {
					char[][] t_m = new char[h][w];
					for (int k = 0; k < h; k++) {
						t_m[k] = m[k].clone();
					}
					Queue<Integer> q = new LinkedList<Integer>();
					q.offer(ps[i]);
					while(!q.isEmpty()) {
						int t = q.poll();
						int t_c = t / 1024;
						if(t % 1024 == ps[j]) {
							p_m[i][j] = t_c;
							p_m[j][i] = t_c;
							break;
						}
						t_c = (t_c + 1) * 1024;
						int t_h = t / 32 % 32;
						int t_w = t % 32;
						for (int d = 0; d < 4; d++) {
							if(t_h + dh[d] > -1 && t_h + dh[d] < h && t_w + dw[d] > -1 && t_w + dw[d] < w && t_m[t_h + dh[d]][t_w + dw[d]] != 'x') {
								t_m[t_h + dh[d]][t_w + dw[d]] = 'x';
								q.offer(t_c + (t_h + dh[d]) * 32 + t_w + dw[d]);
							}
						}
					}
				}
			}
//			for (int i = 0; i < p_c; i++) {
//				for (int j = 0; j < p_c; j++) {
//					System.out.print(p_m[i][j] + " ");
//				}
//				System.out.println();
//			}
			int zerocount = 0;
			for (int i = 0; i < p_c; i++) {
				if(p_m[0][i] == 0) zerocount++;
			}
			if (zerocount == 1) {
				int min = 999999;
				int checksum = 0;
				for (int i = 1; i < p_c; i++) {
					int t_min = p_m[0][i] + checker(p_m, checksum|1<<i, i);
					if(t_min < min) {
						min = t_min;
					}
				}
				ans = min; //최소값 집어넣기
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}

	private static int checker(int[][] p_m, int checksum, int last_index) {
		if(checksum == (1<<p_m.length) - 2) return 0;
		int min = 999999;
		for (int i = 1; i < p_m.length; i++) {
			if((checksum&(1<<i)) == 0) {
				int tmp = p_m[last_index][i] + checker(p_m, checksum|(1<<i), i);
				if(tmp < min) {
					min = tmp;
				}
			}
		}
		return min;
	}

}
