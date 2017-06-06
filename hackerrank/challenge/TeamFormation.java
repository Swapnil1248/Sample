package hackerrank.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamFormation
{

	public TeamFormation()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		long startTime = System.currentTimeMillis();

		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("/media/swapnil/Local Disk/eclipsework/Demo/src/input.txt"));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0)
		{
			System.out.println("Test case"+T);
			String[] line = br.readLine().trim().split("\\s+");
			int N = Integer.parseInt(line[0]);
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
			{
				arr[i] = Integer.parseInt(line[i + 1]);
			}
			Arrays.sort(arr);
			List<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
			listOfList.add(new ArrayList<Integer>());
			for (int i : arr)
			{
				int count = 0;
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				int len = Integer.MAX_VALUE;
				for (ArrayList<Integer> list : listOfList)
				{
					
					if (checkListforData(list, i))
					{
						count++;
						if (list.size() < len)
						{
							tempList = list;
						}
					}
				}
				if (count == 0)
				{
					ArrayList<Integer> newList = new ArrayList<Integer>();
					newList.add(i);
					listOfList.add(newList);
				}
				else
				{
					tempList.add(i);
				}
			}
			int minLength = Integer.MAX_VALUE;
			for (ArrayList<Integer> list : listOfList)
			{
				int size = list.size();
				if (minLength > list.size())
				{
					minLength = size;
				}
			}
			sb.append(minLength+"\n");
		}
		System.out.println(sb);

		long endTime   = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	public static boolean checkListforData(List<Integer> list, int a)
	{
		boolean retVal = false;
		
		if(list.isEmpty())
			return true;
		
		if ((list.indexOf(a) == -1) && (a == list.get(list.size()-1) + 1))
		{
			return true;
		}
		return retVal;
	}

}
