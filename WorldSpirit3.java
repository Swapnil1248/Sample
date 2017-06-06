import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WorldSpirit3 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] line = br.readLine().split("\\s+");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				String rowOfNumbers = br.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = rowOfNumbers.charAt(j) == 'G' ? 1 : 0;
				}
			}
			System.out.println(solve(arr));

		} catch (IOException e) {

		}

	}
	
	public static int solve(int[][] arr){
		return 0;
	}
	
	 public static boolean isValid(){
		 return false;
	 }

}
