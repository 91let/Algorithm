package ST190925_undo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8568_3으로나눈순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()) + 1, t = 0;
		while(++t<T) {
			int[][] M = new int[3][3];
			int N = Integer.parseInt(br.readLine()) + 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N; i++) {
				int E = Integer.parseInt(st.nextToken()) % 3;
				if(E != i % 3) ++M[i % 3][E];
			}
			
			int count = 0;
			int n01 = Math.min(M[0][1], M[1][0]);
			int n02 = Math.min(M[0][2], M[2][0]);
			int n12 = Math.min(M[1][2], M[2][1]);
			count += n01 + n02 + n12;
			M[0][1] -= n01;
			M[1][0] -= n01;
			M[0][2] -= n02;
			M[2][0] -= n02;
			M[1][2] -= n12;
			M[2][1] -= n12;
			count += (M[0][1] + M[1][0] + M[0][2] + M[2][0] + M[1][2] + M[2][1]) / 3 * 2;
			sb.append('#').append(t).append(' ').append(count).append('\n');
		}
		System.out.println(sb);
	}

}
