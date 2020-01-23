	package ST190808;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main_2606_바이러스 {
		
		static boolean[][] C_C= null;
	 	static boolean[] visited;
	 	static int C_N;
	 	
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			C_N = Integer.parseInt(br.readLine());
			C_C = new boolean[C_N + 1][C_N + 1];
			visited = new boolean[C_N + 1];
			int L = Integer.parseInt(br.readLine());
			for (int i = 0; i < L; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				C_C[p1][p2] = true;
				C_C[p2][p1] = true;
			}
			gogo(1);
			int result = 0;
			for (int i = 0; i <= C_N; i++) {
				if(visited[i]) result++;
			}
			System.out.println(result - 1);
		}
		
		static void gogo(int start) {
			visited[start] = true;
			for (int i = 1; i <= C_N; i++) {
				if((!visited[i]) && C_C[start][i]) gogo(i);
			}
		}
		
	}
