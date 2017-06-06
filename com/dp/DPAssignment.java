package com.dp;

import java.util.Arrays;

public class DPAssignment
{

	public DPAssignment()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DPAssignment ass = new DPAssignment();
		double[][] result = ass.winnerATeam(3, 0.6);
		//ass.printArray(result);
	}
	
	public void printArray(double[][] array){
		System.out.println(Arrays.deepToString(array));
	}

	public double[][] winnerATeam(int size,double probability)
	{   
		double p = probability;
		int n = size;
		double[][] W = new double[n+1][n+1];
		W[n][n] = -1;
		for(int i=0; i<n; i++ ){
			W[n][i] = 1;
		}
		for(int j=0; j<n; j++ ){
			W[j][n] = 0;
		}
		for(int i = n - 1; i >= 0; i--){
			for(int j = n-1; j>=0; j--){
				System.out.print("W["+i+"]["+j+"] = ");
				System.out.print(p+"*"+W[i+1][j]);
				System.out.print(" + ");
				System.out.print((1 - p)+"*"+W[i][j+1]);
				W[i][j] = p*(W[i+1][j]) + (1-p)*(W[i][j+1]);
				System.out.print(" = "+W[i][j]);
				System.out.println();
			}
		}
		return W;
	}

}
