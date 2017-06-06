package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution2
{


	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] countRight = new int[1000];
		int[] countLeft = new int[1000];
		Map<String, Integer> map = new HashMap<String, Integer>();
		int index = 1;
		for (; T > 0; T--)
		{
			String[] line = br.readLine().split("\\s+");
			String key = line[0] + line[1] + line[2];
			if (!map.containsKey(key))
			{
				map.put(key, index);
				index++;
			}
			if (line[3].equals("R"))
			{
				countRight[map.get(key)]++;
			}
			else
			{
				countLeft[map.get(key)]++;
			}
		}
		int val = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
		    val += Math.min(countRight[entry.getValue()], countLeft[entry.getValue()]); 
		}
		System.out.println(val);
	}

}
