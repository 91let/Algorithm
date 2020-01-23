package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5569_출근길 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][][] m = new int[202][202][4]; //최대 사이즈, 마지막이 - 0 = d0방향, 1 = d1방향, 2 = d0 방향 및 꺾기 불가, 3 = d1방향 및 꺾기 불가
		m[1][0][0] = 1;
		m[0][1][1] = 1;
		for (int i = 1; i < 200; i++) {
			for (int j = 0; j <= i; j++) {
//				m[j][i - j]현재 기준점
//				System.out.print(" [3]:" + m[j][i-j][3] + ", ");
				m[j + 1][i - j][0] += m[j][i - j][0] % 100000;//위 방향 이동중 위로 이동
				m[j][i - j + 1][3] += m[j][i - j][0] % 100000;//위 방향 이동중 우로 이동
				m[j][i - j + 2][1] += m[j][i - j][0] % 100000;//위 방향 이동중 우로 이동(미리 2번째칸 마킹)
				m[j][i - j + 1][1] += m[j][i - j][1] % 100000;//우 방향 이동중 우로 이동
				m[j + 1][i - j][2] += m[j][i - j][1] % 100000;//우 방향 이동중 위로 이동
				m[j + 2][i - j][0] += m[j][i - j][1] % 100000;//우 방향 이동중 위로 이동(미리 2번째칸 마킹)
			}
		}
		int w = Integer.parseInt(st.nextToken()) - 1;
		int h = Integer.parseInt(st.nextToken()) - 1;
		System.out.println((m[w][h][0] + m[w][h][1] + m[w][h][2] + m[w][h][3]) % 100000);
	}
}
