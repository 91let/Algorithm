package ST200123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_15961_회전초밥 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()) + 1, k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), count = 0, Ans = 0;
        int[] kind = new int[d];
        ++count;
        ++kind[c];
        int[] All = new int[N + k];
        for (int i = 0; i < N; i++) {
			All[i] = Integer.parseInt(br.readLine());
        	if(i < k) {
        		All[i + N] = All[i];
        		if(++kind[All[i]] == 1) ++count;
        	}
		}
        Ans = count;
        for (int i = 0; i < N; i++) {
            if(--kind[All[i]] == 0) --count;
            if(++kind[All[i + k]] == 1) ++count;
            Ans = Math.max(Ans, count);
        }
        System.out.println(Ans);
    }
 
}