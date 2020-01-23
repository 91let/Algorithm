package ST191204;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_8898_3차원농부 {
	
	private static class B_Result{
		public B_Result(boolean found, int result) {
			this.found = found;
			this.result = result;
		}
		boolean found;
		int result;
	}
	
	private static B_Result B_Search(int[] ori, int value) {
		int left = 0, right = ori.length - 1, mid = 0;
		if(ori[left] > value) return new B_Result(false, 0);
		if(ori[right] < value) return new B_Result(false, right + 1);
		while(!(left > right)) {
			mid = (left + right) / 2;
			if(value > ori[mid]) {
				left = mid + 1;
			} else if(value < ori[mid]) {
				right = mid - 1;
			} else {
				return new B_Result(true, mid);
			}
		}
		return new B_Result(false, left);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt(), t = 0, x1, x2, x_dis, N, M, cows[], horse, min, ori_min, point, count = 0, t_result;
		while(t < T) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			cows = new int[N];
			M = sc.nextInt();
			x1 = sc.nextInt();
			x2 = sc.nextInt();
			x_dis = (x1 < x2) ? x2 - x1 : x1 - x2;
			for (int i = 0; i < N; i++) cows[i] = sc.nextInt();
			Arrays.sort(cows);
			while(--M != -1) {
				horse = sc.nextInt();
				B_Result tmp = B_Search(cows, horse);
				if(tmp.found) {
					if(min != 0) {
						count = 0;
						min = 0;
					}
					++count;
				}else {
					if(tmp.result != 0) {
						t_result = horse - cows[tmp.result - 1];
						if(t_result < min) {
							count = 1;
							min = t_result;
						} else if(t_result == min) ++count;
					}
					if(tmp.result != N) {
						t_result = cows[tmp.result] - horse;
						if(t_result < min) {
							count = 1;
							min = t_result;
						} else if(t_result == min) ++count;
					}
				}
			}
			min += x_dis;
			sb.append('#').append(++t).append(' ').append(min).append(' ').append(count).append('\n');
		}
		System.out.print(sb);
		sc.close();
	}

}
