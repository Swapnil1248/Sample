package com.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class MissingNumber
{

	public static void main(String[] args) throws IOException
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// First list
		StringBuffer str = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		TreeMap<Short, Short> map = new TreeMap<Short, Short>();
		for (int i = 0; i < N; i++)
		{
			short v = Short.parseShort(temp[i]);

			if (!map.containsKey(v))
			{
				map.put(v, (short) 1);
			}
			else
			{
				map.put(v, (short) (map.get(v) + 1));
			}

		}

		int M = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
		{
			short v = Short.parseShort(temp[i]);
			if (!map.containsKey(v))
			{
				map.put(v, (short) 1);
			}
			else
			{
				map.put(v, (short) (map.get(v) - 1));
			}
		}
		for (Map.Entry<Short, Short> entry : map.entrySet())
		{

			if (entry.getValue() != 0)
			{
				str.append(entry.getKey() + " ");
			}

		}
		System.out.println(str);
	}
}
