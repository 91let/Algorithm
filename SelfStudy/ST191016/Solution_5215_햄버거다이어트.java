package ST191016;

import java.util.Scanner;

public class Solution_5215_햄버거다이어트 {

	static int N, L, max;
	static int[] point;
	static int[] cal;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt() + 1;
			max = 0;
			point = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				point[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			eat(-1, 0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void eat(int lastindex, int cals, int points) {
		max = Math.max(max, points);
		for (int i = lastindex + 1; i < N; i++) {
			if(cals + cal[i] < L) eat(i, cals + cal[i], points + point[i]);
		}
	}
}
