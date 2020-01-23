package ST191210;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5543_상근날드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int b1 = Integer.parseInt(br.readLine());
		int b2 = Integer.parseInt(br.readLine());
		int b3 = Integer.parseInt(br.readLine());
		int bm = (b1 > b2) ? b2 : b1;
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		System.out.println(((b3 > bm) ? bm : b3) + ((d1 > d2) ? d2 : d1) - 50);
	}

}
