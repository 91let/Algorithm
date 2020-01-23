package ST191010;

import java.util.Scanner;

public class Main_3111_검열 {
	
	static class FrontStack{
		public char[] buff;
		int size, compsize, point;
		String comp;
		public FrontStack(int size, String comp) {
			this.size = size;
			this.buff = new char[size];
			this.comp = comp;
			this.compsize = comp.length();
			this.point = -1;
		}
		
		boolean isEmpty() {
			return this.point == -1;
		}
		
		boolean isFull() {
			return this.point == this.size - 1;
		}
		
		int amount() {
			return this.point + 1;
		}
		
		boolean push(char e) {
			if(isFull()) return false;
			this.buff[++point] = e;
			if(e == this.comp.charAt(compsize - 1)) return delete();
			return false;
		}
		
		char pop() {
			if(isEmpty()) return 0;
			return buff[this.point--];
		}
		
		boolean delete() {
			if(!(this.amount() < this.compsize)) {
				for (int i = 0; i < compsize; ++i) {
					if(buff[point + 1 - compsize + i] != comp.charAt(i)) return false;
				}
				this.point -= this.compsize;
				return true;
			}
			return false;
		}
		@Override
		public String toString() {
			char[] tmp = new char[this.amount()];
			for (int i = 0; i < this.amount(); ++i) tmp[i] = buff[i];
			return new String(tmp);
		}
	}
	
	static class EndStack{
		public char[] buff;
		int size, compsize, point;
		String comp;
		public EndStack(int size, String comp) {
			this.size = size;
			this.buff = new char[size];
			this.comp = comp;
			this.compsize = comp.length();
			this.point = size;
		}
		
		boolean isEmpty() {
			return this.point == this.size;
		}
		
		boolean isFull() {
			return this.point == 0;
		}
		
		int amount() {
			return this.size - this.point;
		}
		
		boolean push(char e) {
			if(isFull()) return false;
			this.buff[--point] = e;
			if(e == this.comp.charAt(0)) return delete();
			return delete();
		}
		
		char pop() {
			if(isEmpty()) return 0;
			return this.buff[this.point++];
		}
		
		boolean delete() {
			if(!(this.amount() < this.compsize)) {
				for (int i = 0; i < compsize; ++i) {
					if(buff[point + i] != comp.charAt(i)) return false;
				}
				this.point += this.compsize;
				return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			char[] tmp = new char[this.amount()];
			for (int i = 0; i < this.amount(); ++i) {
				tmp[i] = buff[point + i];
			}
			return new String(tmp);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String T = sc.next();
		
		FrontStack fs = new FrontStack(T.length(), A);
		EndStack es = new EndStack(T.length(), A);
		int L = -1, R = T.length();
		boolean flag = true;
		while(L != R) {
			while(++L != R && !fs.push(T.charAt(L)));
			if(!(L != R)) {
				flag = true;
				break;
			}
			while(--R != L && !es.push(T.charAt(R)));
			if(!(L != R)) {
				flag = false;
				break;
			}
		}
		while(true) {
			if(flag) {
				while(!es.isEmpty() && !fs.push(es.pop()));
				if(es.isEmpty()) break;
				flag = !flag;
			}
			else {
				while(!fs.isEmpty() && !es.push(fs.pop()));
				if(fs.isEmpty()) break;
				flag = !flag;
			}
		}
		System.out.println(fs.toString() + es.toString());
		sc.close();
	}

}
