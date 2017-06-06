package com.dp;

import java.io.IOException;

public class DP4
{
	public static void main(String[] args) throws IOException
	{
		int N = 10;
		int[] ar = new int[] { 2,4,2,6,1,7,8,9,2,1 };

		int[] cc = new int[N];
		cc[0] = 1;
		for (int i = 1; i < N; i++)
		{
			cc[i] = 1;
			if (ar[i] > ar[i - 1])
			{
				cc[i] += cc[i - 1];
			}
			else
			{
				for (int j = i; j > 0 && ar[j] < ar[j - 1] && cc[j] == cc[j - 1]; cc[--j] += 1)
				{
					
				}
			 
			}
			
		}

		long sum = 0;
		for (int i = 0; i < N; i++)
		{
			System.out.println(cc[i]);
			sum += cc[i];
		}
		System.out.print(sum);
	}
}
