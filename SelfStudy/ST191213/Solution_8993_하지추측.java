package ST191213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_8993_하지추측 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			long N = Long.parseLong(br.readLine());
			if((N & -N) != N) sb.append('#').append(++t).append(' ').append("NO").append('\n');
			else sb.append('#').append(++t).append(' ').append("YES").append('\n');
		}
		System.out.println(sb);
	}

}
