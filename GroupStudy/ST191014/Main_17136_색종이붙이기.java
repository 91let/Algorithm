package ST191014;

import java.util.Scanner;

public class Main_17136_색종이붙이기 {

	static boolean[][] map = new boolean[10][10];
	static int ones = 0, result = Integer.MAX_VALUE;
	static int[] Ps = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				if(tmp.charAt(j * 2) != '0') {
					map[i][j] = true;
					++ones;
				}else map[i][j] = false;
			}
		}
		if(ones < 1) System.out.println(0);
		else {
			defineRect(0);
			if(result != Integer.MAX_VALUE) System.out.println(result);
			else System.out.println(-1);
		}
		sc.close();
	}

	private static void defineRect(int count) {
		while(count < 100) {
			if(!map[count / 10][count % 10]) ++count;
			else break;
		}
		sizing : for (int s = 5; s > 0; --s) {
			int h = count / 10 + s, w = count % 10 + s;
			if(h > 10 || w > 10) continue;
			for (int i = count / 10; i < h; i++) {
				for (int j = count % 10; j < w; j++) {
					if(!map[i][j]) continue sizing;
				}
			}
			++Ps[s];
			if(Ps[1] > 5 || Ps[2] > 5 || Ps[3] > 5 || Ps[4] > 5 || Ps[5] > 5) {
				--Ps[s];
				continue sizing;
			}
			for (int i = count / 10; i < h; i++) {
				for (int j = count % 10; j < w; j++) {
					map[i][j] = false;
					--ones;
				}
			}
			if(ones != 0) defineRect(count);
			else result = Math.min(result, Ps[1] + Ps[2] + Ps[3] + Ps[4] + Ps[5]);
			--Ps[s];
			for (int i = count / 10; i < h; i++) {
				for (int j = count % 10; j < w; j++) {
					map[i][j] = true;
					++ones;
				}
			}
		}
	}

}
