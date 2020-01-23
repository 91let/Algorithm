package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		//count y x
		int x = 0;
		int y = 0;
		int count = 0;
		
		int[] q = new int[N*M];
		--map[0][0];
		int qs = -1;
		int qe = 0;
		
		q[qe] = 0;
		
		while(x !=  M - 1 || y != N - 1) {
			x = q[++qs] % 100;
			y = q[qs] / 100 % 100;
			count = q[qs] / 10000 + 1;
			for (int d = 0; d < 4; d++) {
				if(y+dy[d] > -1 && y+dy[d] < N && x+dx[d] > -1 && x+dx[d] < M && map[y+dy[d]][x+dx[d]] == '1') {
					--(map[y+dy[d]][x+dx[d]]);
					q[++qe] = count * 10000 + (y+dy[d]) * 100 + x+dx[d];
				}
			}
		}
		
		System.out.println(count);
	}

}
