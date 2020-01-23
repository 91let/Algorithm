package ST190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int I = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(st.nextToken());
		int[][] cheese = new int[I][J];
		
		int[] di = {0, 0, -1, 1};
		int[] dj = {-1, 1, 0, 0};
		
		for (int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < J; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int H = 0;
		int tmp, ti, tj;
		while(check(cheese, I , J)) {
			boolean[][] checker = new boolean[I][J];
			++H;
			Queue<Integer> q = new LinkedList<Integer>();
			lastCheese = 0;
			ti = 0;
			tj = 0;
			tmp = ti * 100 + tj;
			q.offer(tmp);
			checker[0][0] = true;
			while(!q.isEmpty()) {
				tmp = q.poll();
				ti = tmp / 100;
				tj = tmp % 100;
				for (int d = 0; d < 4; d++) {
					if(ti + di[d] > -1 && ti +di[d] < I && tj +dj[d] > -1 && tj + dj[d] < J && !checker[ti +di[d]][tj + dj[d]]) {
						if(cheese[ti +di[d]][tj + dj[d]] == 1) cheese[ti +di[d]][tj + dj[d]] = 2;
						if(cheese[ti +di[d]][tj + dj[d]] == 0) {
							q.offer((ti +di[d]) * 100 + tj + dj[d]);
							checker[ti +di[d]][tj + dj[d]] = true;
						}
					}
				}
			}
		}
		System.out.print(H + "\n" + lastCheese);
	}
	
	static int lastCheese = 0;

	private static boolean check(int[][] cheese, int I, int J) {
//		System.out.println();
//		for (int i = 0; i < I; i++) {
//			for (int j = 0; j < J; j++) {
//				System.out.print(cheese[i][j] + " ");
//			}
//			System.out.println();
//		}
		boolean result = false;
		
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if(cheese[i][j] == 2) {
					cheese[i][j] = 0;
					++lastCheese;
				}
				else if(cheese[i][j] == 1) result = true;
			}
		}
		return result;
	}

}