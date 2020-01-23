package ST200114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][][] check = new boolean[N][N][2];
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
		
		int count = 0, Ans = 0;
		
		int B_index = -1;
		int[] B_R = new int[3];
		int[] B_C = new int[3];
		int E_index = -1;
		int[] E_R = new int[3];
		int[] E_C = new int[3];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'B') {
					B_R[++B_index] = i;
					B_C[B_index] = j;
				}else if(map[i][j] == 'E') {
					E_R[++E_index] = i;
					E_C[E_index] = j;
				}
			}
		}
		
		//시작점 및 상태
		int[] start = {B_R[1], B_C[1], 0};
		if(B_R[0] == B_R[2]) start[2] = 1;
		//종료점 및 상태
		int[] end = {E_R[1], E_C[1], 0};
		if(E_R[0] == E_R[2]) end[2] = 1;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(start);
		check[start[0]][start[1]][start[2]] = true;
		
		flag : while(!q.isEmpty()) {
			for (int i = q.size(); i != 0; --i) {
				int[] tmp = q.poll();
				if(tmp[0] == end[0] && tmp[1] == end[1] && tmp[2] == end[2]) {
					Ans = count;
					break flag;
				}
				for (int d = 0; d < 4; d++) {
					int tr = tmp[0] + dr[d];
					int tc = tmp[1] + dc[d];
					int state = tmp[2];
					if(tr == -1 || tr == N || tc == -1 || tc == N || check[tr][tc][state]) continue;
					if(state == 0) {//세로
						if(tr == 0 || tr == N - 1 || map[tr - 1][tc] == '1' || map[tr][tc] == '1' || map[tr + 1][tc] == '1') continue;
					}else {
						if(tc == 0 || tc == N - 1 || map[tr][tc - 1] == '1' || map[tr][tc] == '1' || map[tr][tc + 1] == '1') continue;
					}
					check[tr][tc][state] = true;
					q.add(new int[] {tr, tc, state});
				}
				boolean turnalbe = true;
				for (int d = 0; d < 8; d++) {
					int tr = tmp[0] + dr[d];
					int tc = tmp[1] + dc[d];
					if(tr == -1 || tr == N || tc == -1 || tc == N || map[tr][tc] =='1') {
						turnalbe = false;
						break;
					}
				}
				if(turnalbe) {
					if(check[tmp[0]][tmp[1]][(tmp[2] + 1) % 2]) continue;
					check[tmp[0]][tmp[1]][(tmp[2] + 1) % 2] = true;
					q.add(new int[] {tmp[0], tmp[1], (tmp[2] + 1) % 2});
				}
			}
			++count;
		}
		
		System.out.println(Ans);
	}

}
