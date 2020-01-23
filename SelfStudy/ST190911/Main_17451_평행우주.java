package ST190911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17451_평행우주 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] P = new long[N];
		for (int i = 0; i < N; i++) {
			P[i] = (Long.parseLong(st.nextToken()));
		}
		long A = P[N - 1];
		for (int i = N - 2; i > -1; --i) {
			if(A % P[i] != 0) A = P[i] * (A / P[i] + 1);
		}
		System.out.println(A);
	}

}
