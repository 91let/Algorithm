package ST191223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Man implements Comparable<Man>{
   int y;
   int x;
   int turn;
   int power;
   @Override
   public int compareTo(Man target) {
      return this.turn >= target.turn ? 1 : -1;
   }
   public Man() {
      super();
      // TODO Auto-generated constructor stub
   }
   public Man(int y, int x, int turn, int power) {
      super();
      this.y = y;
      this.x = x;
      this.turn = turn;
      this.power = power;
   }
   @Override
   public String toString() {
      return "Man [y=" + y + ", x=" + x + ", turn=" + turn + ", power=" + power + "]";
   }
}

public class Main_15906_변신이동게임 {
   private static int N;
   private static int t;
   private static int r;
   private static int c;
   private static char[][] map;
   private static int[][][] checkmap;
   private static int dy[] = {-1, +1, 0, 0};
   private static int dx[] = {0, 0, -1, +1};
   private static int Answer;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      map = new char[N+1][N+1];
      checkmap = new int[2][N+1][N+1];
      
      for(int i = 1; i<=N; i++) {
         String str = br.readLine();
         for(int j = 1; j<=N; j++) {
            map[i][j] = str.charAt(j-1);
         }
      }
      
      for(int i = 0; i<2; i++) {   // 체크맵 -1로 리셋
         for(int j = 0; j<=N; j++) {
            for(int k = 0; k<=N; k++) {
               checkmap[i][j][k] = -1;
            }
         }
      }
      
      /*
      for(int i = 1; i<=N; i++) {
         for(int j = 1; j<=N; j++) {
            System.out.print(map[i][j] + " ");
         }
         System.out.println();
      }
      */
      play(1, 1);
      
      System.out.println(Answer);
   }

   private static void play(int y, int x) {
      Man man = new Man(y, x, 0, 0);
      checkmap[0][y][x] = 0;
      PriorityQueue<Man> pq = new PriorityQueue<Man>();
      pq.offer(man);
      
      while(!pq.isEmpty()) {
         Man temp = pq.poll();
         int cy = temp.y;
         int cx = temp.x;
         int cturn = temp.turn;
         int cpower = temp.power;
         
         if(cy == r && cx == c) {
            Answer = cturn;
            break;
         }
         
         if(cpower == 1) {   //   변신모드 일 때
            for(int dir = 0; dir<4; dir++) {
               for(int i = 1; i<=N; i++) {
                  int ny = cy + dy[dir] * i;
                  int nx = cx + dx[dir] * i;
                  
                  if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
                     continue;
                  }
                  
                  if(map[ny][nx] == '#') {
                     if(checkmap[1][ny][nx] == -1 || checkmap[1][ny][nx] > cturn + 1) {
                        Man next = new Man(ny, nx, cturn+1, cpower);
                        checkmap[cpower][ny][nx] = cturn + 1;
                        pq.offer(next);
                     }
                     
                     if(checkmap[0][ny][nx] == -1 || checkmap[0][ny][nx] > cturn + 1) {
                        Man next = new Man(ny, nx, cturn + 1, 0);
                        checkmap[0][ny][nx] = cturn + 1;
                        pq.offer(next);
                     }
                     break;
                  }
                  
               }
            }
            
            
         }else {   //   일반모드 일 때
            for(int dir = 0; dir<4; dir++) {
               int ny = cy + dy[dir];
               int nx = cx + dx[dir];
               
               if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
                  continue;
               }
               
               if(checkmap[cpower][ny][nx] == -1 || checkmap[cpower][ny][nx] > cturn + 1) {
                  Man next = new Man(ny, nx, cturn + 1, cpower);
                  checkmap[cpower][ny][nx] = cturn + 1;
                  pq.offer(next);                  
               }
               
            }
            
            if(checkmap[1][cy][cx] == -1 || checkmap[1][cy][cx] > cturn + t) {
               Man next = new Man(cy, cx, cturn + t, 1);
               checkmap[1][cy][cx] = cturn + t;
               pq.offer(next);
            }
            
         }
      }
   }
}
