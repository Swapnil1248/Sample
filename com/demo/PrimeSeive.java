package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeSeive
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Set<Integer> st = new HashSet<Integer>();
		int[] prime;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split("\\s+");
		int len = line.length;
		long[] ar = new long[len];
		for (int i = 0; i < len; i++)
		{
			ar[i] = Long.parseLong(line[i]);
		}
		// Generate all prime numbers till T
		for (int i = 2; i < T; i++)
		{
			if (isPrime(i))
			{
				st.add(i);
			}
		}
		int primelen = st.size();
		prime = new int[primelen];
		int x = 0;
		for (Integer s : st)
		{
			prime[x] = s;
			x++;
		}
		
		

		System.out.println(Arrays.toString(prime));
		long count = 0;
		for (int i = 0; i < len; i++)
		{
			for (int j = 0 ; j < primelen; j++)
			{
				int z = i + prime[j];
				
				if (z < len)
				{
					//System.out.println(i + " " + s + " " + z);
					if (z - i > 0)
					{
						count += ar[z] - ar[i];
					}
					else
					{
						break;
					}
				}
				else{
					System.out.println("Z is "+z);
					break;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean isPrime(int value)
	{
		if (value <= 1)
			return false;

		// There's only one even prime: that is two
		if ((value % 2) == 0)
			return (value == 2);

		//int from = (int) (Math.sqrt(value) + 1);

		// You have to check possible divisors from 3 to sqrt(value)
		for (int i = 3; i*i <= value; i += 2)
			if ((value % i) == 0)
				return false;

		return true;
	}
}
