package ST200125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1756_피자굽기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()) + 1, N = Integer.parseInt(st.nextToken()), last = D, Ans = 0;
		int[] oven = new int[D];
		st = new StringTokenizer(br.readLine());
		oven[0] = Integer.MAX_VALUE;
		for (int i = 1; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if(oven[i] > oven[i - 1]) oven[i] = oven[i - 1];
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int P = Integer.parseInt(st.nextToken());
			while(last != 0) {
				if(oven[--last] < P) continue;
				else {
					Ans = last;
					break;
				}
			}
		}
		System.out.println(Ans);
		
	}

}
