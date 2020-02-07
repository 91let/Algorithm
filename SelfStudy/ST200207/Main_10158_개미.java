package ST200207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		System.out.println(calc(t, w, p) + " " + calc(t, h, q));
	}

	private static int calc(int t, int m, int a) {
		int ans = (t + a) % (2 * m);
		if(ans > m) ans = 2 * m - ans;
		return ans;
	}

}
