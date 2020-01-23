package ST190808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Queue<Integer> Q = new LinkedList<Integer>();

		int[][] MAP = new int[M + 2][N + 2];
		int[][] DMAP = {{}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				MAP[i][j] = (Integer.parseInt(st.nextToken())) ^ 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		
		int eR = Integer.parseInt(st.nextToken());
		int eC = Integer.parseInt(st.nextToken());
		int eD = Integer.parseInt(st.nextToken());
		int eCount;
		
		int e = eR + (eC << 7) + (eD << 14);

		st = new StringTokenizer(br.readLine());
		int goalR = Integer.parseInt(st.nextToken());
		int goalC = Integer.parseInt(st.nextToken());
		int goalD = Integer.parseInt(st.nextToken());

		Q.offer(e);
		
//		System.out.println(e);
//		
//		eR = e % (1 << 7);
//		eC = (e >> 7) % (1 << 7);
//		eD = (e >> 14) % (1 << 3);
//		System.out.println(eR + " " + eC + " " + eD);
		
		while(true) {
			e = Q.poll();
			eR = e % (1 << 7);
			eC = (e >> 7) % (1 << 7);
			eD = (e >> 14) % (1 << 3);
			eCount = e >> 17;
//			if(maxQ < Q.size()) maxQ = Q.size();
//			System.out.println(maxQ);
//			System.out.println(Q.size());
//			System.out.println(Q.toString());
			if(eR == goalR && eC == goalC && eD == goalD) {
				System.out.println(eCount);
				break;
			}else {
				eCount++;
				MAP[eR][eC] = MAP[eR][eC] | 1 << eD;
				for (int i = 1; i < 4; i++) {
					if(MAP[eR + DMAP[eD][0] * i][eC + DMAP[eD][1] * i] == 0) break;
					else if((MAP[eR + DMAP[eD][0] * i][eC + DMAP[eD][1] * i] & (1 << eD)) == 0) {
						Q.offer((eR + DMAP[eD][0] * i) + ((eC + DMAP[eD][1] * i) << 7) + (eD << 14) + (eCount << 17));
					}
				}
				switch (eD) {
				case 1:
				case 2:
					if((MAP[eR][eC] & (1 << 3)) == 0) Q.offer(eR + (eC << 7) + (3 << 14) + (eCount << 17));
					if((MAP[eR][eC] & (1 << 4)) == 0) Q.offer(eR + (eC << 7) + (4 << 14) + (eCount << 17));
					break;
				case 3:
				case 4:
					if((MAP[eR][eC] & (1 << 1)) == 0) Q.offer(eR + (eC << 7) + (1 << 14) + (eCount << 17));
					if((MAP[eR][eC] & (1 << 2)) == 0) Q.offer(eR + (eC << 7) + (2 << 14) + (eCount << 17));
					break;

				default:
					break;
				}
			}
		}
	}

}
