package ST191219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17221_인재야머쉬맘잡았어 {
	
	static int Ans;
	
	static void counter(int u_hp, int u_atk, int m_hp, int m_atk, int turn) {
		if(turn > Ans) return;
		attack(u_hp, u_atk, m_hp, m_atk, turn);
		buff(u_hp, u_atk, m_hp, m_atk, turn);
		if(u_atk > 4) counter(u_hp + u_hp / 10, u_atk, m_hp - m_atk, m_atk, turn + 1);
	}
	
	private static void buff(int u_hp, int u_atk, int m_hp, int m_atk, int turn) {
		if(turn > Ans || u_atk < 5) return;
		buff(u_hp - m_atk * 3, u_atk + u_atk / 5, m_hp, m_atk, turn + 1);
		attack(u_hp - m_atk * 3, u_atk + u_atk / 5, m_hp, m_atk, turn + 1);
	}

	private static void attack(int u_hp, int u_atk, int m_hp, int m_atk, int turn) {
		if(u_hp / m_atk < m_hp / u_atk) return;
		if(u_hp / m_atk == m_hp / u_atk && u_hp % m_atk == 0 && m_hp % u_atk != 0) return;
		Ans = Math.min(Ans, turn + m_hp / u_atk + ((m_hp % u_atk != 0) ? 1: 0));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
		Ans = X / Y + ((X % Y != 0) ? 1: 0);
		counter(A, B, X, Y, 0);
		System.out.println(Ans);
	}

}
