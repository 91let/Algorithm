package ST190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2529_부등호 {
	
	static long min = 9999999999L;
	static long max = -1;
	static int K;
	static char[] comp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		comp = new char[K];
		
		for (int i = 0; i < K; i++) {
			comp[i] = st.nextToken().charAt(0);
		}
		
		for (int i = 0; i < 10; i++) {
			compareP(i, i ,1<<i, 0);
			//직전 peek 숫자, 합계, 체크, 횟수
		}
		
		System.out.println(max);
		long tmp = min;
		for (int i = 0; i < K; i++) {
			tmp = tmp / 10;
		}
		if(tmp > 0) System.out.println(min);
		else System.out.println("0" + min);
	}

	private static void compareP(int last, long sum, int check, int count) {
		if(count == K) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		else {
			for (int i = 0; i < 10; i++) {
				if((check&(1<<i)) == 0) {
					if(comp[count] == '<' && last < i) {
						compareP(i, sum * 10 + i, check|(1 << i), count + 1);
					} else if(comp[count] == '>' && last > i) {
						compareP(i, sum * 10 + i, check|(1 << i), count + 1);
					}
				}
			}
		}
	}

}
