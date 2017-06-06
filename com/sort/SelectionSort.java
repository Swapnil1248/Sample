package com.sort;
/*
 * Selection Sort
 * take a array element and mark it as minimum and compare it to other array elements
 * if any other element is less than the marked element then mark it as min
 * swap the min element with the chosen index
 * */
public class SelectionSort
{

	public SelectionSort()
	{
	}

	public static void main(String[] args)
	{
		int[] array = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		SelectionSort sSort = new SelectionSort();
		System.out.println("Original array " + printArray(array));

		sSort.sort(array);

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
		int min = 0;
		for (int i = 0; i < n; i++)
		{
			min = i;
			for (int j = i + 1; j < n; j++)
			{
				if (array[min] > array[j])
				{
					min = j;
				}
			}

			// swap(array[i],array[min]);
			if (array[i] != array[min])
			{
				//System.out.println("Before swap " + array[i] + " " + array[min]);
				array[i] = array[i] + array[min];
				array[min] = array[i] - array[min];
				array[i] = array[i] - array[min];
				//System.out.println("After swap " + array[i] + " " + array[min]);
			}
		}
	}
}
