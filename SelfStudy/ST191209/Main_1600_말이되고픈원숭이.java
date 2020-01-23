package ST191209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	
	static int[] dh = {-1, 1, 0, 0},
				dw = {0, 0, -1, 1},
				jh = {-2, -2, -1, -1, 1, 1, 2, 2},
				jw = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()) + 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
		int qs = -1, qe = -1, count = 0;
		int[][] map = new int[H][W];
		int q[] = new int[H * W * K];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = (Integer.parseInt(st.nextToken()) > 0) ? Integer.MAX_VALUE : 0;
			}
		}
		map[0][0] = Integer.MAX_VALUE;
		q[++qe] = (K - 1) * 40000;
		while(qe != qs) {
			for (int i = qe - qs; i > 0; --i) {
				int tmp = q[++qs];
				int lv = tmp / 40000, th = tmp % 40000 / 200, tw = tmp % 200;
				if(th == H - 1 && tw == W -1) {
					System.out.println(count);
					System.exit(0);
				}else {
					for (int d = 0; d < 4; d++) {
						int tth = th + dh[d], ttw = tw + dw[d];
						if(tth > -1 && ttw > -1 && tth < H && ttw < W && ((map[tth][ttw] >> lv) & 1) != 1) {
							map[tth][ttw] |= (1 << lv);
							q[++qe] = lv * 40000 + tth * 200 + ttw;
						}
					}
					if(--lv != -1) {
						for (int j = 0; j < 8; j++) {
							int tth = th + jh[j], ttw = tw + jw[j];
							if(tth > -1 && ttw > -1 && tth < H && ttw < W && ((map[tth][ttw] >> lv) & 1) != 1) {
								map[tth][ttw] |= (1 << lv);
								q[++qe] = lv * 40000 + tth * 200 + ttw;
							}
						}
					}
				}
			}
			++count;
		}
		System.out.println(-1);
	}

}