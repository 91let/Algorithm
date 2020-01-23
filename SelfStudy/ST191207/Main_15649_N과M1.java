package ST191207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, nums[] = new int[8];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P(0, 0);
		System.out.print(sb);
	}

	private static void P(int array_point, int checker) {
		if(array_point < M) {
			for (int i = 1; i < N + 1; i++) {
				if((checker >> i & 1) != 1) {
					nums[array_point] = i;
					P(array_point + 1, checker | 1 << i);
				}
			}
		}else {
			for (int i = 0; i < M - 1; i++) {
				sb.append(nums[i]).append(' ');
			}
			sb.append(nums[M - 1]).append('\n');
		}
	}

}
