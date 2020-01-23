package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		st = new StringTokenizer(br.readLine());
		max[0][0] = min[0][0] = Integer.parseInt(st.nextToken());
		max[0][1] = min[0][1] = Integer.parseInt(st.nextToken());
		max[0][2] = min[0][2] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				switch (j) {
				case 0:
					if(max[i-1][0] > max[i-1][1]) {
						max[i][0] = max[i-1][0] + tmp;
					} else {
						max[i][0] = max[i-1][1] + tmp;
					}
					if(min[i-1][0] < min[i-1][1]) {
						min[i][0] = min[i-1][0] + tmp;
					} else {
						min[i][0] = min[i-1][1] + tmp;
					}
					break;
				case 1:
					if((max[i-1][0] >= max[i-1][1]) && (max[i-1][0] >= max[i-1][2])) {
						max[i][1] = max[i-1][0] + tmp;
					}
					else if((max[i-1][1] >= max[i-1][0]) && (max[i-1][1] >= max[i-1][2])) {
						max[i][1] = max[i-1][1] + tmp;
					}
					else {
						max[i][1] = max[i-1][2] + tmp;
					}
					if((min[i-1][0] <= min[i-1][1]) && (min[i-1][0] <= min[i-1][2])) {
						min[i][1] = min[i-1][0] + tmp;
					}
					else if((min[i-1][1] <= min[i-1][0]) && (min[i-1][1] <= min[i-1][2])) {
						min[i][1] = min[i-1][1] + tmp;
					}
					else {
						min[i][1] = min[i-1][2] + tmp;
					}					
					break;
				case 2:
					if(max[i-1][1] > max[i-1][2]) {
						max[i][2] = max[i-1][1] + tmp;
					} else {
						max[i][2] = max[i-1][2] + tmp;
					}
					if(min[i-1][1] < min[i-1][2]) {
						min[i][2] = min[i-1][1] + tmp;
					} else {
						min[i][2] = min[i-1][2] + tmp;
					}
					break;

				default:
					break;
				}
			}
		}
		int maxR = max[N-1][0];
		int minR = min[N-1][0];
		
		for (int m = 1; m < 3; m++) {
			if(maxR < max[N-1][m]) maxR = max[N-1][m];
			if(minR > min[N-1][m]) minR = min[N-1][m];
		}
		
		System.out.println(maxR + " " + minR);
		for (int j = 0; j < min.length; j++) {
			System.out.println(Arrays.toString(min[j]) + " " + Arrays.toString(max[j]));
		}
	}

}
