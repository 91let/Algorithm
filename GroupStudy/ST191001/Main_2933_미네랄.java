package ST191001;

import java.util.Scanner;

public class Main_2933_미네랄 {
	static class MyQueue{
		private int f, r, size;
		private int[][] e;
		public MyQueue() {
			size = 1000000;
			e = new int[size][2];
			f = r = 0;
		}
		public MyQueue(int size) {
			this.size = size;
			e = new int[size][2];
			f = r = 0;
		}
		public boolean isEmpty() {
			return f==r;
		}
		public boolean isFull() {
			return (f - 1 + size) % size == r;
		}
		public void enqueue(int[] o) {
			if(isFull()) return;
			e[++r % size] = o;
		}
		public int[] dequeue() {
			if(isEmpty()) return null;
			return e[++f % size];
		}
		public int counting() {
			return (r + size - f) % size; 
		}
	}

	static MyQueue q;
	static boolean[][] chmap = null;
	static char[][] map = null;
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	static int R = 0, C = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		int p = -1, c = -1, T;
		while(tmp.charAt(++p) != ' ') R = R * 10 + tmp.charAt(p) - '0';
		while(++p < tmp.length()) C = C * 10 + tmp.charAt(p) - '0';
		q = new MyQueue(R * C);
		map = new char[R][C];
		char[] buff = new char[(C + 1) * R];
		while(++c < R) map[c] = sc.nextLine().toCharArray();
		T = Integer.parseInt(sc.nextLine());
		int[] S = new int[T];
		String TL = sc.nextLine();
		p = 0;
		c = -1;
		while(c < TL.length()) {
			while(++c < TL.length() && TL.charAt(c) !=' ') {
				S[p] = S[p] * 10 + TL.charAt(c) - '0';
			}
			++p;
		}
		for (int i = 0; i < T; i++) {
			if(i % 2 != 1) {
				for (int j = 0; j < C; ++j) {
					if(map[R - S[i]][j] != '.') {
						map[R - S[i]][j] = '.';
						checking(R - S[i], j);
						break;
					}
				}
			}else {
				for (int j = C - 1; j > -1; --j) {
					if(map[R - S[i]][j] != '.') {
						map[R - S[i]][j] = '.';
						checking(R - S[i], j);
						break;
					}
				}
			}
//			System.out.println(i + " " + S[i]);
//			show();
		}
		for (int i = 0; i < R;) {
			for (int j = 0; j < C; ++j) {
				buff[i * (C + 1) + j] = map[i][j];
			}
			buff[(++i) * (C + 1) - 1] = '\n';
		}
		System.out.println(buff);
		sc.close();
	}

	private static void checking(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int tr = r + dr[d], tc = c + dc[d], needfall = R;
			boolean fall = true;
			chmap = new boolean[R][C];
			if(tr > -1 && tc > -1 && tr < R && tc < C && map[tr][tc] != '.') {
				chmap[tr][tc] = true;
				map[tr][tc] = '.';
				q.enqueue(new int[] {tr, tc});
			}
			if(q.isEmpty()) continue;
			while(!q.isEmpty()) {
				int tmp[] = q.dequeue();
				if(tmp[0] > R - 2) fall = false;
				map[tmp[0]][tmp[1]] = '.';
				chmap[tmp[0]][tmp[1]] = true;
				for (int d2 = 0; d2 < 4; ++d2) {
					int ttr = tmp[0] + dr[d2], ttc = tmp[1] + dc[d2];
					if(ttr > -1 && ttc > -1 && ttr < R && ttc < C && !chmap[ttr][ttc] && map[ttr][ttc] != '.') {
						chmap[ttr][ttc] = true;
						map[ttr][ttc] = '.';
						q.enqueue(new int[] {ttr, ttc});
					}
				}
			}
			if(fall) {
				for (int i = 0; i < R; ++i) {
					for (int j = 0; j < C; ++j) {
						if(chmap[i][j]) {
							int count = 0;
							while(true) {
								if(i + count + 1 == R) break;
								if(map[i + count + 1][j] != '.') {
									break;
								}
								++count;
							}
							needfall = Math.min(needfall, count);
						}
					}
				}
				for (int i = 0; i < R; ++i) {
					for (int j = 0; j < C; ++j) {
						if(chmap[i][j]) map[i + needfall][j] = 'x';
					}
				}
				
				return;
			}else {
				for (int i = 0; i < R; ++i) {
					for (int j = 0; j < C; ++j) {
						if(chmap[i][j]) map[i][j] = 'x';
					}
				}
			}
		}
	}
	
//	private static void show() {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
	
}

