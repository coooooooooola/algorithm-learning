package com.zeburan.algorithm.DynamicProgramming;

public class Stock {
    public int stockII(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            result = Math.max(result,dp[i][0]);
        }
        return result;
    }

    public int stockIIOpt(int[] prices) {
        int preCash = 0;
        int preStock = -prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            preCash = Math.max(preCash, preStock + prices[i]);
            preStock = Math.max(preCash - prices[i], preStock);
            result = Math.max(result,preCash);
        }
        return result;
    }
}
