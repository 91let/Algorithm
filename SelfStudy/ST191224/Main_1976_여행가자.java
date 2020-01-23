package ST191224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {

	static int N, M;
	static boolean[] con;
	static String[] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		con = new boolean[N];
		map = new String[N];
		boolean able = true;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		st = new StringTokenizer(br.readLine());
		go(Integer.parseInt(st.nextToken()) - 1);
		for (int i = 1; i < M; i++) {
			if(con[Integer.parseInt(st.nextToken()) - 1]) continue;
			able = false;
			break;
		}
		if(able) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void go(int in) {
		con[in] = true;
		for (int i = 0; i < N; i++) {
			if(map[in].charAt(i * 2) == '1' && !con[i]) {
				go(i);
			}
		}
	}

}
