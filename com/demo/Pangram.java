package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Pangram
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toLowerCase().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char i = 'a'; i <= 'z'; i++)
		{
			map.put(i, 0);
		}
		String val = "pangram";
		for (char a : str)
		{
			if (!Character.isWhitespace(a))
			{
				if (map.containsKey(a))
					map.put(a,map.get(a) + 1);
			}
		}
		if(map.containsValue(0)){
			val = "not pangram";
		}
		System.out.println(val);
	}
}