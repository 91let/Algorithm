package ST190918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()) + 1;
		int[] C = new int[N];
		for (int i = 0; i < N; ++i) C[i] = Integer.parseInt(br.readLine());
		Arrays.sort(C);
		int[] U = new int[K];
		for (int i = 1; i < K; ++i) {
			U[i] = Integer.MAX_VALUE;
			for (int j = N - 1; j > -1; --j) if(i - C[j] > -1 && U[i - C[j]] != Integer.MAX_VALUE) U[i] = Math.min(U[i], U[i - C[j]] + 1);
		}
		if(U[K - 1] != Integer.MAX_VALUE) System.out.println(U[K - 1]);
		else System.out.println(-1);
	}
}