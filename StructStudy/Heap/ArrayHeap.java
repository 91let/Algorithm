package Heap;

public class ArrayHeap {
	public int[][] E;
	private int maxsize, size;
	public ArrayHeap(int maxsize) {
		this.maxsize = maxsize + 1;
		E = new int[this.maxsize][3];
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size < 1;
	}
	public void push(int[] in){
		E[++size] = in;
		int p = size, np;
		int[] tmp;
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
	public int[] poll() {
		int[] re = E[1], tmp = E[size--];
		int p = 1, np = 2;
		while(np < size + 1) {
			if(np < size && E[np][2] > E[np + 1][2]) ++np;
			if(tmp[2] < E[np][2]) break;
			E[p] = E[np];
			p = np;
			np *= 2;
		}
		E[p] = tmp;
		
		return re;
	}
	public String toString() {
		String tmp = "";
		for (int i = 1; i < size + 1; i++) {
			tmp += "{" +E[i][0] + ", " + E[i][1] + ", " + E[i][2] + "} ";
		}
		return tmp;
	}
}
