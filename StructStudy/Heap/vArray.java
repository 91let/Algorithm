package Heap;

public class vArray {
	private int index, max_size;
	public int[] E;
	
	public vArray() {
		this.max_size = 10000000;
		E = new int[max_size];
		index = 0;
	}
	
	public vArray(int max_size) {
		this.max_size = max_size + 1;
		E = new int[max_size];
		index = 0;
	}
	
	public boolean isFull() {
		return !(index < max_size);
	}
	
	public boolean isEmpty() {
		return index < 1;
	}
	
	public void push(int e) {
		if(isFull()) {
			System.out.println("over");
			return;
		}
		E[++index] = e;
		int indexing = index;
		while(indexing > 0 && E[indexing] < E[indexing/2]) {
			int t = E[indexing];
			E[indexing] = E[indexing/2];
			E[indexing/2] = t;
			indexing /= 2;
		}
	}
	
	public int poll() {
		if(isEmpty()) {
			return -Integer.MIN_VALUE;
		}
		int t = E[1], indexing = 1, smaller;
		E[1] = E[index];
		E[index] = t;

		while(indexing * 2 + 1 < index && (E[indexing] > E[indexing * 2] || E[indexing] > E[indexing * 2 + 1])) {
			if(indexing * 2 + 1 > index) smaller = indexing * 2;
			else smaller = (E[indexing * 2] < E[indexing * 2 + 1]) ? indexing * 2 : indexing * 2 + 1 ;
			t = E[indexing];
			E[indexing] = E[smaller];
			E[smaller] = t;
			indexing = smaller;
		}
		
		int result = E[index];
		E[index--] = Integer.MIN_VALUE;
		
		return result;
	}
	
	@Override
	public String toString() {
		String v = "";
		for (int i = 1; i < index + 1; i++) {
			v += i+ ": " + E[i] + " ";
		}
		return v;
	}
}
