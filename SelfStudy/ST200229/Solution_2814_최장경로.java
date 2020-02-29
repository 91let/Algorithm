package ST200229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2814_최장경로 {
	
	private static boolean[] visited;
	private static boolean[][] map;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N];
			map = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1, to = Integer.parseInt(st.nextToken()) - 1;
				map[from][to] = true;
				map[to][from] = true;
			}
			sb.append('#').append(++t).append(' ').append(Go()).append('\n');
		}
		System.out.print(sb);
	}

	private static int Go() {
		int max = 0;
		for (int start = 0; start < N; start++) {
			max = Math.max(max, Go2(start));
		}
		return max;
	}

	private static int Go2(int start) {
		visited[start] = true;
		int value = 0;
		for (int i = 0; i < N; i++) {
			if(map[start][i] && !visited[i]) value = Math.max(value, Go2(i));
		}
		visited[start] = false;
		return value + 1;
	}
	
}
