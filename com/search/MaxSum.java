package com.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class MaxSum {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
        for (int T = Integer.parseInt(br.readLine());T>0;T--){
          String[] line = br.readLine().split("\\s+");
          int N = Integer.parseInt(line[0]);
          long M = Long.parseLong(line[1]);
          line = br.readLine().split("\\s+");  
          long[] array = new long[N];
          for(int i = 0; i < N; i++) {
            long temp = Long.parseLong(line[i]) % M;
            if(i == 0) array[i] = temp;
            else array[i] = (array[i-1]+temp) % M;
          }
          System.out.println(Arrays.toString(array));
          TreeSet<Long> tset = new TreeSet<Long>();
          long max = 0;
          for(long i: array) {
            if(tset.isEmpty()) {
              max = i;
              tset.add(i);
            }
            else {
              max = Math.max(max, i);
              Long next = tset.ceiling(i+1);
              if(next != null) max = Math.max(max, i - next + M);
              tset.add(i);
            }
          }
          output.append(max + "\n");
        }
        System.out.println(output);
    }
}