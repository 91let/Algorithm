package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][N];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int xs = Integer.parseInt(st.nextToken());
			int ys = Integer.parseInt(st.nextToken());
			int xe = Integer.parseInt(st.nextToken());
			int ye = Integer.parseInt(st.nextToken());
			for (int y = ys; y < ye; y++) {
				for (int x = xs; x < xe; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		int[] dy = {0, 0, -1, 1};
		int[] dx = {-1, 1, 0, 0};
		
		int[] qy = new int[M*N];
		int[] qx = new int[M*N];
		int[] areas = new int[M*N];
		int qs = -1;
		int qe = -1;
		int ac = -1;
		int count = 0;
		int tx, ty;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					++map[i][j];
					++areas[++ac];
					++count;
					qy[++qe] = i;
					qx[qe] = j;
					while(qe!=qs) {
						ty = qy[++qs];
						tx = qx[qs];
						for (int d = 0; d < 4; d++) {
							if(ty + dy[d] > -1 && ty + dy[d] < M && tx + dx[d] > -1 && tx + dx[d] < N && map[ty + dy[d]][tx + dx[d]] == 0) {
								map[ty + dy[d]][tx + dx[d]] = 1;
								++areas[ac];
								qy[++qe] = ty + dy[d];
								qx[qe] = tx + dx[d];								
							}
						}
					}
				}
			}
		}
		sb.append(count).append("\n");
		areas = Arrays.copyOf(areas, ac+1);
		Arrays.sort(areas);
		for (int i : areas) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
