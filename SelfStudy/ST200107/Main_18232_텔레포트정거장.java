package ST200107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1, M = Integer.parseInt(st.nextToken()), Ans = 0;
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] Teleport = new ArrayList[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int T1 = Integer.parseInt(st.nextToken()), T2 = Integer.parseInt(st.nextToken());
			if(Teleport[T1] == null) Teleport[T1] = new ArrayList<Integer>();
			if(Teleport[T2] == null) Teleport[T2] = new ArrayList<Integer>();
			Teleport[T1].add(T2);
			Teleport[T2].add(T1);
		}
		int[] q = new int[N];
		int qs = -1, qe = -1;
		q[++qe] = S;
		visited[0] = true;
		visited[N] = true;
		visited[S] = true;
		flag : while(qs != qe) {
			for (int i = qe - qs; i != 0; --i) {
				int p = q[++qs];
				if(p == E) break flag;
				if(!visited[p - 1]) {
					q[++qe] = p - 1;
					visited[p - 1] = true;
				}
				if(!visited[p + 1]) {
					q[++qe] = p + 1;
					visited[p + 1] = true;
				}
				if(Teleport[p] != null) {
					for (int tele_point : Teleport[p]) {
						if(!visited[tele_point]) {
							q[++qe] = tele_point;
							visited[tele_point] = true;
						}
					}
				}
			}
			++Ans;
		}
		System.out.println(Ans);
	}

}
