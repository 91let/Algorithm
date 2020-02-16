package ST200216;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8911_거북이 {

	public static void main(String[] args) throws Exception {
		final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(--T != -1) {
			String order = br.readLine();
			int dir = 0, maxR = 0, minR = 0, maxC = 0, minC = 0, nowR = 0, nowC = 0, orderLen = order.length();
			for (int i = 0; i < orderLen; i++) {
				switch (order.charAt(i)) {
				case 'F':
					nowR += dr[dir];
					nowC += dc[dir];
					maxR = Math.max(maxR, nowR);
					maxC = Math.max(maxC, nowC);
					minR = Math.min(minR, nowR);
					minC = Math.min(minC, nowC);
					break;
				case 'B':
					nowR -= dr[dir];
					nowC -= dc[dir];
					maxR = Math.max(maxR, nowR);
					maxC = Math.max(maxC, nowC);
					minR = Math.min(minR, nowR);
					minC = Math.min(minC, nowC);
					break;
				case 'L':
					dir = (3 + dir) % 4;
					break;
				case 'R':
					dir = ++dir % 4;
					break;
				}
			}
			sb.append((maxR - minR) * (maxC - minC)).append('\n');
		}
		System.out.println(sb);
	}

}
