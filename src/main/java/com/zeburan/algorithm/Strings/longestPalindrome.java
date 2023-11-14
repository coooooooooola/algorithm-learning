package com.zeburan.algorithm.Strings;

public class longestPalindrome {
    //https://leetcode.cn/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int maxLen_startIndex = 0;
        //Boolean->boolean
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int length = 2; length <= len; length++) {
            for (int i = 0; i <= len - length; i++) {
                int j = i + length - 1;
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
//                if (length == 2) {
//                    dp[i][j] = (s.charAt(i) == s.charAt(j));
//                } else {
//                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
//
//                }
                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    maxLen_startIndex = i;
                }
            }
        }
        return s.substring(maxLen_startIndex, maxLen_startIndex + maxLen);

    }

    public static void main(String[] args) {
        System.out.println(new longestPalindrome().longestPalindrome("a"));
    }
}
