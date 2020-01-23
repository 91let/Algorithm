package ST191001;

import java.util.Scanner;

public class Main_1654_랜선자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(), N = sc.nextInt();
		long[] len = new long[K];
		long max = 0, left = 0, right = Long.MAX_VALUE;
		for (int i = 0; i < K; i++) len[i] = sc.nextLong();
		while (left <= right){
			long mid = (left + right) / 2;
			int result = 0;
			for (int i = 0; i < K; i++) result += len[i] / mid;
			if (result > N - 1) {
				left = mid + 1;
				max = Math.max(max, mid);
			} else right = mid - 1;
		}
		System.out.println(max);
		sc.close();
	}
}
