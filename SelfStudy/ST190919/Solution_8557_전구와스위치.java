package ST190919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8557_전구와스위치 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()) + 1, t = 0;
		while (++t < T) {
			st = new StringTokenizer(br.readLine());
			double w = Double.parseDouble(st.nextToken()), on = 0.0;
			for (long i = Long.parseLong(st.nextToken()); i > 0; i /= 2, w *= (1 - w) * 2) if(i % 2 != 0) on = (1 - on) * w + on * (1 - w);
			sb.append('#').append(t).append(' ').append(on).append('\n');
		}
		System.out.println(sb);
	}
}
