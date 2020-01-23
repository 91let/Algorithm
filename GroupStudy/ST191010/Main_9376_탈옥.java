package ST191010;

import java.util.Scanner;

public class Main_9376_탈옥 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), P = -1;
		char[] buff = new char[4000];
		while (--T > -1) {
			int H = sc.nextInt() + 4, W = sc.nextInt() + 4, num = 0, answer = Integer.MAX_VALUE;
			int[] dh = { 1, -1, 0, 0 }, dw = { 0, 0, -1, 1 };
			int[][] M0 = new int[H][W], M1 = new int[H][W], M2 = new int[H][W], starts = new int[2][2], q = new int[20000][2];
			char[][] map = new char[H][W];
			for (int i = 2; i < H - 2; i++) {
				map[i][0] = '*';
				map[i][1] = '.';
				map[i][W - 2] = '.';
				map[i][W - 1] = '*';
				String tmp  = sc.next();
				for (int j = 2; j < W - 2; j++) {
					map[i][j] = tmp.charAt(j - 2);
					if(map[i][j] == '$') {
						starts[num][0] = i;
						starts[num++][1] = j;
					}
				}
			}
			for (int i = 0; i < W; i++) {
				map[0][i] = '*';
				map[1][i] = '.';
				map[H - 2][i] = '.';
				map[H - 1][i] = '*';
			}
			map[1][0] = '*';
			map[1][W - 1] = '*';
			map[H - 2][0] = '*';
			map[H - 2][W - 1] = '*';
			
			int qs = 9999, qe = 9999;
			q[++qe] = new int[] {1, 1};
			M0[1][1] = 1;
			while(qs != qe) {
				int[] tmp = q[++qs];
				for (int d = 0; d < 4; d++) {
					int nh = tmp[0] + dh[d], nw = tmp[1] + dw[d], open = M0[tmp[0]][tmp[1]];
					if(map[nh][nw] != '*' && M0[nh][nw] < 1) {
						if(map[nh][nw] != '#') {
							M0[nh][nw] = open;
							q[qs--] = new int[] {nh, nw};
						}
						else {
							M0[nh][nw] = open + 1;
							q[++qe] = new int[] {nh, nw};
						}
					}
				}
			}
			qs = 9999;
			qe = 9999;
			q[++qe] = starts[0];
			M1[starts[0][0]][starts[0][1]] = 1;
			while(qs != qe) {
				int[] tmp = q[++qs];
				for (int d = 0; d < 4; d++) {
					int nh = tmp[0] + dh[d], nw = tmp[1] + dw[d], open = M1[tmp[0]][tmp[1]];
					if(map[nh][nw] != '*' && M1[nh][nw] < 1) {
						if(map[nh][nw] != '#') {
							M1[nh][nw] = open;
							q[qs--] = new int[] {nh, nw};
						}
						else {
							M1[nh][nw] = open + 1;
							q[++qe] = new int[] {nh, nw};
						}
					}
				}
			}
			qs = 9999;
			qe = 9999;
			q[++qe] = starts[1];
			M2[starts[1][0]][starts[1][1]] = 1;
			while(qs != qe) {
				int[] tmp = q[++qs];
				for (int d = 0; d < 4; d++) {
					int nh = tmp[0] + dh[d], nw = tmp[1] + dw[d], open = M2[tmp[0]][tmp[1]];
					if(map[nh][nw] != '*' && M2[nh][nw] < 1) {
						if(map[nh][nw] != '#') {
							M2[nh][nw] = open;
							q[qs--] = new int[] {nh, nw};
						}
						else {
							M2[nh][nw] = open + 1;
							q[++qe] = new int[] {nh, nw};
						}
					}
				}
			}
			for (int i = 2; i < H - 2; i++) {
				for (int j = 2; j < W - 2; j++) {
					if(map[i][j] != '*') {
						if(map[i][j] != '#') answer = Math.min(M0[i][j] + M1[i][j] + M2[i][j] - 3, answer);
						else answer = Math.min(M0[i][j] + M1[i][j] + M2[i][j] - 5, answer);
					}
				}
			}
			String tmp = answer + "";
			for (int i = 0; i < tmp.length(); i++) buff[++P] = tmp.charAt(i);
			buff[++P] = '\n';
		}
		System.out.println(new String(buff).trim());
	}

}