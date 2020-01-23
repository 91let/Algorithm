package ST191223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1700_멀티탭스케줄링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), count = 0;
		int[] Holes = new int[N], Task = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) Task[i] = Integer.parseInt(st.nextToken());
		f1 : for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++)
				if (Task[i] == Holes[j]) {
					continue f1;
				}
			for (int j = 0; j < N; j++)
				if (Holes[j] == 0) {
					Holes[j] = Task[i];
					continue f1;
				}
			int swap = 0, val = -1;
			for (int j = 0; j < N; j++) {
				int term = 0;
				for (int k = i + 1; k < K && Holes[j] != Task[k]; k++) term++;
				if (term > val) {
					swap = j;
					val = term;
				}
			}
			++count;
			Holes[swap] = Task[i];
		}
		System.out.println(count);
	}

}
