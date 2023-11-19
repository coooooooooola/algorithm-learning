package com.zeburan.algorithm.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by swtywang on 11/19/23 10:11 AM
 */
public class MultiDimension {

    /**
     * 120. 三角形最短路径和
     * https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
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
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //没有做空间优化
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (i==0 & j==0){
                    dp[0][0] = grid[0][0];
                }
                else if (i==0){
                    dp[0][j] = grid[0][j] + dp[i][j-1];
                }else if (j==0){
                    dp[i][j]=grid[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) +grid[i][j] ;
                }
            }
        }
        return dp[row-1][col-1];
    }

    /**
     * 62. 不同路径II
     * https://leetcode.cn/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0]==1? 0:1;
        //初始化第一行
        for (int i=1;i<col;i++){
            //dp[0][i-1]==0 第一次调试没考虑到
            if(obstacleGrid[0][i]==1 ||dp[0][i-1]==0){
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        //初始化第一列
        for (int i=1;i<row;i++){
            if(obstacleGrid[i][0]==1 || dp[i-1][0]==0){
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                if (obstacleGrid[i][j] ==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList();
        ArrayList list1 = new ArrayList();
        list1.add(2);
        ArrayList list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        ArrayList list3 = new ArrayList();
        list3.add(6);
        list3.add(3);
        list3.add(7);
        ArrayList list4 = new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        minimumTotal(triangle);
    }
}
