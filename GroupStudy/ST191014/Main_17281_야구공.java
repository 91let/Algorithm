	package ST191014;

import java.util.Scanner;

public class Main_17281_야구공 {

	static char[][] INNINGS;
	static int[] selected = new int[9];
	static int N = 0, result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		if(tmp.length() != 1) N = (tmp.charAt(0) - '0') * 10 + tmp.charAt(1) - '0';
		else N = tmp.charAt(0) - '0';
		INNINGS = new char[N][9];
		selected[0] = 8;
		selected[1] = 8;
		selected[2] = 8;
		selected[3] = 0;
		selected[4] = 8;
		selected[5] = 8;
		selected[6] = 8;
		selected[7] = 8;
		selected[8] = 8;
		for (int i = 0; i < N; i++) {
			tmp = sc.nextLine();
			INNINGS[i][0] = tmp.charAt(0);
			INNINGS[i][1] = tmp.charAt(2);
			INNINGS[i][2] = tmp.charAt(4);
			INNINGS[i][3] = tmp.charAt(6);
			INNINGS[i][4] = tmp.charAt(8);
			INNINGS[i][5] = tmp.charAt(10);
			INNINGS[i][6] = tmp.charAt(12);
			INNINGS[i][7] = tmp.charAt(14);
			INNINGS[i][8] = tmp.charAt(16);
		}
		P(0);
		System.out.println(result);
		sc.close();
	}

	private static void P(int c) {
		if(c > 7) {
			playgame();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(selected[i] > 7) {
				selected[i] = c + 1;
				P(c + 1);
				selected[i] = 8;
			}
		}
	}

	private static void playgame() {
		int point = -1;
		int score = 0;
		for (int i = 0; i < N; i++) {
			boolean base[] = new boolean[3];
			int out = 0;
			while(out < 3) {
				point = ++point % 9;
				switch (INNINGS[i][selected[point]]) {
				case '0':
					++out;
					break;
				case '1':
					if(base[2]) ++score;
					base[2] = base[1];
					base[1] = base[0];
					base[0] = true;
					break;
				case '2':
					if(base[2]) ++score;
					if(base[1]) ++score;
					base[2] = base[0];
					base[1] = true;
					base[0] = false;
					break;
				case '3':
					if(base[2]) ++score;
					if(base[1]) ++score;
					if(base[0]) ++score;
					base[2] = true;
					base[1] = false;
					base[0] = false;
					break;
				case '4':
					if(base[2]) ++score;
					if(base[1]) ++score;
					if(base[0]) ++score;
					++score;
					base[2] = false;
					base[1] = false;
					base[0] = false;
					break;
				}
			}
		}
		result = (score > result) ? score : result;
	}

}
