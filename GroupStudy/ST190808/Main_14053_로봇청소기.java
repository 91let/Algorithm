package ST190808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14053_로봇청소기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] DMAP = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		
		int[][] MAP = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int RR = Integer.parseInt(st.nextToken());
		int RC = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean moved;
		int cleared = 0;
		while (true) {
			if (MAP[RR][RC] == 0) {
				cleared++;
				MAP[RR][RC] = 2;
			}
			moved = false;
			for (int i = 0; i < 4; i++) {
				D = (D + 3) % 4;
				if (MAP[RR + DMAP[D][0]][RC + DMAP[D][1]] == 0) {
					RR += DMAP[D][0];
					RC += DMAP[D][1];
					moved = true;
					break;
				}
			}
			if (!moved) {
				if (MAP[RR + DMAP[(D + 2) % 4][0]][RC + DMAP[(D + 2) % 4][1]] != 1) {
					RR += DMAP[(D + 2) % 4][0];
					RC += DMAP[(D + 2) % 4][1];
				} else if (MAP[RR + DMAP[(D + 2) % 4][0]][RC + DMAP[(D + 2) % 4][1]] == 1) {
					break;
				}
			}
		}

		System.out.println(cleared);

	}

}
