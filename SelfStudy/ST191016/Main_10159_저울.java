package ST191016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10159_저울 {
	
	static Node[] Ns;

	static class Node{
		LinkedList<Integer> heavier;
		LinkedList<Integer> lighter;
		public Node() {
			heavier = new LinkedList<Integer>();
			lighter = new LinkedList<Integer>();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()) + 1, M = Integer.parseInt(br.readLine());
		int[] q = new int[N];
		boolean[] check;
		Ns = new Node[N];
		for (int i = 1; i < N; i++) Ns[i] = new Node();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			Ns[a].lighter.add(b);
			Ns[b].heavier.add(a);
		}
		
		//체크
		for (int i = 1; i < N; i++) {
			int qs = -1, qe = -1, count = 2;
			q[++qe] = i;
			check = new boolean[N];
			while(qs != qe) {
				int n = q[++qs];
				for (int h : Ns[n].heavier) {
					if(!check[h]) {
						q[++qe] = h;
						++count;
						check[h] = true;
					}
				}
			}
			q[++qe] = i;
			while(qs != qe) {
				int n = q[++qs];
				for (int l : Ns[n].lighter) {
					if(!check[l]) {
						q[++qe] = l;
						++count;
						check[l] = true;
					}
				}
			}
			sb.append(N - count).append('\n');
		}
		System.out.println(sb);
	}

}
