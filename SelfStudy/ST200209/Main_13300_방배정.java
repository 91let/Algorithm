package ST200209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), Ans = 0;
		int[] R = new int[13];
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 ++R[Integer.parseInt(st.nextToken())* 6 + Integer.parseInt(st.nextToken())];
		}
		for (int i = 1; i < 13; i++) {
			Ans += (R[i] % K != 0) ? R[i] / K + 1: R[i] / K;
		}
		System.out.println(Ans);
	}

}
