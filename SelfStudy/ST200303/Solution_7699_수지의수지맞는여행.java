package ST200303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {

	private final static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	private static int R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 0, T = Integer.parseInt(br.readLine());
		while(t < T) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			String[] map = new String[R];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine();
			}
			sb.append('#').append(++t).append(' ').append(go(map, 0, 0, 1 << (map[0].charAt(0) - 'A'), 1)).append('\n');
		}
		System.out.print(sb);
	}

	private static int go(String[] map, int i, int j, int AlphaCheck, int count) {
		if(count == 26) return 26;
		int max = count;
		for (int d = 0; d < 4; d++) {
			int tr = i + dr[d], tc = j + dc[d];
			if(tr > -1 && tr < R && tc > -1 && tc < C && (((AlphaCheck >> (map[tr].charAt(tc) - 'A')) & 1) == 0) && max != 26) {
				max = Math.max(max, go(map, tr, tc, AlphaCheck | 1 << (map[tr].charAt(tc) - 'A'), count + 1));
			}
		}
		return max;
	}

}
