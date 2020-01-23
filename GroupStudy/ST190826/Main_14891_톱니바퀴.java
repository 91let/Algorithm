package ST190826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	@SuppressWarnings("unchecked")
	static LinkedList<Integer>[] gear = new LinkedList[4];
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			String tmp = br.readLine();
			gear[i] = new LinkedList<Integer>();
			for (int j = 0; j < 8; j++) {
				gear[i].add(tmp.charAt(j) - '0');
			}
		}
		int w_c = Integer.parseInt(br.readLine());
		for (int i = 0; i < w_c; i++) {
			st = new StringTokenizer(br.readLine());
			check = new boolean[4];
			move(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		System.out.println(((gear[3].get(0)<<3) + (gear[2].get(0)<<2) + (gear[1].get(0)<<1) + (gear[0].get(0))));
	}

	private static void move(int g, int r) {
		check[g] = true;
		if(r == 1) {
			if(g < 3) {
				if(gear[g].get(2) != gear[g + 1].get(6)) {
					if(!check[g + 1]) move(g + 1, -1);
				}
			}
			if(g > 0) {
				if(gear[g].get(6) != gear[g - 1].get(2)) {
					if(!check[g - 1]) move(g - 1, -1);
				}
			}
			gear[g].add(0, gear[g].get(7));
			gear[g].remove(8);
		} else {
			if(g < 3) {
				if(gear[g].get(2) != gear[g + 1].get(6)) {
					if(!check[g + 1]) move(g + 1, 1);
				}
			}
			if(g > 0) {
				if(gear[g].get(6) != gear[g - 1].get(2)) {
					if(!check[g - 1]) move(g - 1, 1);
				}
			}
			gear[g].add(gear[g].get(0));
			gear[g].remove(0);
		}
	}

}
