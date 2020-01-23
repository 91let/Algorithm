package ST191014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {
	
	private static int parents[];
	
	static void make() { // make set : 모든 원소를 개별적인 집합으로 생성
		Arrays.fill(parents, -1);
	}
	static int find(int a) {
		if(parents[a]<0) return a; // 자신이 루트이면 자신 리턴
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), connected = 0;
		long A = 0;
		parents = new int[N];
		make();
		int[][] L = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(L, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < M; i++) {
			if(union(L[i][0], L[i][1])) {
				A += (long)L[i][2];
				if(++connected > N - 3) break;
			}
		}
		System.out.println(A);
	}

}
