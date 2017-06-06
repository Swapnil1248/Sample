
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridSearch {
	public static void main(String[] args) throws IOException {
		// Solution solution = new Solution();
		try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
			int numTestCases = Integer.parseInt(input.readLine());
			assert numTestCases >= 1 && numTestCases <= 5;
			int[][] grid;
			int[][] pattern;

			for (int t = 0; t < numTestCases; t++) {
				grid = buildArray(input);
				pattern = buildArray(input);

				System.out.println(findPattern(grid, pattern));
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String findPattern(int[][] grid, int[][] pattern) {

		for (int R = 0; R < grid.length - pattern.length + 1; R++) {
			for (int C = 0; C < grid[0].length - pattern[0].length + 1; C++) {
				outerLoop: 
					for (int r = 0; r < pattern.length; r++) {
					for (int c = 0; c < pattern[0].length; c++) {
						if (grid[R + r][C + c] != pattern[r][c]) {
							break outerLoop;
						}
					}
					if (r == pattern.length - 1) {
						return "YES";
					}
				}
			}
		}
		return "NO";
	}

	public static int[][] buildArray(BufferedReader input) throws IOException {
		String[] sizeParameters = input.readLine().split("\\s+");
		int rows = Integer.parseInt(sizeParameters[0]);
		int columns = Integer.parseInt(sizeParameters[1]);
		int[][] array = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			String rowOfNumbers = input.readLine();
			for (int j = 0; j < columns; j++) {
				array[i][j] = Character.getNumericValue(rowOfNumbers.charAt(j));
			}
		}

		return array;
	}

}