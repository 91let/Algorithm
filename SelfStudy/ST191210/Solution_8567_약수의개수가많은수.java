package ST191210;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_8567_약수의개수가많은수 {

	final static int max_range = 100001;
	final static int div_range = 7;
	static int[] counts = new int[max_range];
	static int[] nums = new int[max_range];
	static int[] div_nums = {2, 3, 5, 7, 11, 13, 17};
	static int[] div_counts = new int[div_range];
	
	public static void main(String[] args) throws Exception {
		get();
		int max_count = 1, max_num = 1;
		for (int i = 1; i < max_range; i++) {
			if(counts[i] < max_count) {
				nums[i] = max_num;
			}else {
				max_count = counts[i];
				nums[i] = max_num = i;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			sb.append('#').append(++t).append(' ').append(nums[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb);
	}

	private static void get() {
		int now = 1, val = 1;
		for (int i = 0; i < div_range; i++) {
			now *= Math.pow(div_nums[i], div_counts[i]);
		}
		for (int i = 0; i < div_range; i++) {
			val *= div_counts[i] + 1;
		}
		counts[now] = val;
		for (int i = 0; i < div_range; i++) {
			if(now * div_nums[i] > max_range - 1) return;
			if(counts[now * div_nums[i]] != 0) continue;
			++div_counts[i];
			get();
			--div_counts[i];
		}
	}

}
