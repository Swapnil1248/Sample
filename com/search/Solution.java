package com.search;

import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scanner = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		int numberofTest = Integer.parseInt(scanner.nextLine());
		for (int n = 0; n < numberofTest; n++)
		{
			int arrayLength = Integer.parseInt(scanner.nextLine());
			// scanner.nextLine();
			String arrayElements = scanner.nextLine();
			String[] stringArrayElements = arrayElements.split(" ");
			int[] inputElement = new int[arrayLength];
			for (int i = 0; i < stringArrayElements.length; i++)
				inputElement[i] = Integer.parseInt(stringArrayElements[i]);

			int index = findIndex(inputElement);
			if (index == -1)
			{
				output.append("NO").append("\n");
			}
			else
			{
				output.append("YES\n");
			}
		}

		System.out.println(output.toString());

	}

	public static int findIndex(int[] array)
	{
		int returnIndex = -1;
		int sumBeforeIndexPart = 0;
		int sumAfterIndexPart = 0;
		int j;
		for (int i = 1; i < array.length; i++)
		{
			for (j = 0; j < array.length; j++)
			{
				if (j < i)
					sumBeforeIndexPart = +array[j];
				else
					sumAfterIndexPart = +array[j];
			}
			// System.out.println("Index "+j+" "+sumBeforeIndexPart+" "+sumAfterIndexPart);
			if (sumBeforeIndexPart == sumAfterIndexPart)
			{
				returnIndex = j;
				break;
			}
		}
		return returnIndex;
	}
}