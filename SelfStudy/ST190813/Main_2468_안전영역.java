package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()) + 2;
		Queue<Integer> q= new LinkedList<Integer>();
		int[][] map = new int[N][N--];
		int[] xd = {0, 0, -1, 1};
		int[] yd = {1, -1, 0, 0};
		int max = 1;
		int count;
		int tmp;
		int x;
		int y;
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 100; r >= 0 ; r--) {
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > r) {
						++count;
						--map[i][j];
						q.offer(i*10000 + j);
					}
					while(!q.isEmpty()) {
						tmp = q.poll();
						x = tmp % 10000;
						y = tmp / 10000;
						for (int d = 0; d < 4; d++) {
							if(map[y+yd[d]][x+xd[d]] > r) {
								--map[y+yd[d]][x+xd[d]];
								q.offer((y+yd[d]) * 10000 + x+xd[d]);
							}
						}
					}
				}
			}
			if(max < count)	max = count;
			show(map,N);
			System.out.println(r + " " + count);
		}
		
		System.out.println(max);
		
	}

	private static void show(int[][] map, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	

}
