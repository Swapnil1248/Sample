package com.search;

public class BinarySearch
{

	public BinarySearch()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		System.out.println("Hello");
		//int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] array = new int[] {};
		// System.out.println("Array length = " +array.length);
		int key = 5;
		BinarySearch bs = new BinarySearch();
		int index = bs.binarySearchIterative(array, key);
		System.out.println("Value found at index " + index);
		index = bs.binarySearchRecursive(array, key, 0, array.length - 1);
		System.out.println("Value found at index " + index);
	}

	public int binarySearchIterative(int[] array, int key)
	{
		int returnValue = -1;
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while (low <= high)
		{
			mid = (low + high) / 2;
			if (array[mid] < key)
			{
				low = mid + 1;
			}
			else if (array[mid] > key)
			{
				high = mid - 1;
			}
			else
			{
				returnValue = mid;
				break;
			}
		}
		return returnValue;
	}

	public int binarySearchRecursive(int[] array, int key, int low, int high)
	{
		int mid = 0;

		if (low <= high)
		{
			mid = (low + high) / 2;

			if (array[mid] < key)
				return binarySearchRecursive(array, key, mid + 1, high);
			else if (array[mid] > key)
				return binarySearchRecursive(array, key, low, mid - 1);
			else
				return mid;
		}
		else
		{
			return -1;
		}
	}
}
