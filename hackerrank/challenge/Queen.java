package hackerrank.challenge;

import java.util.Scanner;

public class Queen
{
	static int n;
	static boolean road[];
	static int city[];
	static int addedGuard;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int a0 = 0; a0 < t; a0++)
		{
			addedGuard = 0;
			n = in.nextInt();
			if (n == 1)
			{
				sb.append(0).append("\n");
				in.nextInt();
			}
			else
			{
				city = new int[n];
				for (int a_i = 0; a_i < n; a_i++)
				{
					city[a_i] = in.nextInt();
				}
				road = new boolean[n - 1];
				for (int i = 0; i < n - 1; i++)
				{
					road[i] = false;
				}

				markRoad();
				int unSafeRoad = unSafeRoad();
				while (unSafeRoad != -1)
				{
					addGuard(unSafeRoad + 1);
					markLatestRoad(unSafeRoad + 1);
					unSafeRoad = unSafeRoad();
				}
				sb.append(addedGuard).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void markLatestRoad(int i)
	{
		if (i < n - 1)
			road[i] = true;
		if (i - 1 >= 0)
			road[i - 1] = true;
	}

	static void markRoad()
	{
		for (int i = 0; i < n; i++)
		{
			if (city[i] == 1)
			{
				if (i < n - 1)
					road[i] = true;
				if (i - 1 >= 0)
					road[i - 1] = true;
			}
		}
	}

	static void addGuard(int i)
	{
		addedGuard++;
		city[i] = 1;
	}

	static int unSafeRoad()
	{
		int retValue = -1;
		for (int i = 0; i < n - 1; i++)
		{
			if (!road[i])
			{
				// System.out.println("road["+i+"]");
				return i;
			}
		}
		return retValue;
	}
}
