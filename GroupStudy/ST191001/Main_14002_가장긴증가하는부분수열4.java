package ST191001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] D = new int[N];
		int max = 0;
		int maxIdx = -1;

		for (int i = 0; i < N; i++) {
			D[i] = 1;
			for (int j = 0; j < N; j++) {
				if (nums[j] < nums[i] && D[j] + 1 > D[i]) {
					D[i] = D[j] + 1;

				}
			}
			if (max < D[i]) {
				max = D[i];
				maxIdx = i;
			}
		}

		int[] res = new int[max];
		int resIdx = max - 1;

		for (int i = maxIdx; i >= 0; i--) {
			if (D[i] == resIdx + 1) {
				res[resIdx--] = nums[i];
			}

			if (resIdx == -1)
				break;
		}

		System.out.println(max);
		for (int a : res)
			System.out.print(a + " ");
	}

}