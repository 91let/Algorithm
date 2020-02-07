package ST200207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), K = Integer.parseInt(br.readLine());
		if(K > C * R) System.out.println(0);
		else {
			int delC = C - 1, delR = R;
			int x = 1, y = 0;
			while(true) {
				if(K > delR) {
					K -= delR;
					y += delR--;
				}else {
					y += K;
					break;
				}
				if(K > delC) {
					K -= delC;
					x += delC--;
				}else {
					x += K;
					break;
				}
				if(K > delR) {
					K -= delR;
					y -= delR--;
				}else {
					y -= K;
					break;
				}
				if(K > delC) {
					K -= delC;
					x -= delC--;
				}else {
					x -= K;
					break;
				}
			}
			System.out.println(x + " " + y);
		}
	}
}
