package ST200223;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_18291_비요뜨의징검다리건너기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(--T != -1) System.out.println(pow2(Integer.parseInt(br.readLine()) - 2));
	}
	
	static long pow2(int N){
	    if(N < 1) return 1;
	    long tmp = pow2(N / 2);
	    return (tmp * tmp * (N % 2 + 1)) % 1000000007;
	}

}
