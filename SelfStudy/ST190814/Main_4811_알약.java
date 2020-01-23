package ST190814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4811_알약 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		long[] results = new long[31];
		long[][] mul = new long[31][32];
		long[] sums = new long[31];
		results[1] = 1;
		results[2] = 2;
		sums[2] = 2;
		mul[2][2] = 1;
		int tmp;
		//s5 - 1 + c4*2
		for (int i = 3; i < 31; i++) {
			for (int j = 2; j <= i; j++) {
				sums[i] += j;
			}
			for (int j = i; j > 2 ; j--) {
				mul[i][j] = mul[i][j+1] + mul[i-1][j-1];
			}
			mul[2] = mul[3];
			for (int j = 2; j <= i; j++) {
				results[i] += mul[i][j]*sums[j];
			}
		}
//		for (int i = 0; i < 31; i++) {
//			System.out.println(results[i]);
//		}
		while(true) {
			tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) break;
			st.append(results[tmp]).append("\n");
		}
		System.out.println(st);
	}

}
/*
W = 1
H = 0
c1 -> c2 (c3)
1 0 <-2 (32)	s3
3 + 2
c2 -> c3 (c4)
1 1 0 0 <- 3 (432)	s4
   1 1 1
1 0 1 0 <- 2 (32)	s3
     1 1
4 + 32*2
c3 -> c4 (c5)
1 1 1 0 0 0 <- 4 (5432)	s5
     1 1 1 1
1 1 0 1 0 0 <- 3 (432)	s4
       1 1 1
1 1 0 0 1 0 <- 2 (32)	s3
         1 1
1 0 1 1 0 0 <- 3 (432)	s4
       1 1 1
1 0 1 0 1 0 <- 2 (32)	s3
         1 1
5+ 43232 * 3 - 32
c4 -> c5 (c6)
1 1 1 1 0 0 0 0 <- 5 (65432) 20 s6 -->s7 s6 s5 s4 s3
1 1 1 0 1 0 0 0 <- 4 (5432)  14 s5 -->   s6 s5 s4 s3
1 1 1 0 0 1 0 0 <- 3 (432)    9 s4 -->      s5 s4 s3
1 1 1 0 0 0 1 0 <- 2 (32)     5 s3 -->         s4 s3
 
1 1 0 1 1 0 0 0 <- 4 (5432)  14 s5 -->   s6 s5 s4 s3
1 1 1 0 0 1 0 0 <- 3 (432)    9 s4 -->      s5 s4 s3
1 1 1 0 0 0 1 0 <- 2 (32)     5 s3 -->         s4 s3

1 1 0 0 1 1 0 0 <- 3 (432)    9 s4 -->      s5 s4 s3
1 1 1 0 0 0 1 0 <- 2 (32)     5 s3 -->         s4 s3

1 0 1 1 1 0 0 0 <- 4 (5432)		s5 -->   s6 s5 s4 s3
1 1 1 0 0 1 0 0 <- 3 (432)    9 s4 -->      s5 s4 s3
1 1 1 0 0 0 1 0 <- 2 (32)     5 s3 -->         s4 s3

1 0 1 0 1 1 0 0 <- 3 (432)		s4 -->      s5 s4 s3
1 1 1 0 0 0 1 0 <- 2 (32)     5 s3 -->         s4 s3
6+ 543243232*4 - 43232
중간부터 끝에만 1 삽입 가능
0은 항상 맨 끝에
*/

/**
 * c1 : 1						1
 * c2 : 2						2																	s2 - 1
 * c3 : 5						3 + 								2								s3 - 1
 * c4 : 14						(4 + 			3 + 		2) + 	(3 + 		2)					(s4 - 1) + (s3 - 1)
 * c5 : 42						(5 + 4 + 3 + 2) + (4 + 3 + 2) + (3 + 2) + (4 + 3 + 2) + (3 + 2) 	(s5 - 1) + (s4 - 1)2 + (s3 - 1)2
 * c6 : 132						(6+5+4+3+2)+(5+4+3+2)+(4+3+2)+(3+2) + c5 + c5						(s6 - 1) + (s5 - 1)3 + (s4 - 1)5 + (s3 - 1)5
 * c7 :                         765432 () c6+c6+c6                                         			(s7 - 1) + (s6 - 1)4 + (s5 - 1)9 + (s4 - 1)14 + (s3 - 1)14
 * c3 :            1
 * c4 :          1 1
 * c5 :        1 2 2
 * c6 :      1 3 5 5
 * c7 :  1 4 9 14 14
 * c8 : 1 5 15 24 24
 */
