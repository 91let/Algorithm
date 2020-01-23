package ST190808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1726_로봇_극한다이어트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int q[] = new int[40000];
		int qs = -1;
		int qe = -1;
		
		int[][] MAP = new int[M + 2][N + 2];
		int[] DMR = {0, 0, 0, 1, -1};
		int[] DMC = {0, 1, -1, 0, 0};

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				MAP[i][j] = (Integer.parseInt(st.nextToken())) ^ 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		
		int eR = Integer.parseInt(st.nextToken());
		int eC = Integer.parseInt(st.nextToken());
		int eD = Integer.parseInt(st.nextToken()) - 1;
		int eCount;
		
		int e = eR | (eC << 7) | (eD << 14);

		st = new StringTokenizer(br.readLine());
		int goalR = Integer.parseInt(st.nextToken());
		int goalC = Integer.parseInt(st.nextToken());
		int goalD = Integer.parseInt(st.nextToken());

		q[++qe] = e;
		
		MAP[eR][eC] = MAP[eR][eC] | 1 << (eD+1);
		
		int eRT, eCT;
		
		while(true) {
			e = q[++qs];
			eRT = eR = e % 128;
			eCT = eC = (e >> 7) % 128;
			eD = ((e >> 14) % 4) + 1;
			eCount = e >> 16;
			if(eR == goalR && eC == goalC && eD == goalD) {
				System.out.println(eCount);
				break;
			}else {
				eCount = ++eCount << 16;
				for (int i = 1; i < 4 && MAP[eRT + DMR[eD]][eCT + DMC[eD]] != 0; i++) {
					eRT += DMR[eD];
					eCT += DMC[eD];
					if((MAP[eRT][eCT] & (1 << eD)) == 0) {
						MAP[eRT][eCT] |= 1 << eD;
						q[++qe] = eRT | (eCT << 7) | ((eD - 1) << 14) | eCount;
					}
				}
				switch (eD) {
				case 1:
				case 2:
					if((MAP[eR][eC] & 8) == 0) {
						MAP[eR][eC] |= 8;
						q[++qe] = eR | (eC << 7) | 32768 | eCount;
					}
					if((MAP[eR][eC] & 16) == 0) {
						MAP[eR][eC] |= 16;
						q[++qe] = eR | (eC << 7) | 49152 | eCount;
					}
					break;
				case 3:
				case 4:
					if((MAP[eR][eC] & 2) == 0) {
						MAP[eR][eC] |= 2;
						q[++qe] = eR | (eC << 7) | eCount;
					}
					if((MAP[eR][eC] & 4) == 0) {
						MAP[eR][eC] |= 4;
						q[++qe] = eR | (eC << 7) | 16384 | eCount;
					}
					break;
				}
			}
		}
	}

}
