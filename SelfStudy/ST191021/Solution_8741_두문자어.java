package ST191021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8741_두문자어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append('#').append(++t).append(' ').append((char)(st.nextToken().charAt(0) - 32)).append((char)(st.nextToken().charAt(0) - 32)).append((char)(st.nextToken().charAt(0) - 32)).append('\n');
		}
		System.out.println(sb);
	}

}
