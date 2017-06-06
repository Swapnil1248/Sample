package com.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP3
{
	public static void main(String[] args)
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner s = new Scanner(System.in);
		int n, m;
		/*
		 * long[] U = new long[m]; n = s.nextInt(); m = s.nextInt(); for (int c = 0; c < m; c++) { U[c] = s.nextInt(); }
		 */
		n = 5;
		
		long[] U = { 1, 2, 5, 10, 20, 50, 100 };
		m = U.length;
		long[][] MAT = new long[n + 1][m];
		for (int i =0; i < m; i++)
		{
			MAT[0][i] = 1;
		}

		for (int i = 1; i < n + 1; i++)
		{
			for (int k = 0; k < m; k++)
			{
				long a, b;
				if (i - U[k] >= 0)
				{
					a = MAT[i - (int) U[k]][k];
				}
				else
				{
					a = 0;
				}
				if (k >= 1)
				{
					b = MAT[i][k - 1];
				}
				else
				{
					b = 0;
				}
				MAT[i][k] = a + b;
			}
		}
		System.out.print("  [ ");
		for (int j = 0; j < m; j++)
		{
			System.out.print(" "+U[j] +" ");
		}
		System.out.print("]");
		System.out.println("");
		for (int i = 0; i < MAT.length; i++)
		{
			System.out.print(i+" [ ");
			for (int j = 0; j < m; j++)
			{
				System.out.print(" "+MAT[i][j] + " ");
			}
			System.out.print("]");
			System.out.println("");
		}
	}
}
