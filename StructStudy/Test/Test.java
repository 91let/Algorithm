package Test;

import java.util.Arrays;
import java.util.Comparator;

import Heap.*;

public class Test {

	public static void main(String[] args) {
		int size = 10;
		ArrayHeap heap = new ArrayHeap(size + 1);
		for (int i = 0; i < size; i++) {
			int te = (int)(Math.random() * 10000000);
			heap.push(new int[] {i, 0, te});
			System.out.print(te + " ");
		}
		System.out.println();
		System.out.println(heap);
		int[][] comp1 = new int[size + 1][3];
		int index = 0;
		while(!heap.isEmpty()) {
			System.out.println(heap.size() + " " + heap.toString());
			comp1[++index] = heap.poll();
		}
		Arrays.sort(heap.E, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
	}

}
