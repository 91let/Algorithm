package ST190827;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1309_동물원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 1, b = 1;
		for (int i = Integer.parseInt(br.readLine()); i > 1; --i) {
			a = (a + 2 * b) % 9901;
			b = (a + 9901 - b) % 9901;
		}
		System.out.println(((a + b * 2) % 9901));
	}
}
