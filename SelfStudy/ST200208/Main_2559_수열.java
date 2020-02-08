package ST200208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), period = 0, ans;
		st = new StringTokenizer(br.readLine());
		int[] tmp = new int[N];
		for (int i = 0; i < K; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
			period += tmp[i];
		}
		ans = period;
		for (int i = K; i < N; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
			period += tmp[i] - tmp[i - K];
			ans = Math.max(ans, period);
		}
		System.out.println(ans);
	}

}
