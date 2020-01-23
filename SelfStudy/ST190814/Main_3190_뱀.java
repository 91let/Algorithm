package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190_뱀 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<int[]> snake = new LinkedList<int[]>();
		int N = Integer.parseInt(br.readLine());
		boolean[][] Board = new boolean[N][N];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			Board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		int L = Integer.parseInt(br.readLine());
		int[][] turn = new int[L + 1][2];
		int Lc = 0;
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D")) {
				turn[i][1] = 1;
			}else {
				turn[i][1] = 3;
			}
		}
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int sd = 0; //뱀의 방향
		
		int TIME = 0;
		int[] head;
//		{y,x}
		boolean play = true;
		snake.add(new int[]{0, 0});
		while(play) {
			TIME++;
//			System.out.println("\n\n");
//			System.out.println("TIME: " + TIME + ", 다음 명령 시간:" + turn[Lc][0] + ", 다음 명령 회전방향 (1:우회전,3:좌회전):" + turn[Lc][1] + "\n 현재 방향(0:우, 1:하, 3:좌, 4:상):" + sd);
//			show(N, Board, snake);
			head = snake.get(0);
			if(head[0] + dy[sd] > -1 && head[0] + dy[sd] < N && head[1] + dx[sd] > -1 && head[1] + dx[sd] < N) { //사각형 안에 있으면
				for (int[] body : snake) { //몸통 충돌감지
					if((head[0] + dy[sd]) == body[0] && (head[1] + dx[sd]) == body[1]) {
						play = false;
					}
				}
				snake.add(0, new int[]{head[0] + dy[sd], head[1] + dx[sd]}); //머리 이동
			}
			else {
				break;
			}
			if(Board[snake.get(0)[0]][snake.get(0)[1]]) { //머리에 사과가 있으면
				Board[snake.get(0)[0]][snake.get(0)[1]] = false; //사과 제거 및 꼬리삭제 안함
			}
			else { //사과가 없다면
				snake.remove(snake.size() - 1); //꼬리 삭제
			}
			if(!play) break;
			if(TIME == turn[Lc][0]) { // 회전 명령일 경우 해당 방향으로 돌아라
				sd = (sd + turn[Lc++][1]) % 4; // 방향회전 및 다음 명령으로
			}
//			br.readLine();
		}
		System.out.println(TIME);
	}

//	private static void show(int n, boolean[][] b, LinkedList<int[]> snake) {
//		int[][] map = new int[n][n];
//		for (int[] s : snake) {
//			map[s[0]][s[1]] = 8;
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if(b[i][j]) System.out.print("1 ");
//				else System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L

10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
*/