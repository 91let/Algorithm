package ST191016;

import java.util.Scanner;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lv = 0, st_p = -1, bu_p = -1;
		String in = sc.nextLine();
		char[] stack = new char[in.length()];
		char[] buff = new char[in.length()];
		for (int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == '<') {
				while(st_p > -1) buff[++bu_p] = stack[st_p--];
				++lv;
				buff[++bu_p] = '<';
			}
			else if(in.charAt(i) == '>') {
				--lv;
				buff[++bu_p] = '>';
			}
			else if(in.charAt(i) == ' ') {
				while(st_p > -1) buff[++bu_p] = stack[st_p--];
				buff[++bu_p] = ' ';
			}
			else if(lv < 1) {
				stack[++st_p] = in.charAt(i);
			} else buff[++bu_p] = in.charAt(i);
		}
		while(st_p > -1) buff[++bu_p] = stack[st_p--];
		System.out.println(buff);
	}

}
