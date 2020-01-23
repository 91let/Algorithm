package ST191001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
class Solution_D4_보급로_java1등{
    static class Vertex implements Comparable<Vertex> {
        int x;
        int y;
        int cost;
 
        public Vertex(int x, int y, int cost) {
            super();
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }
 
    static int size;
    static int map[][];
    static boolean check[][];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
 
        // ======================================================맵받음
        for (int p = 0; p < testCase; p++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            check = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                String s = br.readLine();
                for (int j = 0; j < size; j++) {
                    map[i][j] = s.charAt(j) - 48;
                }
            }
            // ======================================================bfs돌릴 세팅
            int newX = 0, newY = 0;
            Vertex current = null;
            int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            queue.add(new Vertex(0, 0, 0));
            check[0][0] = true;
 
            // ======================================================bfs....
            while (!queue.isEmpty()) {
                current = queue.poll();
                for (int i = 0; i < direction.length; i++) {
                    newX = current.x + direction[i][0];
                    newY = current.y + direction[i][1];
                    if (newX >= 0 && newX < size && newY >= 0 && newY < size
                            && check[newX][newY] == false) {
                        queue.add(new Vertex(newX, newY, current.cost + map[newX][newY]));
                        check[newX][newY] = true;
                        if (newX == size - 1 && newY == size - 1) {
                            System.out.print("#" + (p + 1) + " " + current.cost);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}