package com.zeburan.algorithm.Array;

import java.util.Arrays;

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

    /**
     * 274. H指数
     * https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count=0;
        for (int i=0;i<citations.length;i++){
            if (i+1>citations[citations.length-i-1]){
                return i;
            }
            count++;
        }
        return count;
    }
}
