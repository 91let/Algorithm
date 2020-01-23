package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long tmp = 0;
		long current = 0;
		long next = 1;
		for (int i = 0; i < N; i++) {
			tmp = next;
			next += current;
			current = tmp;
		}
		System.out.println(current);
	}

}
