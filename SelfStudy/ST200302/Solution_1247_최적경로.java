package ST200302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	private static int N;
	private static int End;
    private static int[][] points;
    private static int cache[][];
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()), t = 0;
        while(t < T){
            N = Integer.parseInt(br.readLine());
            End = (1 << (N + 2)) - 4;
            points = new int[N + 2][2];
            cache = new int[N + 2][1 << N + 2];
            for(int i = 0; i < N + 2; i ++){
                Arrays.fill(cache[i], -1);
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N + 2; i ++){
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }
            int answer = Integer.MAX_VALUE;
            for(int i = 2; i < N + 2; i ++){
                answer = Math.min(answer, Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1] - points[0][1])
                        + findMinDistance(i, 1 << i));
            }
            sb.append('#').append(++t).append(' ').append(answer).append("\n");
        }
        System.out.print(sb);
    }
    
    private static int findMinDistance(int node, int visited){
        if(visited == End){
            return Math.abs(points[1][0] - points[node][0]) + Math.abs(points[1][1] - points[node][1]);
        }
        if(cache[node][visited] != -1) return cache[node][visited];
        int ret = Integer.MAX_VALUE;
        for(int next = 2; next < N + 2; next ++){
            if((visited & 1 << next) == 0){
                ret = Math.min(ret, Math.abs(points[next][0] - points[node][0]) + Math.abs(points[next][1] - points[node][1]) + findMinDistance(next, visited | 1 << next));
            }
        }
        return cache[node][visited] = ret;
    }
}
