package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int now_height;
		int upable = 0;
		int goable = 0;
		boolean downable = false;
		for (int i = 0; i < N; i++) {						//가로탐색
			now_height = map[i][0];							//첫번째 칸의 높이 기록
			upable = 1;										//첫번째 칸 사다리용 공간 기록 (upable >=L이면 올라갈 수 있다)
			for (int j = 1; j < N; j++) {					//두번째 부터 끝까지
				if(map[i][j] == now_height) {				//전칸과 높이가 같으면 사다리 놓을 공간 +1 기록
					++upable;
				}
				else if(map[i][j] == now_height + 1) {		//전 칸 보다 1 높을 경우
					if(upable >= L) {						//upable이 L이상이면 현재 높이 올리고, 사다리 놓을 공간 1로 초기화
						++now_height;
						upable = 1;
					}
					else break;								//놓을 공간이 없을 경우 이번 길 종료
				}
				else if(map[i][j] == now_height - 1) {		//전 칸 보다 1 낮을 경우
					downable = true;						//일단 내려갈 수 있다고 초기화
					for (int f = 0; f < L; f++) {
						if(j + f == N || map[i][j + f] != now_height - 1) {	//현재칸 부터 사다리 길이만큼 앞의 칸 탐색, 인덱스가 벗어나면 취소, 칸 높이가 균일하지 않을 경우 취소
							downable = false;
						}
					}
					if(downable) {							//내려갈 수 있으면, 현재 칸 하나 낮추고, 올라갈 수 있는 칸을 1(초기화) - 사다리 길이로 설정(내려가기 위해 놓은 칸)
						--now_height;
						upable = 1 - L;
					}
					else break;								//내려갈 수 없으면 이번 길 종료
				}
				else break;									//칸 높이가 -1 ~ +1의 차를 벗어날 경우 길 종료
				if(j == N - 1) ++goable; 					//끝까지 왔다면 길 추가
			}
		}
		for (int i = 0; i < N; i++) {
			now_height = map[0][i];
			upable = 1;
			for (int j = 1; j < N; j++) {
				if(map[j][i] == now_height) {
					++upable;
				}
				else if(map[j][i] == now_height + 1) {
					if(upable >= L) {
						++now_height;
						upable = 1;
					}
					else break;
				}
				else if(map[j][i] == now_height - 1) {
					downable = true;
					for (int f = 0; f < L; f++) {
						if(j + f == N || map[j + f][i] != now_height - 1) {
							downable = false;
						}
					}
					if(downable) {
						--now_height;
						upable = 1 - L;
					}
					else break;
				}
				else break;
				if(j == N - 1) ++goable; 
			}
		}
		
		System.out.println(goable);
	}

}
