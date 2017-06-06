package com.dp;

public class DPPalindrome
{

	public static void main(String[] args)
	{
		char[] p = new char[] { 'k', 'a', 'n', 'g', 'a', 'r', 'o', 'o' };
		char[] q = new char[] { 'k', 'a', 'n', 'g', 'a', 'r', 'o', 'o' };
		int length = p.length;
		int[][] array = new int[length+1][length+1];

		for (int i = length - 1; i >= 0; i--)
		{
			for (int j = 0; j < length; j++)
			{
				if(i>j){
					//System.out.println(i+" "+j);
					array[i][j] = 0;
				}
				else if(i==j)
					array[i][j] = 1;
				else if (p[i] == p[j]){
					array[i][j] = array[i+1][j+1] + 2;
				}
				else{
					if(array[i+1][j] > array[i][j-1])
						array[i][j] = array[i+1][j];
					else
						array[i][j] = array[i][j-1];
				}
			}
		}
		System.out.print("  [ ");
		for (int j = 0; j < length; j++)
		{
			System.out.print(" "+p[j] +" ");
		}
		System.out.print("]");
		System.out.println("");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(p[i]+" [ ");
			for (int j = 0; j < length; j++)
			{
				System.out.print(" "+array[i][j] + " ");
			}
			System.out.print("]");
			System.out.println("");
		}
	}
}
