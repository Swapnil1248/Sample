package com.sort;

public class InsertionSort
{

	public InsertionSort()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		int[] array = new int[] { 10, 11, 8, 9, 7, 6, 5, 4, 3, 2, 1 };
		InsertionSort iSort = new InsertionSort();
		System.out.println("Original array " + printArray(array));

		iSort.sort(array);

		System.out.println("Sorted array " + printArray(array));
	}

	private static String printArray(int[] array)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < array.length; i++)
		{
			sb.append(array[i]);
			if (i != array.length - 1)
			{
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	private void sort(int[] array)
	{
		int n = array.length;
		int j;
		for (int i = 1; i < n; i++)
		{
			j = i;
			while ((j > 0) && (array[j] < array[j - 1]))
			{
				//swap(array[j],array[j-1])
				j = j - 1;
			}
		}

	}

}
