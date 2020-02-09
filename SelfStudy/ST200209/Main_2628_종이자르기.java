package ST200209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> wCut = new ArrayList<Integer>(), hCut = new ArrayList<Integer>();
		hCut.add(Integer.parseInt(st.nextToken()));
		wCut.add(Integer.parseInt(st.nextToken()));
		int N = Integer.parseInt(br.readLine()), last = 0, wMax = 0, hMax = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) wCut.add(Integer.parseInt(st.nextToken()));
			else hCut.add(Integer.parseInt(st.nextToken()));
		}
		wCut.sort(null);
		hCut.sort(null);
		for (Integer w : wCut) {
			wMax = Math.max(wMax, w - last);
			last = w;
		}
		last = 0;
		for (Integer h : hCut) {
			hMax = Math.max(hMax, h - last);
			last = h;
		}
		System.out.println(wMax * hMax);
	}

}
