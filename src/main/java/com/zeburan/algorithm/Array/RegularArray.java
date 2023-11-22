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
     *
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
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            if (i + 1 > citations[citations.length - i - 1]) {
                return i;
            }
            count++;
        }
        return count;
    }

    /**
     * ⭐ 238. 除自己以外数组乘积
     * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);
        int right = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int[] dp = new int[gas.length];
        for (int start = 0; start < gas.length; start++) {
            int num = gas[start] - cost[start];
            if (num < 0) {
                continue;
            }
            boolean flag = true;
            for (int count = 1; count <= gas.length; count++) {
                int actualIndex = (start + count) % gas.length;
                num = num + gas[actualIndex] - cost[actualIndex];
                if (num < 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            return start;
        }
        return -1;
    }


    public static void main(String[] args) {
        new RegularArray().productExceptSelf(new int[]{1, 2, 3, 4, 5});
        int result = new RegularArray().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
        System.out.println(result);
    }
}
