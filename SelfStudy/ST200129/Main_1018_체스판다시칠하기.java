package ST200129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {

	static int Ans;
	static String[] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()) - 7;
		Ans = Integer.MAX_VALUE;
		map = new String[N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		N -= 7;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check(i, j);
			}
		}
		System.out.println(Ans);
	}

	private static void check(int row, int col) {
		int needToChange1 = 0;
		int needToChange2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if((i + j) % 2 == 0 && map[i + row].charAt(j + col) == 'B') ++needToChange1;
				else if((i + j) % 2 == 1 && map[i + row].charAt(j + col) == 'W') ++needToChange1;
				else ++needToChange2;
			}
		}
		Ans = Math.min(Ans, Math.min(needToChange1, needToChange2));
	}

}
