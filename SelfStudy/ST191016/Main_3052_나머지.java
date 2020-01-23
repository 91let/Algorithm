package ST191016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3052_나머지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[42];
		int a = 0;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		check[Integer.parseInt(br.readLine()) % 42] = true;
		for (int i = 0; i < 42; i++) if(check[i]) ++a;
		System.out.println(a);
	}

}
