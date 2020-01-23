package ST190813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {

	private static int[][] MAP = new int[9][9];
	private static int[][] ZEROS = new int[81][2];
	private static int ZeroCount = 0;

	/*
	 * step 1. 스도쿠 판을 만든다.
	 *  s1. 0인 곳 진입
	 *  s2. 상하 및 범위 탐색 가능한 숫자 리스트 만들
	 *  s3. 숫자 리스트 중 1개 대입 및 루트 분기
	 *  s4. 분기 종료조건? 중도 리턴조건?
	 *   <- 분기 종료 조건: 0 갯수만큼 깊게 들어갔을 때 (0갯수 및 좌표 배열생성?)
	 *    <- 0갯수 카운트 필요
	 *   <- 중도 리턴조건 : 리스트가 생성되지 않은 경우
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] == 0) {
					ZEROS[ZeroCount][0] = i;
					ZEROS[ZeroCount++][1] = j;
				}
			}
		}
		finding(0);
	}

	private static void finding(int count) {
		if (count == ZeroCount) {
			print();
			return;
		}
		int x = ZEROS[count][0];
		int y = ZEROS[count][1];
		int used = 0;
		boolean[] usedNum = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (MAP[i][y] != 0)
				usedNum[MAP[i][y] - 1] = true;
			if (MAP[x][i] != 0)
				usedNum[MAP[x][i] - 1] = true;
		}
		for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
			for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
				if (MAP[i][j] != 0)
					usedNum[MAP[i][j] - 1] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (usedNum[i])
				used++;
		}
		if (used == 9)
			return;
		for (int i = 0; i < 9; i++) {
			if (!usedNum[i]) {
				MAP[x][y] = i + 1;
				finding(count + 1);
				MAP[x][y] = 0;
			}
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(MAP[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.exit(0);
	}
}