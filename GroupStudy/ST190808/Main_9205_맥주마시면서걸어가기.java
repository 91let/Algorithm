package ST190808;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {

	static int[][] CVs;
	static boolean[] visited;
	static int[] H = new int[2];
	static int[] G = new int[2];
	static boolean found;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for (int T = 0; T < test_case; T++) {
			int CV = Integer.parseInt(br.readLine());
			CVs = new int[CV][2];
			visited = new boolean[CV];
			st = new StringTokenizer(br.readLine());
			H[0] = Integer.parseInt(st.nextToken());
			H[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < CV; i++) {
				st = new StringTokenizer(br.readLine());
				CVs[i][0] = Integer.parseInt(st.nextToken());
				CVs[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			G[0] = Integer.parseInt(st.nextToken());
			G[1] = Integer.parseInt(st.nextToken());
			found = false;
			GOGO(G);
			if(found) 
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
	
	public static void GOGO(int[] start) {
		if(Math.abs(start[0] - H[0]) + Math.abs(start[1] - H[1]) < 1001) {
			found = true;
		}
		for (int i = 0; i < CVs.length; i++) {
			if(!visited[i]) {
				if(Math.abs(start[0] - CVs[i][0]) + Math.abs(start[1] - CVs[i][1]) < 1001) {
					visited[i] = true;
					GOGO(CVs[i]);
					//visited[i] = false;
				}
			}
		}
	}

}
