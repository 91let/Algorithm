package ST191211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1803_ShortestPathFaster {

	static LinkedList<long[]>[] map;
	static long dists[];
	static int N;
	
	private static void init() {
		map = new LinkedList[N];
		dists = new long[N];
		for (int i = 1; i < N; i++) {
			map[i] = new LinkedList<long[]>();
			dists[i] = Long.MAX_VALUE;
		}
	}
	
	private static long find(int start, int end) {
		if(start == end) return 0;
		PriorityQueue<long[]> pq = new PriorityQueue<long[]>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});
		pq.offer(new long[] {0, start});
		while(!pq.isEmpty()) {
			long[] tmp = pq.poll();
			long now = tmp[1], dist = tmp[0];
			if(now != end) {
				for (long[] node : map[(int)now]) {
					long next_dist = node[0] + dist, next = node[1];
					if(next_dist < dists[(int)next])	{
						dists[(int)next] = next_dist;
						pq.offer(new long[] {next_dist, next});
					}
				}
			} else return dist;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) + 1;
			init();
			int M = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
			while(--M != -1) {
				st = new StringTokenizer(br.readLine());
				long a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
				map[(int)a].add(new long[] {v, b});
				map[(int)b].add(new long[] {v, a});
			}
			sb.append('#').append(++t).append(' ').append(find(start, end)).append('\n');
		}
		System.out.println(sb);
	}

}

