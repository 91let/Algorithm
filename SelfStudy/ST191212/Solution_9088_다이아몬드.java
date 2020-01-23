package ST191212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_9088_다이아몬드 {

	//리스트 -> key(크기)
	//배열[key] -> 갯수
	private static ArrayList<Integer> D_size;
	private static int N, K;
	private static int[] counts_per_size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0, tmp = 0;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			D_size = new ArrayList<Integer>();
			counts_per_size = new int[10001];
			for (int i = N - 1; i > -1; --i) {
				int now = Integer.parseInt(br.readLine());
				if(counts_per_size[now] == 0) D_size.add(now);
				++counts_per_size[now];
			}
			D_size.sort(null);
			int left = D_size.size() - 1, right = D_size.size() - 1;
			for (int i = right; i > -1; --i) {
				int looking_size = D_size.get(i);
				while(left > -1 && D_size.get(left) + K >= looking_size) {
					tmp += counts_per_size[D_size.get(left--)];
				}
				max = Math.max(max, tmp);
				tmp -= counts_per_size[looking_size];
			}
			sb.append('#').append(++t).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}

}
