package ST190808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	static int MAX = -1000000001;
	static int MIN = 1000000001;
	static int[] nums;
	static int[] subs;
	static int[] opers;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		opers = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		int oper = -1;
		for (int i = 0; i < N-1; i++) {
			while(tmp == 0) {
				tmp = Integer.parseInt(st.nextToken());
				oper++;
			}
			opers[i] = oper;
			tmp--;
		}
		sequence(nums[0], 1, 0);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	/**
	 * for 문으로 숫자 처음부터 끝까지 하나씩 고르며 함수 실행
	 * 연산자 한개 peek, 숫자 한개 peek, 고른것 표시 및 재귀
	 * 끝일 경우 min, max 비교
	 */
	public static void sequence(int sum, int c, int check_O) {
		if(c == N) {
			if(sum < MIN) MIN = sum;
			if(sum > MAX) MAX = sum;
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if((check_O&1<<i) == 0) {
				switch (opers[i]) {
				case 0://+
					sequence(sum + nums[c], c + 1, check_O|1<<i);
					break;
				case 1://-
					sequence(sum - nums[c], c + 1, check_O|1<<i);
					break;
				case 2://*
					sequence(sum * nums[c], c + 1, check_O|1<<i);
					break;
				case 3:///
					if(sum > 0) {
						sequence(sum / nums[c], c + 1, check_O|1<<i);
					}else {
						sum = 0-(0-sum)/nums[c];
						sequence(sum, c + 1, check_O|1<<i);
					}
					break;
					
				default:
					break;
				}
			}
		}
	}
}
