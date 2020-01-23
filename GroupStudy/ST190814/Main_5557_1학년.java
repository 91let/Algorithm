package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		long[][] calc = new long[C][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		calc[0][Integer.parseInt(st.nextToken())] = 1;
		for (int i = 0; i < C - 2; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 21; j++) {
				if(j - tmp > -1) {
					calc[i + 1][j - tmp] += calc[i][j];
				}
				if(j + tmp < 21) {
					calc[i + 1][j + tmp] += calc[i][j];
				}
			}
		}
		System.out.println(calc[C - 2][Integer.parseInt(st.nextToken())]);
	}

}
