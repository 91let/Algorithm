package ST200119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18233_러버덕을사랑하는모임 {

	static int N, P, E;
	static int[][] LM;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		LM = new int[N][2];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			LM[i][0] = Integer.parseInt(st.nextToken());
			LM[i][1] = Integer.parseInt(st.nextToken());
		}
		pick(-1, 0);
		System.out.println(-1);
	}

	private static void pick(int last_num, int count) {
		if(count == P) {
			range_check();
		}
		else if(N - last_num > P - count) {
			for (int i = last_num + 1; i < N; i++) {
				check[i] = true;
				pick(i, count + 1);
				check[i] = false;
			}
		}
		return;
	}

	private static void range_check() {
		int min = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				min += LM[i][0];
				max += LM[i][1];
			}
		}
		if(min > E || max < E) return;
		StringBuilder sb = new StringBuilder();
		int[] Ans = new int[N];
		int rest = E;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				Ans[i] += LM[i][0];
				rest -= LM[i][0];
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				if(LM[i][1] - LM[i][0] < rest){
					Ans[i] += LM[i][1] - LM[i][0];
					rest -= LM[i][1] - LM[i][0];
				}else {
					Ans[i] += rest;
					break;
				}
			}
		}
		
		sb.append(Ans[0]);
		for (int i = 1; i < N; i++) {
			sb.append(' ').append(Ans[i]);
		}
		
		System.out.println(sb);
		System.exit(0);
	}

}
