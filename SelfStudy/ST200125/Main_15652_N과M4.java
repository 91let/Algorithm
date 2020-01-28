package ST200125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {

	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		char c = (char)(st.nextToken().charAt(0) + 1);
		int len = Integer.parseInt(st.nextToken());
		char[] buff = new char[len * 2];
		go('1', c, len, buff, 0);
		System.out.println(sb);
	}

	private static void go(char start_value, char max_value, int len, char[] buff, int index) {
		if(len == 0) sb.append(buff).append('\n');
		else {
			for (char i = start_value; i < max_value; i++) {
				buff[index] = i;
				buff[index + 1] = ' ';
				go(i, max_value, len - 1, buff, index + 2);
			}
		}
	}

}
