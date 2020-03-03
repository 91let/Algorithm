package ST200303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1907_모래성쌓기 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> q = new LinkedList<>();
        int[] dh = {-1, -1, -1, 0, 0, 1, 1, 1}, dw = {-1, 0, 1, -1, 1, -1, 0, 1};
        int T = Integer.parseInt(br.readLine()), t = 0;
        while(t < T){
        	st = new StringTokenizer(br.readLine());
            int count = 0, H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            int[][] Count = new int[H][W];
            boolean[][] visited = new boolean[H][W];
 
            for (int i = 0; i < H; i++) {
                String tmp = br.readLine();
                for (int j = W - 2; j > 0; --j) {
                    if (tmp.charAt(j) != '.') {
                        map[i][j] = tmp.charAt(j) - '0';
                    }
                }
            }
            
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 0) {
                        visited[i][j] = true;
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dh[d], nj = j + dw[d];
                            if (ni < 0 || ni >= H || nj < 0 || nj >= W)
                                continue;
                            if (map[ni][nj] > 0) {
                                Count[ni][nj]++;
                                if (Count[ni][nj] >= map[ni][nj] && !visited[ni][nj]) {
                                    visited[ni][nj] = true;
                                    q.offer(ni * 1000 + nj);
                                }
                            }
                        }
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int tmp = q.poll(), c = tmp % 1000, r = tmp / 1000;
                    map[r][c] = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dh[d];
                        int nc = c + dw[d];
                        if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc])
                            continue;
                        if (map[nr][nc] > 0) {
                            Count[nr][nc]++;
                            if (Count[nr][nc] >= map[nr][nc]) {
                                visited[nr][nc] = true;
                                q.offer(nr * 1000 + nc);
                            }
                        }
                    }
                }
                ++count;
            }
            sb.append('#').append(++t).append(' ').append(count).append('\n');
        }
        System.out.print(sb);
    }
 
}
