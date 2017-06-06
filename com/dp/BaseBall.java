package com.dp;

import java.util.Comparator;

/**
 * Created by urmi on 10/28/2016.
 */
public class BaseBall {
    private static class Info implements Comparator<Info>{
        int value = 0;
        int player = 0;

        public Info(int value, int player){
            this.value = value;
            this.player = player;
        }

        public String toString(){
            return this.value+" " + this.player;
        }

        public int compare(Info a, Info b){
            return a.value - b.value;
        }
    }


    public static void main(String[] args){
        int n = 6;
        int P = 3;
        int C = 10;
        int[] v = new int[]{2,4,5,4,6,7};
        int[] c = new int[]{2,3,5,4,7,8};
        int[] p = new int[]{1,1,2,3,3,3};
        Info[][] dp = new Info[P+1][C+1];


        for(int i = 0; i <= P; i++)
            for(int j = 0; j <= C; j++)
                dp[i][j] = new Info(0,-1);

        for(int i = 1; i<=P; i++){
            for(int j = 0; j <= C; j++){
                dp[i][j].value = dp[i-1][j].value;
                dp[i][j].player = dp[i-1][j].player;
            }
            for(int k = 0; k < n; k++){
                if( i == p[k]){
                    for(int l = 0; l <= C; l++){
                        if(l >= c[k]){
                            if(dp[i][l].value < dp[i-1][l-c[k]].value + v[k]){
                                dp[i][l].value = dp[i-1][l-c[k]].value + v[k];
                                dp[i][l].player = k+1;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print("("+dp[i][j]+")\t");
            }
            System.out.println();
        }
        int i = P;
        int j = C;
        while(i > 0 && j >= 0){
            if(dp[i][j].value == dp[i-1][j].value){
                i = i - 1;
            }else{
                System.out.println(dp[i][j]);
                i = i - 1;
                j = j - c[dp[i][j].player+1];
            }
        }
    }
}
