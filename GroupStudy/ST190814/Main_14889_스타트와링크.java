package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int[][] status;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		status = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(getC(0, 0, 0));
	}

	private static int getC(int index, int peek, int checksum) {
		int min = 999999;
		if(peek == N/2) {
			int[] t1 = new int[N/2];
			int[] t2 = new int[N/2];
			int t1c = 0;
			int t2c = 0;
			int t1sum = 0;
			int t2sum = 0;
			for (int i = 0; i < N; i++) {
				if ((checksum&(1<<i)) == 0) {
					t2[t2c++] = i;
				}
				else {
					t1[t1c++] = i;
				}
			}
			for (int s = 0; s < N/2; s++) {
				for (int e = 0; e < N/2; e++) {
					t1sum += status[t1[s]][t1[e]];
					t2sum += status[t2[s]][t2[e]];
				}
			}
			return Math.abs(t1sum - t2sum);
		}
		for (int i = index; i < N; i++) {
			int tmp = getC(i + 1, peek + 1, checksum|1<<i);
			if(tmp < min) {
				min = tmp;
			}
		}
		System.out.println(min);
		return min;
	}

}
