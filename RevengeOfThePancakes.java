import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RevengeOfThePancakes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			for (int i = 1; i <= T; i++) {
				String N = (br.readLine());
				System.out.println("Case #" + i + ": " + solve(N));
			}
		} catch (IOException e) {
		}
	}

	private static int solve(String n) {
		// TODO Auto-generated method stub
		String S = n;
		int len = S.length();
		if (len == 1) {
			if (S.equals("-"))
				return 1;
			else
				return 0;
		}
		int count = 0;
		for (int i = 0; i < len - 1; i++) {

			if (S.charAt(i) != S.charAt(i + 1)) {
				// System.out.println(S);
				StringBuffer sub = new StringBuffer(S.substring(0, i + 1));
				sub = sub.reverse();
				// System.out.println("sub " + sub.toString());
				String sub1 = flip(sub.toString());
				String next = S.substring(i + 1);
				// System.out.println("sub 1 " + sub1);
				// System.out.println("next " + next);
				S = sub1 + next;
				count++;
				// System.out.println(S);
			}

		}
		if (S.charAt(0) == '-')
			count++;
		return count;
	}

	private static String flip(String a) {
		char[] s = a.toCharArray();
		int len = s.length;
		StringBuffer x = new StringBuffer();
		for (int j = 0; j < len; j++) {
			if (s[j] == '-') {
				x.append("+");
			} else {
				x.append("-");
			}
		}

		return x.toString();
	}

}
