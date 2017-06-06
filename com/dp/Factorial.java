package com.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Factorial
{

	public Factorial()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		System.out.println(n);
		BigInteger[] fact = new BigInteger[101];
		fact[0] = BigInteger.ONE;
		fact[1] = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
		{
			fact[i] = fact[i-1].add(fact[i-2]);
		}
		for (int i = 0; i <= n; i++)
		{
			System.out.println(i + " " + fact[i]);
		}
	}
}
