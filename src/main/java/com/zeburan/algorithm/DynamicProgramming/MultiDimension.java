package com.zeburan.algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by swtywang on 11/19/23 10:11 AM
 */
public class MultiDimension {

    /**
     * 120. 三角形最短路径和
     * https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int layer = triangle.size();
        int width = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[layer][layer + 1];
        dp[0][0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < layer; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < width; i++) {
            result = Math.min(dp[layer - 1][i], result);
        }
        return result;
    }

    /**
     * 64. 最短路径和
     * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //没有做空间优化
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 & j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[0][j] = grid[0][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 62. 不同路径II
     * https://leetcode.cn/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        //初始化第一行
        for (int i = 1; i < col; i++) {
            //dp[0][i-1]==0 第一次调试没考虑到
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        //初始化第一列
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 221. 最大正方形
     * https://leetcode.cn/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSide = Math.max(dp[i][0], maxSide);
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            maxSide = Math.max(dp[0][i], maxSide);
        }
        //第一列、第一行默认为0，已处理，从(1,1)开始处理
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] ||  dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];

    }

    /**
     * 标准答案，复杂度稍微
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleaveI(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];

    }

    public static void main(String[] args) {
//        List<List<Integer>> triangle = new ArrayList();
//        ArrayList list1 = new ArrayList();
//        list1.add(2);
//        ArrayList list2 = new ArrayList();
//        list2.add(3);
//        list2.add(4);
//        ArrayList list3 = new ArrayList();
//        list3.add(6);
//        list3.add(3);
//        list3.add(7);
//        ArrayList list4 = new ArrayList();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
//        triangle.add(list1);
//        triangle.add(list2);
//        triangle.add(list3);
//        triangle.add(list4);
//        minimumTotal(triangle);
//        char[][] matrix = new char[4][5];
//        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
//        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
//        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
//        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
//        char[][] matrix = new char[2][2];
//        matrix[0][0] = '1';
//        matrix[0][1] = '1';
//        matrix[1][0] = '1';
//        matrix[1][1] = '1';
//        maximalSquare(matrix);
        String s1 = "aabbc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        isInterleave(s1, s2, s3);
        isInterleaveI(s1, s2, s3);
    }
}
