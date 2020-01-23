package ST190822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_8383_숫자선물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String ori = st.nextToken();
			StringBuilder sbt = new StringBuilder();
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), lastY = -1;
			boolean f = false;
			for (int i = 0; i < ori.length(); i++) {
				if (f) {
					sbt.append(y);
				} else if(ori.charAt(i) - '0' > y) {
					sbt.append(y);
					lastY = i;
					f = true;
				} else if(ori.charAt(i) - '0' == y) {
					sbt.append(y);
					lastY = i;
				} else if(ori.charAt(i) - '0' > x) {
					sbt.append(x);
					f = true;
				} else if(ori.charAt(i) - '0' == x) {
					sbt.append(x);
				} else {
					if(lastY != -1) {
						sbt = new StringBuilder(sbt.delete(lastY, sbt.length()));
						sbt.append(x);
					} else {
						sbt = new StringBuilder();
						lastY = 0;
					}
					for (int j = lastY; j < i; j++) sbt.append(y);
					f= true;
				}
			}
			if(sbt.length() != 0 && sbt.charAt(0) == '0') sbt.deleteCharAt(0);
			if(sbt.length() == 0) sbt.append("-1");
			sb.append("#" + t + " " + sbt + "\n");
		}
		System.out.println(sb);
	}

}
