	package ST200124;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	
	public class Solution_9317_석찬이의받아쓰기 {
	
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int T = Integer.parseInt(br.readLine()), t= 0;
			while(t != T) {
				int len = Integer.parseInt(br.readLine());
				String ori = br.readLine();
				String write = br.readLine();
				for (int i = len - 1; i != -1; --i) {
					if(ori.charAt(i) != write.charAt(i)) --len;
				}
				sb.append('#').append(++t).append(' ').append(len).append('\n');
			}
			System.out.println(sb);
		}
	
	}
