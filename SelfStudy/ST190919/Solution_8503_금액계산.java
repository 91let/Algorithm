package ST190919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8503_금액계산 {
	static long[] C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()) + 1;
		for (int t = 1; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long S = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = new long[N];
			for (int i = 0; i < N; i++) C[i] = Long.parseLong(st.nextToken());
			sb.append("#").append(t).append(" ").append(F(S, N - 1)).append("\n");
		}
		System.out.print(sb);
	}

	private static long F(long s, int i) {
		if(i < 2) return (s/C[1] + 1) % 1000000007;
		long n = s/C[i];
		if(n > 1000000007) {
			n %= 1000000007;
			s = n * C[i];
		}
		long sum = 0;
		while(n > -1) {
			sum += F(s - (C[i] * n), i - 1);
			--n;
		}
		return sum % 1000000007;
	}

}

/**
4
3 12
1 2 6
3 6
1 2 6
3 8
1 2 4
3 4
1 2 4
#1 12
#2 5
#3 9
#4 4


126
6	12	18	24	30	36
5	12	22	35	51	70
4	7	10	13	16	19
	3	3	3	3	3
124
4	8	12	16
4	9	16	25
3	5	7	9
	2	2	2
139
9	18	27	36	45	54	63	72	81
5	12	22	35	51	70	92	117	145
4	7	10	13	16	19	22	25	28
	3	3	3	3	3	3	3	3
*/
/*
1248
8	16	24	32	40	48	56	64
10	35	84	165	286	455	680	969
9	25	49	81	121	169	225	289
8	16	24	32	40	48	56	64
	8	8	8	8	8	8	8
*/