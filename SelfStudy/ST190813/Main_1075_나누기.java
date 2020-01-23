package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1075_나누기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		N = N / 100 * 100;
		
		for (int i = 0; i < 100; i++) {
			if((N + i) % F == 0) {
				if(i < 10) System.out.println("0"+i);
				else System.out.println(i);
				System.exit(0);
			}
		}
	}

}
