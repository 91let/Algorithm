package ST191029;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1300_K번째수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//, K = sc.nextInt();
		int[] Array = new int[N * N];
		int[] Array2 = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Array[i * N + j] = (i + 1) * (j + 1);
				Array2[i * N + j] = (i) * N + (j + 1);
			}
		}
		Arrays.sort(Array);
		Arrays.sort(Array2);
		for (int i = N * N - 1; i != 0; i--) {
			System.out.println(Array[i] + " " + Array2[i]);
		}
	}

}
