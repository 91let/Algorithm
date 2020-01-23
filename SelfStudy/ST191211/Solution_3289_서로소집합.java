package ST191211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {

	static int[] sets;

	static int setting(int a) {
		if (sets[a] != 0) {
			return sets[a] = setting(sets[a]);
		}
		else return a;
	}

	static boolean check(int a, int b) {
		return setting(a) != setting(b);
	}

	static void union_set(int a, int b) {
		if (check(a, b)) sets[setting(b)] = setting(a);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0, n, m;
		while (t < T) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sets = new int[n + 1];
			sb.append('#').append(++t).append(' ');
			while (m-- != 0) {
				st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) != 0) sb.append(check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ? 0: 1);
				else union_set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
