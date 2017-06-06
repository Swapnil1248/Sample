package hackerrank.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		// System.out.println(Arrays.toString(a));
		long acuteCount = 0;
		long obtuseCount = 0;
		long rightCount = 0;
		for (int i = 0; i < n; i++)
		{
			int k = i + 2;
			int l = i + 2;
			int m = i + 2;
			for (int j = i + 1; j < n; j++)
			{
				while (k < n && a[k] < a[i] + a[j])
				{
					k++;
				}

				while (l < k && a[i] * a[i] + a[j] * a[j] > a[l] * a[l])
				{
					l++;
				}
				while (m < k && a[i] * a[i] + a[j] * a[j] >= a[m] * a[m])
				{
					m++;
				}
				acuteCount += l - j - 1;
				rightCount += m - l;
				obtuseCount += k - m;
			}
		}
		System.out.println(acuteCount + " " + rightCount + " " + obtuseCount);
	}
}
