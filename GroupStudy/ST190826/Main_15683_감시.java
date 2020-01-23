package ST190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	

	static int[][] cam = new int[8][2];
	static int N;
	static int M;
	static int camI = 0;
	static int min = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cam[camI][0] = i;
					cam[camI++][1] = j;
				}
			}
		}
		
		rotating(map, 0);
		
		System.out.println(min);
	}

	private static void rotating(int[][] map, int count) {
		if(count == camI) {
			int ismin = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						ismin++;
					}
				}
			}
			min = Math.min(ismin, min);
			return;
		}
		int[][] copy = new int[N][M];
		switch (map[cam[count][0]][cam[count][1]]) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int n = 0; n < N; n++) {
					copy[n] = map[n].clone();
				}
				marking(copy, cam[count][0], cam[count][1], i);
				rotating(copy, count + 1);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				for (int n = 0; n < N; n++) {
					copy[n] = map[n].clone();
				}
				marking(copy, cam[count][0], cam[count][1], i);
				marking(copy, cam[count][0], cam[count][1], i + 2);
				rotating(copy, count + 1);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int n = 0; n < N; n++) {
					copy[n] = map[n].clone();
				}
				marking(copy, cam[count][0], cam[count][1], i);
				marking(copy, cam[count][0], cam[count][1], (i + 1) % 4);
				rotating(copy, count + 1);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int n = 0; n < N; n++) {
					copy[n] = map[n].clone();
				}
				marking(copy, cam[count][0], cam[count][1], i);
				marking(copy, cam[count][0], cam[count][1], (i + 1) % 4);
				marking(copy, cam[count][0], cam[count][1], (i + 2) % 4);
				rotating(copy, count + 1);
			}
			break;
		case 5:
			for (int n = 0; n < N; n++) {
				copy[n] = map[n].clone();
			}
			marking(copy, cam[count][0], cam[count][1], 0);
			marking(copy, cam[count][0], cam[count][1], 1);
			marking(copy, cam[count][0], cam[count][1], 2);
			marking(copy, cam[count][0], cam[count][1], 3);
			rotating(copy, count + 1);
			break;
		}
	}

	private static void marking(int[][] copy, int i, int j, int r) {
		int go = 1;
		switch (r) {
		case 0:
			while(i - go > -1) {
				if(copy[i - go][j] == 0) {
					copy[i - go][j] = -1;
					++go;
				} else if(copy[i - go][j] == 6) {
					break;
				} else ++go;
			}
			break;
		case 2:
			while(i + go < N) {
				if(copy[i + go][j] == 0) {
					copy[i + go][j] = -1;
					++go;
				} else if(copy[i + go][j] == 6) {
					break;
				} else ++go;
			}
			break;
		case 3:
			while(j - go > -1) {
				if(copy[i][j - go] == 0) {
					copy[i][j - go] = -1;
					++go;
				} else if(copy[i][j - go] == 6) {
					break;
				} else ++go;
			}
			break;
		case 1:
			while(j + go < M) {
				if(copy[i][j + go] == 0) {
					copy[i][j + go] = -1;
					++go;
				} else if(copy[i][j + go] == 6) {
					break;
				} else ++go;
			}
			break;
		}
	}

}
