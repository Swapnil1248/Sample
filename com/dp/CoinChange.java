package com.dp;

/**
 * Created by swapn on 10/10/2016.
 */
import java.util.Arrays;
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        int[] dp = new int [amount+1];
        dp[0]=0; // do not need any coin to get 0 amount
        for(int i=1;i<=amount; i++)
            dp[i]= Integer.MAX_VALUE;

        for(int i=0; i<=amount; i++){
            for(int coin: coins){
                if(i+coin <=amount){
                    if(dp[i]==Integer.MAX_VALUE){
                        dp[i+coin] = dp[i+coin];
                    }else{
                        dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                    }
                    System.out.println(Arrays.toString(dp));
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        if(dp[amount] >= Integer.MAX_VALUE)
            return -1;

        return dp[amount];

    }

    public static void main(String[] args){
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    }
}
