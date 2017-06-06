package com.graph.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PRIM
{

	public static void main(String[] args)
	{
		int N, M, start;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		N = sc.nextInt();
		M = sc.nextInt();
		LinkedList<Node> adjList[] = new LinkedList[N + 1];
		for (; M-- > 0;)
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			long w = sc.nextLong();
			if (adjList[n1] == null)
			{
				adjList[n1] = new LinkedList<Node>();
			}
			adjList[n1].add(new Node(n2, w));
			if (adjList[n2] == null)
			{
				adjList[n2] = new LinkedList<Node>();
			}
			adjList[n2].add(new Node(n1, w));
		}
		start = sc.nextInt();
		long output = primMST(adjList, N, start);
		System.out.println(output);
	}

	public static long primMST(LinkedList<Node>[] adjList, int n, int start)
	{
		long result = 1;
		long[] cost = new long[n+1];
		System.out.println("Cost - "+Arrays.toString(cost));
		boolean[] visited = new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			cost[i]=Long.MAX_VALUE;
		}
		cost[start] = 1;
		for (int i = 0; i < n; i++){
			int u=min_cost(cost,visited);
			visited[u]=true;
			if(adjList[u]!=null)
			{
				Iterator<Node> itr=adjList[u].iterator();
				while(itr.hasNext())
				{
					Node ob=itr.next();
					int v=ob.v;
					long w=ob.w;
					if(!visited[v]&&cost[v]>w)
					{
						cost[v]=w;
						
					}
				}
			}
		}
		return result;
	}
	

private static int min_cost(long[] cost, boolean[] visited) {
	int min_index=0;
	long min=Long.MAX_VALUE;
	for(int i=1;i<cost.length;i++)
	{
		if(!visited[i]&&cost[i]<min)
		{
			min=cost[i];
			min_index=i;
		}
	}
	return min_index;
}

	private static class Node
	{
		int v;
		long w;

		Node(int v, long w)
		{
			this.v = v;
			this.w = w;
		}
	}
}