package ST190902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {

	static int N, M, H;
	static boolean[][] L;
	static int Nums[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int count = 4;
		
		Nums = new int[N];
		int n = 0;
		for (int i = 0; i < N; i++) {
			Nums[i] = ++n;
		}
		
		L = new boolean[H][N - 1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			L[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		
		if(godown()) {
			count = 0;
		}
		else {
			for (int i = 0; i < H * (N - 1); i++) {
				if(L[i/(N - 1)][i%(N - 1)]) continue;
				if(i%(N - 1) > 0 && L[i/(N - 1)][(i - 1)%(N - 1)]) continue;
				if(i%(N - 1) < (N - 2) && L[i/(N - 1)][(i + 1)%(N - 1)]) continue;
				L[i/(N - 1)][i%(N - 1)] = true;
				if(godown()) {
					count = 1;
				}
				else {
					for (int j = i + 1; j < H * (N - 1); j++) {
						if(L[j/(N - 1)][j%(N - 1)]) continue;
						if(j%(N - 1) > 0 && L[j/(N - 1)][(j - 1)%(N - 1)]) continue;
						if(j%(N - 1) < (N - 2) && L[j/(N - 1)][(j + 1)%(N - 1)]) continue;
						L[j/(N - 1)][j%(N - 1)] = true;
						if(godown()) {
							count = Math.min(count, 2);
						}
						else{
							for (int k = j + 1; k < H * (N - 1); k++) {
								if(L[k/(N - 1)][k%(N - 1)]) continue;
								if(k%(N - 1) > 0 && L[k/(N - 1)][(k - 1)%(N - 1)]) continue;
								if(k%(N - 1) < (N - 2) && L[k/(N - 1)][(k + 1)%(N - 1)]) continue;
								L[k/(N - 1)][k%(N - 1)] = true;
								if(godown()) {
									count = Math.min(count, 3);
								}
								L[k/(N - 1)][k%(N - 1)] = false;
							}
						}
						L[j/(N - 1)][j%(N - 1)] = false;
					}
				}
				
				L[i/(N - 1)][i%(N - 1)] = false;
			}
		}
		if(count == 4) {
			count = -1;
		}
		System.out.println(count);
		
	}
	
	private static boolean godown() {
		int tmpN[] = Nums.clone();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {
				if(L[i][j]) {
					int tmp = tmpN[j];
					tmpN[j] = tmpN[j + 1];
					tmpN[j + 1] = tmp;
				}
			}
		}
		
		boolean check = true;
		for (int i = 0; i < N - 1; i++) {
			if(tmpN[i] > tmpN[i + 1]) check = false;
		}
		return check;
	}

}
