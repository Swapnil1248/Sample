package com.dp;

import java.io.*; 
import java.util.*;

public class CoinOnTable {
private static int n = 0;
private static int m = 0;

private static int dp[][][];

static int min(int a, int b) {
    return a < b ? a : b;
}

static int selectMax(int a, int l) {
    return a == Integer.MAX_VALUE ? Integer.MAX_VALUE : a + l;
}

static int func(char arr[][], int x, int y, int k) {
    if(x < 0 || x >= n || y < 0 || y >= m)
        return Integer.MAX_VALUE;

    if(arr[x][y] == '*') {
        //System.out.println("res found" + " x:" + x + " y:" + y + " k: " + k);
        return 0;
    }

    if(k == 0)
        return Integer.MAX_VALUE;

    if(dp[x][y][k-1] != -1)
        return dp[x][y][k-1];

    int minRes = Integer.MAX_VALUE;
    minRes = min(minRes, selectMax(func(arr, x,y+1, k-1), arr[x][y] == 'R' ? 0 : 1));
    minRes = min(minRes, selectMax(func(arr, x+1,y, k-1), arr[x][y] == 'D' ? 0 : 1));
    minRes = min(minRes, selectMax(func(arr, x,y-1, k-1), arr[x][y] == 'L' ? 0 : 1));
    minRes = min(minRes, selectMax(func(arr, x-1,y, k-1), arr[x][y] == 'U' ? 0 : 1));

    dp[x][y][k-1] = minRes;
    return dp[x][y][k-1];
}

public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    m = s.nextInt();
    int k = s.nextInt();

    dp = new int[n][m][k];        
    char arr[][] = new char[n][m];

    s.nextLine();
    for(int i=0; i<n; ++i) {
        arr[i] = s.nextLine().toCharArray();
        for(int j=0; j<m; ++j) {
            for(int p=0; p<k; ++p)
                dp[i][j][p] = -1;
        }
    }

    int res = func(arr, 0, 0, k);
    System.out.println(res == Integer.MAX_VALUE ? -1 : res);
}
}
            