package ST191010;

import java.util.Scanner;

public class Main_16939_2x2x2큐브 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		char[][] cube = new char[6][4];
		for (int i = 0; i < 24; i++) cube[i / 4][i % 4] = T.charAt(i * 2);
		if(issame(cube[0], cube[2])) {
			if(checkside1(cube[1], cube[4], cube[5], cube[3])) System.out.println(1);
			else System.out.println(0);
		}
		else if(issame(cube[1], cube[5])) {
			if(checkside2(cube[0], cube[3], cube[2], cube[4])) System.out.println(1);
			else System.out.println(0);
		}
		else if(issame(cube[3], cube[4])) {
			if(checkside3(cube[0], cube[1], cube[2], cube[5])) System.out.println(1);
			else System.out.println(0);
		}else System.out.println(0);
		sc.close();
	}

	private static boolean checkside3(char[] cs0, char[] cs1, char[] cs2, char[] cs5) {
		if(cs0[0] == cs0[2] && cs0[2] == cs1[1] && cs1[1] == cs1[3]
		&& cs1[0] == cs1[2] && cs1[2] == cs2[1] && cs2[1] == cs2[3]
		&& cs2[0] == cs2[2] && cs2[2] == cs5[0] && cs5[0] == cs5[2]
		&& cs5[1] == cs5[3] && cs5[3] == cs0[1] && cs0[1] == cs0[3])
			return true;
		if(cs0[0] == cs0[2] && cs0[2] == cs5[0] && cs5[0] == cs5[2]
		&& cs1[0] == cs1[2] && cs1[2] == cs0[1] && cs0[1] == cs0[3]
		&& cs2[0] == cs2[2] && cs2[2] == cs1[1] && cs1[1] == cs1[3]
		&& cs5[1] == cs5[3] && cs5[3] == cs2[1] && cs2[1] == cs2[3])
			return true;
		return false;
	}

	private static boolean checkside2(char[] cs0, char[] cs3, char[] cs2, char[] cs4) {
		if(cs0[0] == cs0[1] && cs0[1] == cs3[1] && cs3[1] == cs3[3]
		&& cs3[0] == cs3[2] && cs3[2] == cs2[0] && cs2[0] == cs2[1]
		&& cs2[2] == cs2[3] && cs2[3] == cs4[0] && cs4[0] == cs4[2]
		&& cs4[1] == cs4[3] && cs4[3] == cs0[2] && cs0[2] == cs0[3])
			return true;
		if(cs0[0] == cs0[1] && cs0[1] == cs4[0] && cs4[0] == cs4[2]
		&& cs3[0] == cs3[2] && cs3[2] == cs0[2] && cs0[2] == cs0[3]
		&& cs2[2] == cs2[3] && cs2[3] == cs3[1] && cs3[1] == cs3[3]
		&& cs4[1] == cs4[3] && cs4[3] == cs2[0] && cs2[0] == cs2[1])
			return true;
		return false;
	}

	private static boolean checkside1(char[] cs1, char[] cs4, char[] cs5, char[] cs3) {
		if(cs1[0] == cs1[1] && cs1[1] == cs4[2] && cs4[2] == cs4[3]
		&& cs4[0] == cs4[1] && cs4[1] == cs5[2] && cs5[2] == cs5[3]
		&& cs5[0] == cs5[1] && cs5[1] == cs3[2] && cs3[2] == cs3[3]
		&& cs3[0] == cs3[1] && cs3[1] == cs1[2] && cs1[2] == cs1[3])
			return true;
		if(cs1[3] == cs1[2] && cs1[2] == cs4[1] && cs4[1] == cs4[0]
		&& cs4[3] == cs4[2] && cs4[2] == cs5[1] && cs5[1] == cs5[0]
		&& cs5[3] == cs5[2] && cs5[2] == cs3[1] && cs3[1] == cs3[0]
		&& cs3[3] == cs3[2] && cs3[2] == cs1[1] && cs1[1] == cs1[0])
			return true;
		return false;
	}

	private static boolean issame(char[] cs1, char[] cs2) {
		for (int i = 0; i < 4; i++) if(cs1[i] != cs1[(i + 1) % 4] ||cs2[i] != cs2[(i + 1) % 4]) return false;
		return true;
	}

}



/**
 * 1,2,3,4(위로 놓고)가 같고 9,10,11,12가 같을때
 * 13	14	|	5	6	|	17	18	|	21	22 - 윗줄
 * 15	16	|	7	8	|	19	20	|	23	24 - 아랫줄
 * 5,6,7,8(위로 놓고)이 같고 21,22,23,24가 같을때
 * 3	4	|	17	19	|	10	9	|	16	14 - 윗줄
 * 1	2	|	18	20	|	12	11	|	15	13 - 아랫줄
 * 17,18,19,20(위로 놓고) 이 같고 13,14,15,16이 같을때
 * 8	6	|	4	2	|	21	23	|	12	10 - 윗줄
 * 7	5	|	3	1	|	22	24	|	11	9 - 아랫줄
 * 아랫줄을 좌, 우로 2칸씩 움직여서 매칭하면 끝
 */
