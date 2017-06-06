package com.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP2
{

	public static void main(String[] args) throws IOException
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int numberOfTest = Integer.parseInt(br.readLine());
		for (int i = 0; i < numberOfTest; i++)
		{
			int numberOfElements = Integer.parseInt(br.readLine());
			String arrayString = br.readLine();
			String[] arrayElements = arrayString.split("\\s+");
			long[] array = new long[numberOfElements];
			for (int j = 0; j < numberOfElements; j++)
			{
				array[j] = Long.parseLong(arrayElements[j]);
			}
			output.append(maxSubArray(array) + " " + sumAllPositive(array) + "\n");
		}
		System.out.println(output.toString());
	}

	public static long maxSubArray(long[] array)
	{
		long currentSum = array[0];
		long biggestSum = array[0];
		int currentIndex = -1;
		int biggestStartIndex = -1;
		int biggestEndIndex = -1;
		long val = 0;
		for (int i = 1; i < array.length; i++)
		{
			val = currentSum + array[i];
			if (val > array[i])
			{
				if (currentSum > array[i])
					currentIndex = i;
				currentSum = val;
			}
			else
			{
				currentSum = array[i];
			}

			if (currentSum > biggestSum)
			{
				biggestSum = currentSum;
				biggestStartIndex = currentIndex;
				biggestEndIndex = i;
			}

		}
		return biggestSum;
	}

	public static long sumAllPositive(long[] array)
	{
		long sum = 0;
		long maxMin = array[0];
		boolean negArray = false;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] > 0)
			{
				sum = sum + array[i];
				negArray = true;
			}
			else if (maxMin < array[i])
			{
				maxMin = array[i];
			}
		}
		if (!negArray)
		{
			sum = maxMin;
		}
		return sum;
	}
}