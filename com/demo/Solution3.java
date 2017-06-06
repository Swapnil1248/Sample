package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3
{

	public static void main(String[] args) throws IOException, NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		for (int T = Integer.parseInt(br.readLine()); T > 0; T--)
		{
			String[] line = br.readLine().split("\\s+");
			int s = Integer.parseInt(line[0]);
			int t = Integer.parseInt(line[1]);
			int sum = 0;
			for (int i = s; i <= t; i++)
			{
				int pow;
				if (isPrime(checkPow(i, 7)))
				{
					pow = -1;
					sum += pow;
				}
				else
				{
					pow = 1;
					while (isPrime(checkPow(i, pow)))
					{
						pow++;
					}
					sum += pow - 1;
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

	public static boolean isPrime(double d)
	{
		if (d <= 1)
			return false;

		// There's only one even prime: that is two
		if ((d % 2) == 0)
			return (d == 2);

		int from = (int) (Math.sqrt(d) + 1);

		// You have to check possible divisors from 3 to sqrt(value)
		for (int i = 3; i <= from; i += 2)
			if ((d % i) == 0)
				return false;

		return true;
	}

	public static double checkPow(int i, int a)
	{
		//System.out.println(i + " " + a);
		double sum = 0;
		while (i != 0)
		{
			int rem = i % 10;
			int mul = 1;
			for(int j = 0; j < a; j++){
				mul = mul * rem;
			}
			sum = sum + mul;
			i = i / 10;
		}
		//System.out.println(sum);
		return sum;
	}

}
