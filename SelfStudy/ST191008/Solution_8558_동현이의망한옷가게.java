package ST191008;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_8558_동현이의망한옷가게 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()), t = 0;
		long ans, price, tmp;
		while(t != T) {
			int N = Integer.parseInt(br.readLine());
            ans = Long.parseLong(br.readLine()) - 1;
            price = 2;
            while(--N != 0) {
            	tmp = Integer.parseInt(br.readLine());
            	if(tmp < price) {
            		continue;
            	} else if(tmp == price) {
            		++price;
            	} else {
            		ans += tmp / price;
            		if(tmp % price == 0) --ans;
            	}
            }
			sb.append('#').append(++t).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}

}

/*
1
14
3
2
6
7
2
2
2
2
10000000
2
2
2
2
100000000
*/