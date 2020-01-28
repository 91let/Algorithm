package ST200127;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6549_히스토그램에서가장큰직사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long[] stack_h = new long[100000];
		long[] stack_p = new long[100000];
		int stack_top = -1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long max = 0;
			if(n == 0) break;
			for (int i = 0; i < n; i++) {
				long h = Long.parseLong(st.nextToken()), t_p = i;
				while(stack_top != -1 && stack_h[stack_top] > h) {
					t_p = stack_p[stack_top];
					max = Math.max(max, stack_h[stack_top] * (i - stack_p[stack_top--]));
				}
				if(stack_top < 0 || stack_h[stack_top] < h) {
					stack_h[++stack_top] = h;
					stack_p[stack_top] = t_p;
				}
			}
			while(stack_top != -1) {
				max = Math.max(max, stack_h[stack_top] * (n - stack_p[stack_top--]));
			}
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}

}