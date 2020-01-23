package ST190828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_원자소멸시뮬레이션 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> Atoms = new LinkedList<Integer>();
			LinkedList<Long> Collisions;
//			int[] Collisions;
			int Energy = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Atoms.add((Integer.parseInt(st.nextToken()) + 1000)
						+ (Integer.parseInt(st.nextToken()) + 1000) * (1 << 11)
						+ Integer.parseInt(st.nextToken()) * (1 << 22) + Integer.parseInt(st.nextToken()) * (1 << 24));
				// 에너지 , 방향, y, x
			}
			while (!Atoms.isEmpty()) {
//				Collisions = new int[1000000];
				Collisions = new LinkedList<Long>();
//				int cIndex = 0;
				boolean[] crash = new boolean[Atoms.size()];
				boolean[] realCrash = new boolean[Atoms.size()];
				int[] deleteList = new int[Atoms.size()];
				for (int d = 0; d < Atoms.size(); d++) {
					deleteList[d] = -1;
				}
				for (int c1 = 0; c1 < Atoms.size(); c1++) {
					int c1x = Atoms.get(c1) % 2048;
					int c1y = Atoms.get(c1) / 2048 % 2048;
					int c1d = Atoms.get(c1) / 2048 / 2048 % 4;
					for (int c2 = c1 + 1; c2 < Atoms.size(); c2++) {
						int c2x = Atoms.get(c2) % 2048;
						int c2y = Atoms.get(c2) / 2048 % 2048;
						int c2d = Atoms.get(c2) / 2048 / 2048 % 4;
						switch (c1d) {
						case 0:
							if (c2d != 0) {
								if (c2d == 1) { // 마주오면
									if (c1x == c2x && c2y > c1y) {
										Collisions.add((long)(c2y - c1y) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c2y - c1y) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 2) { // 대각 1
									if (c2y - c1y > 0 && c2y - c1y == c2x - c1x) {
										Collisions.add((long)(c2y - c1y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c2y - c1y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 3) { // 대각 2
									if (c2y - c1y > 0 && c2y - c1y == c1x - c2x) {
//										Collisions[cIndex++] = (c2y - c1y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2;
										Collisions.add((long)(c2y - c1y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2);
										crash[c1] = true;
										crash[c2] = true;
									}
								}
							}
							break;
						case 1:
							if (c2d != 1) {
								if (c2d == 0) { // 마주오면
									if (c1x == c2x && c1y > c2y) {
										Collisions.add((long)(c1y - c2y) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1y - c2y) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 2) { // 대각 1
									if (c1y - c2y > 0 && c1y - c2y == c2x - c1x) {
										Collisions.add((long)(c1y - c2y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1y - c2y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 3) { // 대각 2
									if (c1y - c2y > 0 && c1y - c2y == c1x - c2x) {
										Collisions.add((long)(c1y - c2y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1y - c2y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								}
							}
							break;
						case 2:
							if (c2d != 2) {
								if (c2d == 3) { // 마주오면
									if (c1y == c2y && c1x > c2x) {
										Collisions.add((long)(c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 0) { // 대각 1
									if (c1x - c2x > 0 && c1y - c2y == c1x - c2x) {
										Collisions.add((long)(c1y - c2y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1y - c2y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 1) { // 대각 2
									if (c1x - c2x > 0 && c2y - c1y == c1x - c2x) {
										Collisions.add((long)(c2y - c1y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c2y - c1y + c1x - c2x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								}
							}
							break;
						case 3:
							if (c2d != 3) {
								if (c2d == 2) { // 마주오면
									if (c1y == c2y && c2x > c1x) {
										Collisions.add((long)(c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 0) { // 대각 1
									if (c2x - c1x > 0 && c1y - c2y == c2x - c1x) {
										Collisions.add((long)(c1y - c2y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c1y - c2y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								} else if (c2d == 1) { // 대각 2
									if (c2x - c1x > 0 && c2y - c1y == c2x - c1x) {
										Collisions.add((long)(c2y - c1y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2);
//										Collisions[cIndex++] = (c2y - c1y + c2x - c1x) * (1 << 20) + c1 * (1 << 10) + c2;
										crash[c1] = true;
										crash[c2] = true;
									}
								}
							}
							break;
						}
					}
				}
//				if (cIndex == 0) {
//					Atoms.clear();
//					break;
//				}
//				if (cIndex != 0) {
//					Collisions = Arrays.copyOf(Collisions, cIndex);
//					Arrays.sort(Collisions);
//					int min = Collisions[0] / (1 << 20);
//					for (int c = 0; c < cIndex; c++) {
//						if (Collisions[c] / (1 << 20) == min) {
//							realCrash[Collisions[c] % (1 << 10)] = true;
//							realCrash[Collisions[c] % (1 << 20) / (1 << 10)] = true;
//						} else
//							break;
//					}
//				}
				Collisions.sort(null);
				if(!Collisions.isEmpty()) {
					long min = Collisions.get(0) / (1 << 20);
					for (int c = 0; c < Collisions.size(); c++) {
						if (Collisions.get(c) / (1 << 20) == min) {
							realCrash[(int)(Collisions.get(c) % (1 << 10))] = true;
							realCrash[(int)(Collisions.get(c) % (1 << 20) / (1 << 10))] = true;
						} else
							break;
					}
				}
				for (int f = Atoms.size() - 1; f > -1; f--) {
					if (!crash[f]) {
						Atoms.remove(f);
						continue;
					}
					if (realCrash[f]) {
						Energy += Atoms.get(f) / (1 << 24);
						Atoms.remove(f);
						continue;
					}
				}
			}
			sb.append("#" + t + " " + Energy + "\n");
		}
		System.out.print(sb);
	}

}
