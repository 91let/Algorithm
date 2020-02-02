package ST200202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {

	final static private int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 }; // N, E, S, W

	static int[][] map;
	
	static private class Robot {
		private int num, x, y, dir;

		public Robot(int num, int x, int y, char dir) {
			this.num = num;
			this.x = x;
			this.y = y;
			switch (dir) {
			case 'N':
				this.dir = 0;
				break;
			case 'E':
				this.dir = 1;
				break;
			case 'S':
				this.dir = 2;
				break;
			case 'W':
				this.dir = 3;
				break;
			}
			map[y][x] = num;
		}

		public boolean move(char order, int loop) {
			switch (order) {
			case 'F':
				map[y][x] = 0;
				for (int i = 0; i < loop; i++) {
					y += dy[dir];
					x += dx[dir];
					if(map[y][x] != 0) {
						if(map[y][x] == -1) {
							System.out.println("Robot " + num + " crashes into the wall");
						}else {
							System.out.println("Robot " + num + " crashes into robot " + map[y][x]);
						}
						return false;
					}
				}
				map[y][x] = num;
				break;
			case 'R':
				this.dir = (dir + loop) % 4;
				break;
			case 'L':
				this.dir = (this.dir + (3 * loop)) % 4;
				break;
			}
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) + 2, B = Integer.parseInt(st.nextToken()) + 2;
		map = new int[B][A];
		boolean able = true;
		for (int i = 0; i < A; i++) {
			map[0][i] = map[B - 1][i] = -1;
		}
		for (int i = 0; i < B; i++) {
			map[i][0] = map[i][A - 1] = -1;
		}
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1, M = Integer.parseInt(st.nextToken());
		Robot[] robots = new Robot[N];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			robots[i] = new Robot(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (able) able = robots[Integer.parseInt(st.nextToken())].move(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
		}
		if(able) System.out.println("OK");
	}

}
