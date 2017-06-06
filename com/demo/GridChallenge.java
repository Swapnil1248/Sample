package com.demo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridChallenge {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (int T = Integer.parseInt(br.readLine());T>0;T--){
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][];
            for (int i = 0; i < N; i++){
                arr[i] = br.readLine().toCharArray();
                Arrays.sort(arr[i]);
            }
            boolean flag = true;
            int colLength = arr[0].length;
            for(int i = 0; i < colLength; i++){
                for(int j = 0; j < N-1; j++){
                    if(arr[j][i] > arr[j+1][i]) {
                        flag = false;
                        break;
                    }
                }
            }
            sb.append(flag?"YES":"NO").append("\n");
        } 
        System.out.println(sb);
    }
}