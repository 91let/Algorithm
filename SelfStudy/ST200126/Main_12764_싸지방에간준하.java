package ST200126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12764_싸지방에간준하 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), X = 0;
		int[] sits_used = new int[N];
		PriorityQueue<int[]> sort = new PriorityQueue<int[]>((int[] o1, int[] o2) -> {return o1[0] - o2[0];});
		PriorityQueue<int[]> used_coms = new PriorityQueue<int[]>((int[] o1, int[] o2) -> {return o1[0] - o2[0];});
		PriorityQueue<Integer> empty_sits = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sort.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		while(!sort.isEmpty()){
			int start_time = sort.peek()[0];
			int end_time = sort.poll()[1];
			while(!used_coms.isEmpty() && used_coms.peek()[0] < start_time) {
				empty_sits.add(used_coms.poll()[1]);
			}
			if(empty_sits.isEmpty()) {
				++sits_used[X];
				used_coms.add(new int[] {end_time, X++});
			}else {
				++sits_used[empty_sits.peek()];
				used_coms.add(new int[] {end_time, empty_sits.poll()});
			}
		}
		
		sb.append(X).append('\n');
		for (int i = 0; i < X; i++) sb.append(sits_used[i]).append(' ');
		System.out.println(sb);
	}

}
