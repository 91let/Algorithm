package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

//	static class Alpha{
//		int x, y, check, count;
//		public Alpha() { }
//		public Alpha(int x, int y, int check, int count) {
//			this();
//			this.x = x;
//			this.y = y;
//			this.check = check;
//			this.count = count;
//		}
//		@Override
//		public String toString() {
//			return "Alpha [x=" + x + ", y=" + y + ", check=" + check + ", count=" + count + "]";
//		}
//	}
	
	static char[][] map;
	static int R;
	static int C;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0,0, 1<<(map[0][0] - 'A'), 1);
		System.out.println(max);
		
//		Queue<Alpha> q = new LinkedList<Alpha>();
//		Alpha t = new Alpha(0, 0, 1<<(map[0][0] - 'A'), 1);
//		q.offer(t);
//		while(!q.isEmpty()) {
//			t = q.poll();
//			for (int i = 0; i < 4; i++) {
//				if(t.x+dx[i] > -1 && t.x+dx[i] < C && t.y+dy[i] > -1 && t.y+dy[i] < R && ((t.check&1<<(map[t.y+dy[i]][t.x+dx[i]] - 'A'))==0)) {
//					q.offer(new Alpha(t.x+dx[i],t.y+dy[i],t.check|1<<(map[t.y+dy[i]][t.x+dx[i]] - 'A'),t.count + 1));
//				}
//			}
//		}
//		System.out.println(t.count);
	}

	private static void dfs(int x, int y, int check, int count) {
		if(max < count) max = count;
		for (int i = 0; i < 4; i++) {
			if(x+dx[i] > -1 && x+dx[i] < C && y+dy[i] > -1 && y+dy[i] < R && ((check&1<<(map[y+dy[i]][x+dx[i]] - 'A'))==0)) {
				dfs(x+dx[i],y+dy[i],check|1<<(map[y+dy[i]][x+dx[i]] - 'A'),count + 1);
			}
		}
	}

}
