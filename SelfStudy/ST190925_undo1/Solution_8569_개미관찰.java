package ST190925_undo1;

import java.util.Scanner;

public class Solution_8569_개미관찰 {

	static class MyHeap{
		int max_size, index;
		double[][] E;
		public MyHeap() {
			max_size = 100;
			E = new double[max_size][3];
			index = 0;
		}
		
		void isFull() {
			double[][] T = new double[max_size + 100][3];
			for (int i = 1; i < max_size; i++) T[i] = E[i];
			max_size += 100;
			E = T;
		}
		
		boolean isEmpty() {
			return index < 1;
		}
		
		void in(double[] input) {
			isFull();
			E[++index] = input;
			int p = index, np;
			double[] tmp;
			while(p > 0) {
				np = p/2;
				if(E[p][2] < E[np][2]) {
					tmp = E[p];
					E[p] = E[np];
					E[np] = tmp;
				}
				else break;
				p = np;
			}
		}
		
		double[] out() {
			double[] output = E[1], tmp = E[index--];
			int p = 1, np = 2;
			while(np < index + 1) {
				if(np < index && E[np][2] > E[np + 1][2]) ++np;
				if(tmp[2] < E[np][2]) break;
				E[p] = E[np];
				p = np;
				np *= 2;
			}
			E[p] = tmp;
			
			return output;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while(t < T) {
			int N = sc.nextInt(), K = sc.nextInt();
			double r = -1;
			long[] P = new long[N];
			double[] S = new double[N];
			boolean[] check = new boolean[N];
			MyHeap q = new MyHeap();
			for (int i = 0; i < N; ++i) {
				P[i] = sc.nextLong();
				S[i] = sc.nextDouble();
			}
			for (int i = 0; i < N - 1; ++i) {
				for (int j = i + 1; j < N; j++) {
					if(P[i] < P[j] && S[i] > S[j] || P[i] > P[j] && S[i] < S[j]) q.in(new double[] {i, j, (P[i] - P[j]) / (S[j] - S[i])});//힙 삽입
				}
			}
			while(!q.isEmpty()) {
				double[] output = q.out();
				int from = (int)output[0];
				int to = (int)output[1];
				double time = output[2];
				if(check[from] || check[to]) continue;
				if(K / 2 > 0) {
					check[from] = true;
					check[to] = true;
					K -=2;
				}
				if(K < 1) {
					r = time;
					break;
				}
				else if(K < 2) {
					double[] tmp = null;
					while(!q.isEmpty()) {
						tmp = q.out();
						if(check[(int)tmp[0]] || check[(int)tmp[1]]) continue;
						if(K < 1) {
							r = tmp[2];
							break;
						}
						else {
							if(to == (int)tmp[0] || to == (int)tmp[1]) check[to]= true;
							else if(from == (int)tmp[0] || from == (int)tmp[1]) check[from]= true;
							--K;
						}
					}
					break;
				}
			}
			System.out.println("#" + ++t + ' ' + r);
		}
	}

}
