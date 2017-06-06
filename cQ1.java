import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class cQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			for (int i = 1; i <= T; i++) {
				String N = (br.readLine());
				System.out.println("Case #" + i + ": " + solve(N.toCharArray()));
			}
		} catch (IOException e) {
		}
	}

	public static String solve(char[] arr) {
		int len = arr.length;
		int[] count = new int[26];
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (arr[i] == 'Z') {
				// count['Z' - 65]--;
				count['E' - 65]--;
				count['R' - 65]--;
				count['O' - 65]--;
				a.add(0);
			} else if (arr[i] == 'W') {
				count['T' - 65]--;
				// count['W' - 65]--;
				count['O' - 65]--;
				a.add(2);
			} else if (arr[i] == 'U') {
				count['F' - 65]--;
				// count['U' - 65]--;
				count['O' - 65]--;
				count['R' - 65]--;
				a.add(4);
			} else if (arr[i] == 'X') {
				count['S' - 65]--;
				count['I' - 65]--;
				// count['X' - 65]--;
				a.add(6);
			} else if (arr[i] == 'G') {
				count['I' - 65]--;
				count['E' - 65]--;
				// count['G' - 65]--;
				count['H' - 65]--;
				count['T' - 65]--;
				a.add(8);
			} else {
				count[arr[i] - 65]++;
			}
		}
		int one = count['O' - 65];
		if (one != 0) {
			count['O' - 65] -= one;
			count['N' - 65] -= one;
			count['E' - 65] -= one;
			for (int i = 0; i < one; i++)
				a.add(1);
		}
		int three = count['T' - 65];
		if (three != 0) {
			count['T' - 65] -= three;
			count['H' - 65] -= three;
			count['R' - 65] -= three;
			count['E' - 65] -= three;
			count['E' - 65] -= three;
			for (int i = 0; i < three; i++)
				a.add(3);
		}
		int five = count['F' - 65];
		if (five != 0) {
			count['F' - 65] -= five;
			count['I' - 65] -= five;
			count['V' - 65] -= five;
			count['E' - 65] -= five;
			for (int i = 0; i < five; i++)
				a.add(5);
		}
		int seven = count['S' - 65];
		if (seven != 0) {
			count['S' - 65] -= seven;
			count['E' - 65] -= seven;
			count['V' - 65] -= seven;
			count['E' - 65] -= seven;
			count['N' - 65] -= seven;
			for (int i = 0; i < seven; i++)
				a.add(7);
		}
		int nine = count['I' - 65];
		if (nine != 0) {
			count['I' - 65] -= nine;
			count['N' - 65] -= nine;
			count['E' - 65] -= nine;
			count['N' - 65] -= nine;
			for (int i = 0; i < nine; i++)
				a.add(9);
		}
		
		Collections.sort(a);
		
		StringBuilder sb = new StringBuilder();
		for (Integer i : a) {
			sb.append(i);
		}
		return sb.toString();
	}
}