import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MaxSumPathGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/swapnilk/Desktop/MaxPathGrid.txt"))) {
			String[] line = br.readLine().split("\\s+");
			int R = Integer.parseInt(line[0]);
			int C = Integer.parseInt(line[1]);
			int[][] grid = new int[R][C];
			for (int i = 0; i < R; i++) {
				line = br.readLine().split(",");
				for (int j = 0; j < C; j++) {

					grid[i][j] = Integer.parseInt(line[j].trim());
				}
			}

			System.out.println(solve(grid, R, C));
		} catch (IOException e) {

		}

	}

	private static int solve(int[][] grid, int R, int len) {
		int[][] dp = new int[R][len];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < R; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < len; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < len; j++) {

				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		System.out.println(Arrays.deepToString(grid));
		System.out.println(Arrays.deepToString(dp));
		int sum = grid[R - 1][len - 1];
		StringBuilder sb = new StringBuilder();
		System.out.println(sum + " grid[" + (R - 1) + "][" + (len - 1) + "]");
		// Sir you are great!!!
		
		sum = grid[R - 1][len - 1];
		int i = R - 1;

		int j = len - 1;
		sb = new StringBuilder();
		while (i != 0 && j != 0) {
			if (dp[i][j] - grid[i][j] == dp[i - 1][j]) {
				sb.append("D");
				sum += grid[i - 1][j];
				System.out.println(sum + " grid[" + (i - 1) + "][" + j + "]");

				i = i - 1;
			} else if (dp[i][j] - grid[i][j] == dp[i][j - 1]) {
				sb.append("R");
				sum += grid[i][j - 1];
				System.out.println(sum + " grid[" + i + "][" + (j - 1) + "]");

				j = j - 1;
			}
		}
		while (i != 0) {
			i--;
			sum += grid[i][j];
			System.out.println(sum + " grid[" + i + "][" + j + "]");
			sb.append("D");
		}

		while (j != 0) {
			j--;
			sum += grid[i][j];
			System.out.println(sum + " grid[" + i + "][" + j + "]");
			sb.append("R");
		}
		System.out.println("Sum is " + sum);

		System.out.println(sb.reverse());

		return dp[R - 1][len - 1];
	}

}
