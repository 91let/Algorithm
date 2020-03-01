package ST200301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4534_트리흑백색칠 {
	
	private static final long div = 1000000007;
	
	private static class Node{
		ArrayList<Node> connect;
		long white;
		long black;
		boolean visited;
		public Node() {
			connect = new ArrayList<Node>();
			visited = false;
			white = 1;
			black = 1;
		}
		
		public void getWB() {
			this.visited = true;
			for (Node node : this.connect) {
				if(!node.visited) {
					node.getWB();
					this.white = this.white * (node.white + node.black) % div;
					this.black = this.black * node.white % div;
				}
			}
		}
	}
	
	private static Node[] Tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		while(t < T) {
			int N = Integer.parseInt(br.readLine()) + 1;
			Tree = new Node[N];
			for (int i = 1; i < N; i++) Tree[i] = new Node();
			for (int i = 2; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				Tree[x].connect.add(Tree[y]);
				Tree[y].connect.add(Tree[x]);
			}
			Tree[1].getWB();
			sb.append('#').append(++t).append(' ').append((Tree[1].black + Tree[1].white) % div).append('\n');
		}
		System.out.print(sb);
	}

}
