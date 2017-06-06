package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VMWareC {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] server = br.readLine().split("\\s+");
        int[] cost = new int[n];
        for (int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(server[i]);
        }
        int lastIndex = n-1;
        int firstIndex = 0;
        int count = 1;
        int totalCost = 0;
        while(count != n+1){
            if(cost[firstIndex] > cost[lastIndex]){
                totalCost += count * cost[firstIndex];
                firstIndex++;
            }
            else if(cost[firstIndex] == cost[lastIndex]){
                if(chooseFirst(firstIndex, lastIndex, cost, n-1)){
                    totalCost += count * cost[firstIndex];
                    firstIndex++;
                }else{
                    totalCost += count * cost[lastIndex];
                    lastIndex--;
                }
            }
            else{
                totalCost += count * cost[lastIndex];
                lastIndex--;
            }
         count++;    
        }
        System.out.println(totalCost);
       // System.out.println(chooseFirstFull(0,n-1,cost,n-1,0,1));
    }

     private static boolean chooseFirst(int firstIndex, int lastIndex, int[] cost, int n)
	{
		boolean retVal = true;
		int newFirstIndex = Math.min(firstIndex + 1,n);
		int newLastIndex = Math.max(lastIndex - 1,0);
		if(firstIndex > lastIndex) return true; 
		if(cost[newFirstIndex] > cost[newLastIndex])
			retVal = true;
		else if (cost[newFirstIndex] < cost[newLastIndex])
			retVal = false;
		else
			retVal = chooseFirst(newFirstIndex, newLastIndex, cost, n);
		return retVal;
	}

	private static int chooseFirstFull(int firstIndex, int lastIndex, int[] cost, int n, int total, int count)
	{
		int retVal = total;
		if(firstIndex > lastIndex) return retVal; 
		if(cost[firstIndex] > cost[lastIndex]){
			total += count * cost[firstIndex];
			firstIndex++;
			count++;
			retVal += chooseFirstFull(firstIndex, lastIndex, cost, n, total, count);
		}
		else if (cost[firstIndex] < cost[lastIndex]){
			total = count * cost[lastIndex];
			lastIndex--;
			count++;
			retVal += chooseFirstFull(firstIndex, lastIndex, cost, n, total, count);
		}			
		else{
			int newFirstIndex = Math.min(firstIndex + 1,n);
			int newLastIndex = Math.max(lastIndex - 1,0);
			retVal += chooseFirstFull(newFirstIndex, newLastIndex, cost, n, total, count);
		}
		return retVal;
	}
	
}