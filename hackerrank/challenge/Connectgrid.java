package hackerrank.challenge;

import java.util.*;

public class Connectgrid
{
	static boolean[][] visited;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] grid = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				grid[i][j] = sc.nextInt();
				visited[i][j] = false;
			}
		}
		int max = 0;
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (!visited[i][j])
				{
					max = Math.max(max, findConnectedGrid(grid, i, j, 0, M, N));
				}
			}
		}
		System.out.println(max);
	}

	private static int findConnectedGrid(int[][] grid, int i, int j, int count, int m, int n)
	{
		if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        if(grid[i][j] == 0) return 0;
        else return 1 +
            findConnectedGrid(grid, i-1, j-1, count, m, n) +
            findConnectedGrid(grid, i-1, j, count, m, n) + 
            findConnectedGrid(grid, i-1, j+1, count, m, n) + 
            findConnectedGrid(grid, i, j-1, count, m, n) + 
            findConnectedGrid(grid, i, j+1, count, m, n) + 
            findConnectedGrid(grid, i+1, j-1, count, m, n) + 
            findConnectedGrid(grid, i+1, j, count, m, n) + 
            findConnectedGrid(grid, i+1, j+1, count, m, n);
	}

}