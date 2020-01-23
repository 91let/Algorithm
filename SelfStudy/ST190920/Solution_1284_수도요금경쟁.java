package ST190920;

import java.io.*;

public class Solution_1284_수도요금경쟁 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()) + 1, t = 0;
		while (++t < T) {
			String[] i = br.readLine().split(" ");
			sb.append('#').append(t).append(' ').append(Math.min(Integer.parseInt(i[0]) * Integer.parseInt(i[4]), (Integer.parseInt(i[4]) > Integer.parseInt(i[2])) ? Integer.parseInt(i[1]) + Integer.parseInt(i[3]) * (Integer.parseInt(i[4]) - Integer.parseInt(i[2])): Integer.parseInt(i[1]))).append('\n');
		}
		System.out.println(sb);
	}

}
