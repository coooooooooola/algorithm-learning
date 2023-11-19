package com.zeburan.algorithm.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一维动态规划
 * Create by swtywang on 11/18/23 11:34 AM
 */
public class oneDimension {
    /**
     * 70. Climbing Stairs
     * https://leetcode.cn/problems/climbing-stairs/submissions/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         *  index: -2 -1 0 1 2 3 ...
         *  value: 0  0  1 1 2 3 ...
         */
        //f(n-2)
        int a = 0;
        //f(n-1)
        int b = 0;
        //f(n)
        int c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    /**
     * 198. House Robber
     * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 198. House Robber
     * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
     * 使用2个变量替换数组，但是leetcode 内存复杂度一样，我不李姐
     *
     * @param nums
     * @return
     */
    public static int robII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int a = nums[0];
        int b = Math.max(nums[1], nums[0]);
        int c = b;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 139. Word Break
     * https://leetcode.cn/problems/word-break/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //空字符串
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * 322 Coin Change
     * https://leetcode.cn/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 300. Longest Increasing Subsequence
     * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        rob(new int[]{2, 1, 1, 2});
    }
}
