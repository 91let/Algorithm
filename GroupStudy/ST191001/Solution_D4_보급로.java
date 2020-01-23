package ST191001;

import java.util.Scanner;

public class Solution_D4_보급로 {
	
	static int N, ans;
	static int[][] map;
	static int[][] dmap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] buff = new char[150];
		int T = sc.nextInt(), t = 0, chP = -1;
		while(t < T) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			dmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j) - '0';
					dmap[i][j] = Integer.MAX_VALUE;
				}
			}
			findroad(0, 0, 0);
			buff[++chP] = '#';
			String tmp = ++t + "";
			for (int i = 0; i < tmp.length(); ++i) buff[++chP] = tmp.charAt(i);
			buff[++chP] = ' ';
			tmp = dmap[N - 1][N - 1] + "";
			for (int i = 0; i < tmp.length(); ++i) buff[++chP] = tmp.charAt(i);
			buff[++chP] = '\n';
		}
		System.out.println(buff);
		sc.close();
	}

	private static void findroad(int i, int j, int w) {
		int tw = map[i][j] + w;
		if(tw < dmap[i][j]) dmap[i][j] = Math.min(tw, dmap[i][j]);
		else return;
		if(i > 0) findroad(i - 1, j, tw);
		if(i < N - 1) findroad(i + 1, j, tw);
		if(j > 0) findroad(i, j - 1, tw);
		if(j < N - 1) findroad(i, j + 1, tw);
	}

}
