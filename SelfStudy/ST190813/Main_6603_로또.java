package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int nums = Integer.parseInt(st.nextToken());
			if(nums == 0) break;
			int[] numline = new int[nums];
			for (int i = 0; i < nums; i++) {
				numline[i] = Integer.parseInt(st.nextToken());
			}
			for (int p1 = 0; p1 < nums; p1++) {
				for (int p2 = p1+1; p2 < nums; p2++) {
					for (int p3 = p2+1; p3 < nums; p3++) {
						for (int p4 = p3+1; p4 < nums; p4++) {
							for (int p5 = p4+1; p5 < nums; p5++) {
								for (int p6 = p5+1; p6 < nums; p6++) {
									sb.append(numline[p1]).append(" ").append(numline[p2]).append(" ").append(numline[p3]).append(" ").append(numline[p4]).append(" ").append(numline[p5]).append(" ").append(numline[p6]).append(" ").append("\n");
								}
							}
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
