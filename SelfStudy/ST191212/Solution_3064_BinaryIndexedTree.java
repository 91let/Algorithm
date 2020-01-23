package ST191212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3064_BinaryIndexedTree {

	static int[] Tree;
	
	private static void update(int i, int num, int N) {
		while(i < N) {
			Tree[i] += num;
	        i += (i & -i);
		}
	}

	private static int sum(int i) {
	    int ans = 0;
	    while (i > 0) {
	        ans += Tree[i];
	        i -= (i & -i);
	    }
	    return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			sb.append('#').append(++t);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()) + 1, M = Integer.parseInt(st.nextToken());
			Tree = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N; i++)	update(i, Integer.parseInt(st.nextToken()), N);
			while(--M > -1) {
				st = new StringTokenizer(br.readLine());
				if(Integer.parseInt(st.nextToken()) != 2) {
					update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), N);
				}else {
					sb.append(' ').append(0 - sum(Integer.parseInt(st.nextToken()) - 1) + sum(Integer.parseInt(st.nextToken())));
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
