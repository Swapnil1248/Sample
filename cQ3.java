import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class cQ3 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int T = Integer.parseInt(br.readLine());
			for (int i = 1; i <= T; i++) {
				int ans = 0;
				int N = Integer.parseInt((br.readLine()));
				ArrayList<String> first = new ArrayList<String>();
				ArrayList<String> second = new ArrayList<String>();
				for (int z = 0; z < N; z++) {
					String[] line = br.readLine().split("\\s+");
					first.add(line[0]);
					second.add(line[1]);
				}
				for (int j = 0; j < N; j++) {
					String aF = first.remove(j);
					String aS = second.remove(j);
					int newMax = 0;
					for (int k = 0; k < N - 1; k++) {
						if (first.contains(first.get(k)) && second.contains(second.get(k))) {
							newMax++;
						}
					}
					ans = Math.max(ans, newMax);
					first.add(j, aF);
					second.add(j, aS);
				}
				System.out.println("Case #" + i + ": " + ans);
			}
		} catch (IOException e) {
		}
	}

}
