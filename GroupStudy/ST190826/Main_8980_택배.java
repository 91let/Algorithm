package ST190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_8980_택배 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		long truck_send = 0;
		
		int[][] box = new int[M][3];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			box[i][0] = Integer.parseInt(st.nextToken());
			box[i][1] = Integer.parseInt(st.nextToken());
			box[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(box, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int t1 = o1[1];
				int t2 = o2[1];
				if(t1 == t2) {
					int t11 = o1[0];
					int t22 = o2[0];
					return t22 - t11;
				}
				return t1 - t2;
			}
		});
		
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(box[i]));
//		}
		
		int[] V = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(V));
			int min = box[i][2];
			for (int j = box[i][1] - 1; j >= box[i][0]; --j) {
				min = Math.min(C - V[j], min);
			}
			for (int j = box[i][1] - 1; j >= box[i][0]; --j) {
				V[j] += min;
			}
			truck_send += min;
		}
		
		System.out.println(truck_send);
	}

}
