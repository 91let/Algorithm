package ST191016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int a = in.length();
		for (int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == 'c') if(i + 1 < in.length() && (in.charAt(i + 1) == '=' || in.charAt(i + 1) == '-')) --a;
			if(in.charAt(i) == 'd') {
				if(i + 2 < in.length() && in.charAt(i + 1) == 'z' && in.charAt(i + 2) == '=') {
					a -= 2;
					i += 2;
				}
				if(i + 1 < in.length() && in.charAt(i + 1) == '-') --a;
			}
			if(in.charAt(i) == 'l') {
				if(i + 1 < in.length() && in.charAt(i + 1) == 'j') --a;
			}
			if(in.charAt(i) == 'n') {
				if(i + 1 < in.length() && in.charAt(i + 1) == 'j') --a;
			}
			if(in.charAt(i) == 's') {
				if(i + 1 < in.length() && in.charAt(i + 1) == '=') --a;
			}
			if(in.charAt(i) == 'z') {
				if(i + 1 < in.length() && in.charAt(i + 1) == '=') --a;
			}
		}
		System.out.println(a);
	}

}
