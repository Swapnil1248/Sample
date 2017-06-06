import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSheep {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long T = Long.parseLong(br.readLine());
			for (int i = 1; i <= T; i++) {
				String N = (br.readLine());
				System.out.println("Case #" + i + ": " + solve(N));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String solve(String N) {
		// TODO Auto-generated method stub
		String n = N;
		int[] check = new int[10];
		int count = 10;
		if (Long.parseLong(N) == 0)
			return "INSOMNIA";
		
		int j = 1;

		while (true) {
			n = (Long.parseLong(N) * j++) + "";
			int len = n.length();
			for (int i = 0; i < len; i++) {
				if (check[Character.getNumericValue(n.charAt(i))] == 0) {
					count--;
				}
				check[Character.getNumericValue(n.charAt(i))]++;
				if (count == 0) {
					return n.toString();
				}
			}
		}

	}

}