package com.zeburan.algorithm.Array;

/**
 * Create by swtywang on 11/15/23 10:51 PM
 */
public class RegularArray {
    /**
     * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
     * 找到超过半数的元素
     * 投票算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //也可以用两个int维护
        int[] res = new int[2];
        res[0] = nums[0];
        res[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res[0]) {
                res[1]++;
            } else {
                if (res[1] <= 0) {
                    res[0] = nums[i];
                    res[1] = 1;
                } else {
                    res[1] = res[1] - 1;
                }
            }
        }
        return res[0];
    }
}
