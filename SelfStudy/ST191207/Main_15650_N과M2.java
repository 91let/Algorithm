package ST191207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, nums[] = new int[8];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C(0, 0);
		System.out.print(sb);
	}

	private static void C(int array_point, int last) {
		if(array_point < M) {
			for (int i = last + 1, j = N - M + array_point + 2; i < j; i++) {
				nums[array_point] = i;
				C(array_point + 1, i);
			}
		}else {
			for (int i = 0; i < M - 1; i++) {
				sb.append(nums[i]).append(' ');
			}
			sb.append(nums[M - 1]).append('\n');
		}
	}

}
