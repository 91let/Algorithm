package ST190819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17147_낚시왕 {

	public static class Shark{
		int s,d,z;
		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Shark[][] map = new Shark[100][100];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int score = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				if (map[i][j] !=  null) {
					score += map[i][j].z;
					map[i][j] = null;
					break;
				}
			}
			Shark[][] tmap = new Shark[100][100];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] != null) {
						int tr = r;
						int tc = c;
						int ts = map[r][c].s;
						for (int i = 0; i < ts; i++) {
							switch (map[r][c].d) {
							case 1:
								if(tr == 0) {
									map[r][c].d = 2;
									tr++;
								}
								else tr--;
								break;
							case 2:
								if(tr == R - 1) {
									map[r][c].d = 1;
									tr--;
								}
								else tr++;
								break;
							case 3:
								if(tc == C - 1) {
									map[r][c].d = 4;
									tc--;
								}
								else tc++;
								break;
							case 4:
								if(tc == 0) {
									map[r][c].d = 3;
									tc++;
								}
								else tc--;
								break;
							}
						}
						if(tmap[tr][tc] == null) {
							tmap[tr][tc] = map[r][c];
						}
						else {
							if(tmap[tr][tc].z < map[r][c].z) {
								tmap[tr][tc] = map[r][c];
							}
						}
					}
				}
			}
			map = tmap;
		}
		System.out.println(score);
	}

}
