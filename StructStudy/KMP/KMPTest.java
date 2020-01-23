package KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMPTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int tLength = T.length;
		int pLength = P.length;
		
		// 1. 실패함수 만들기
		int[] fail = new int[pLength];
		for(int i=1, j=0; i<pLength; i++) {	// i: 접미사 포인터, j: 접두사 포인터
			while(j > 0 && P[i] != P[j]) j = fail[j-1];
			
			if(P[i] == P[j]) fail[i] = ++j;
		}
		
		int cnt = 0;
		for(int i=0, j=0; i<tLength; i++) {	// i: 텍스트 포인터, j: 패턴 포인터
			while(j > 0 && T[i] != P[j]) j = fail[j-1];
			
			if(T[i] == P[j]) {			// 두 글자 일치
				if(j == pLength - 1) {	// 일치한 문자가 패턴의 끝이면
					cnt++;				// 결과 카운트 증가
					j = fail[j];		// j까지 맞은 경우이므로 실패함수 fail[j]를 이용하여 j 포인터 이동
				}
				else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}