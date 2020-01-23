package ST191014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3780_네트워크연결 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(--T != -1) {
			int N = Integer.parseInt(br.readLine());
			int[] line =  new int[N + 1];
			int[] c_p =  new int[N + 1];
			while(true) {
				st = new StringTokenizer(br.readLine());
				char K = st.nextToken().charAt(0);
				if(K == 'O') break;
				if(K == 'E') {
					int e = Integer.parseInt(st.nextToken()), sum = 0;
					while(c_p[e] != 0) {
						sum += line[e];
						e = c_p[e];
					}
					sb.append(sum + "\n");
				}
				if(K == 'I') {
					int i1 = Integer.parseInt(st.nextToken()), i2 = Integer.parseInt(st.nextToken());
					line[i1] = Math.abs(i2 - i1) % 1000;
					c_p[i1] = i2;
				}
			}
		}
		System.out.println(sb);
	}

}
