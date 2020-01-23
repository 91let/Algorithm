package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] MAP = new String[N];
		for (int i = 0; i < N; i++) {
			MAP[i] = br.readLine();
		}
		boolean[][] nor = new boolean[N][N];
		boolean[][] abn = new boolean[N][N];
		Queue<Integer> q = new LinkedList<Integer>();
		
		int[] di = {0, 0, -1, 1};
		int[] dj = {-1, 1, 0, 0};
		char tmp;
		int t;
		int ti;
		int tj;
		
		int norc = 0;
		int abnc = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!nor[i][j]) {
					nor[i][j] = true;
					tmp = MAP[i].charAt(j);
					q.offer(i*100+j);
					++norc;
					while(!q.isEmpty()) {
						t = q.poll();
						ti = t/100;
						tj = t%100;
						for (int d = 0; d < 4; d++) {
							if(ti+di[d] > -1 && ti+di[d] < N && tj+dj[d] > -1 && tj+dj[d] < N && !nor[ti+di[d]][tj+dj[d]] && MAP[ti+di[d]].charAt(tj+dj[d]) == tmp) {
								nor[ti+di[d]][tj+dj[d]] = true;
								q.offer((ti+di[d]) * 100 + tj+dj[d]);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!abn[i][j]) {
					abn[i][j] = true;
					tmp = MAP[i].charAt(j);
					q.offer(i*100+j);
					++abnc;
					while(!q.isEmpty()) {
						t = q.poll();
						ti = t/100;
						tj = t%100;
						if(tmp == 'B') {
							for (int d = 0; d < 4; d++) {
								if(ti+di[d] > -1 && ti+di[d] < N && tj+dj[d] > -1 && tj+dj[d] < N && !abn[ti+di[d]][tj+dj[d]] && MAP[ti+di[d]].charAt(tj+dj[d]) == 'B') {
									abn[ti+di[d]][tj+dj[d]] = true;
									q.offer((ti+di[d]) * 100 + tj+dj[d]);
								}
							}
						} else {
							for (int d = 0; d < 4; d++) {
								if(ti+di[d] > -1 && ti+di[d] < N && tj+dj[d] > -1 && tj+dj[d] < N && !abn[ti+di[d]][tj+dj[d]] && (MAP[ti+di[d]].charAt(tj+dj[d]) == 'R' || MAP[ti+di[d]].charAt(tj+dj[d]) == 'G')) {
									abn[ti+di[d]][tj+dj[d]] = true;
									q.offer((ti+di[d]) * 100 + tj+dj[d]);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(norc + " " + abnc);
	}

}
