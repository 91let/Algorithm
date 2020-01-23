package ST191016;

import java.util.Scanner;

public class Main_9655_돌게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() + 1;
		if(N % 2 != 0) System.out.println("SK");
		else System.out.println("CY");
	}

}
