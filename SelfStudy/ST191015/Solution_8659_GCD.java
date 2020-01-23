package ST191015;

import java.util.Scanner;

public class Solution_8659_GCD {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()), t = 0, p = -1;
		long[] R = new long[91];
		R[0] = 1;
		R[1] = 2;
		char[] buff = new char[500];
		for (int i = 2; i < 91; i++) R[i] = R[i - 2] + R[i - 1];
		while(t < T) {
			int K = Integer.parseInt(sc.nextLine());
			
			buff[++p] = '#';
			if(++t < 10) buff[++p] = (char)(t + '0');
			else {
				buff[++p] = '1';
				buff[++p] = '0';
			}
			buff[++p] = ' ';
			String tmp = R[K] + "";
			//1
			for (int i = 0; i < tmp.length(); i++) buff[++p] = tmp.charAt(i);
			buff[++p] = ' ';
			tmp = R[K - 1] + "";
			for (int i = 0; i < tmp.length(); i++) buff[++p] = tmp.charAt(i);
			buff[++p] = '\n';
		}
		System.out.println(buff);
	}

}
