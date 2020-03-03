package ST200303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()), sy = Integer.parseInt(st.nextToken()), ex = Integer.parseInt(st.nextToken()), ey = Integer.parseInt(st.nextToken());
			int x = Math.abs(ex - sx), y = Math.abs(ey - sy);
			int ans = 0;
			if(x < y) {
				if(y % 2 == x % 2) ans = y + y;
				else ans = y + y - 1;
			}else {
				if(y % 2 == x % 2) ans = x + x;
				else ans = x + x - 1;
			}
			sb.append('#').append(++t).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}

}
