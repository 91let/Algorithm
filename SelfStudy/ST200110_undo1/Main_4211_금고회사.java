package ST200110_undo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4211_금고회사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = 0;
		while(st.hasMoreTokens()) {
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
			
			System.out.printf("Case %d:", ++tc);
			st = new StringTokenizer(br.readLine());
		}
	}

}
