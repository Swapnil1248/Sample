package com.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ASuperHero
{

	public ASuperHero()
	{
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) throws IOException
	{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("/media/swapnil/Local Disk/eclipsework/Demo/src/input.txt"));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++)
		{
			String[] line = br.readLine().split("\\s+");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			int[] minLevel = new int[N];
			int[][] bonus = new int[N][M];
			int[][] power = new int[N][M];
			for (int j = 0; j < N; j++)
			{
				line = br.readLine().split("\\s+");
				int min = Integer.parseInt(line[0]);
				for (int k = 0; k < M; k++)
				{
					int val = Integer.parseInt(line[k]);
					power[j][k] = val;
					if (val < min)
					{
						min = val;
						minLevel[j] = k;
					}
				}
			}
			for (int j = 0; j < N; j++)
			{
				line = br.readLine().split("\\s+");
				for (int k = 0; k < M; k++)
				{
					int val = Integer.parseInt(line[k]);
					bonus[j][k] = val;
				}
			}
			int actualBullet = 0;
			int bonusBullet = 0;
			for (int a = 0; a < N; a++)
			{
				int bulletRequired = power[a][minLevel[a]];
				if (a == 0)
				{
					actualBullet -= bulletRequired;
				}
				else
				{
					bonusBullet -= bulletRequired;

					if (bonusBullet < 0)
					{
						actualBullet += bonusBullet;
					}

				}
				bonusBullet = bonus[a][minLevel[a]];
				
				System.out.println("Actual "+actualBullet);
				System.out.println("Required " +bulletRequired);
				System.out.println("Bonus "+bonusBullet);
			}
			sb.append(Math.abs(actualBullet)).append("\n");
		}
		System.out.println(sb);
	}

}
