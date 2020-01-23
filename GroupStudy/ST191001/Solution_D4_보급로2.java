package ST191001;

import java.util.Scanner;

public class Solution_D4_보급로2 {
	
	static class MyHeap{
		public int[][] E;
		private int size;
		public MyHeap(int maxsize) {
			E = new int[maxsize][3];
			size = 0;
		}
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size < 1;
		}
		public void push(int[] in){
			E[++size] = in;
			int p = size, np;
			int[] tmp;
			while(p > 0) {
				np = p/2;
				if(E[p][2] < E[np][2]) {
					tmp = E[p];
					E[p] = E[np];
					E[np] = tmp;
				}
				else break;
				p = np;
			}
		}
		public int[] poll() {
			int[] re = E[1], tmp = E[size--];
			int p = 1, np = 2;
			while(np < size + 1) {
				if(np < size && E[np][2] > E[np + 1][2]) ++np;
				if(tmp[2] < E[np][2]) break;
				E[p] = E[np];
				p = np;
				np *= 2;
			}
			E[p] = tmp;
			
			return re;
		}
		public String toString() {
			String tmp = "";
			for (int i = 1; i < size + 1; i++) {
				tmp += "{" +E[i][0] + ", " + E[i][1] + ", " + E[i][2] + "} ";
			}
			return tmp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] buff = new char[150];
		int T = sc.nextInt(), t = 0, chP = -1, ti, tj;
		while(t < T) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0, j = 0; i < N; i++, j = 0) for (String tmp = sc.next(); j < N; j++) map[i][j] = tmp.charAt(j) - '0';
			MyHeap MH = new MyHeap(N * N + 1);
			int[] di = {0, 0, -1, 1}, dj = {-1, 1, 0, 0};
			MH.push(new int[] {0, 0, 0});
			map[0][0] = -1;
			while(!MH.isEmpty()) {
				int[] E = MH.poll();
				int i = E[0], j = E[1], w = E[2];
				for (int k = 0; k < 4; k++) {
					ti = i + di[k];
					tj = j + dj[k];
					if(ti > -1 && ti < N && tj > -1 && tj < N && map[ti][tj] > -1) {
						MH.push(new int[] {ti ,tj, w + map[ti][tj]});
						map[ti][tj] = -1;
						if(ti == N - 1 && tj == N - 1) {
							buff[++chP] = '#';
							String tmp = ++t + "";
							for (int c = 0; c < tmp.length(); ++c) buff[++chP] = tmp.charAt(c);
							buff[++chP] = ' ';
							tmp = w + "";
							for (int c = 0; c < tmp.length(); ++c) buff[++chP] = tmp.charAt(c);
							buff[++chP] = '\n';
						}
					}
				}
			}
		}
		System.out.println(buff);
		sc.close();
	}
}
