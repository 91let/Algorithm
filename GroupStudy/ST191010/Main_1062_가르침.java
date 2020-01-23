package ST191010;

import java.util.Scanner;

public class Main_1062_가르침 {

	static int max = 0, n;
	static int[] l;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int c = 532741, k = sc.nextInt();
		l = new int[n];
		if(k < 5) {
			System.out.println(0);
			System.exit(0);
		}
		else if(k > 25) {
			System.out.println(n);
			System.exit(0);
		}
		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 4; j < tmp.length() - 4; j++) l[i] |= 1 << (tmp.charAt(j) - 'a');
		}
		searchAll(k - 5, 0, c);
		System.out.println(max);
		sc.close();
	}

	private static void searchAll(int index, int last_select, int check) {
		if(index > 0) {
			for (int i = last_select + 1; i < 26; i++) {
				if((check & 1 << i) != 1) searchAll(index - 1, last_select, check| 1 << i);
			}
		} else {
			int counting = 0;
			for (int i = 0; i < n; i++) {
				if((check & l[i]) == l[i]) ++counting;
			}
			max = Math.max(max, counting);
		}
	}

}
// a b c d e f g h i j k l m n o p q r s t u v w x y z
// 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
// t f t f f f f f f f f f f t f f f f f t f f f f f f