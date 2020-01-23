package ST190902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] map = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());
		
		int[] dy = {0, -1, 0, 1};
		int[] dx = {1, 0, -1, 0};
		int[] log;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			log = new int[1024];
			int log_num = 1;
			map[y][x] = true;
			y = y + dy[d];
			x = x + dx[d];
			map[y][x] = true;
			log[0] = d;
			for (int c = 1; c <= g; c++) {
				for (int l = 0; l < log_num; l++) {
					log[log_num + l] = (log[log_num - 1 - l] + 1) % 4;
					y = y + dy[log[log_num + l]];
					x = x + dx[log[log_num + l]];
					map[y][x] = true;
				}
				log_num *= 2;
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					++count;
				}
			}
		}
		System.out.println(count);
	}
	
}
