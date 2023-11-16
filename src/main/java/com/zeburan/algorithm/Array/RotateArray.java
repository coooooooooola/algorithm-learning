package com.zeburan.algorithm.Array;

public class RotateArray {
    /**
     * 189. https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        //先整体翻转
        rotateArr(nums, 0, nums.length - 1);
        //再分组翻转
        rotateArr(nums, 0, k - 1);
        rotateArr(nums, k, nums.length - 1);
    }

    public static void rotateArr(int[] nums, int start, int end) {
        int times = (end - start + 1) / 2;
        for (int time = 0; time < times; time++) {
            int temp = nums[start + time];
            nums[start + time] = nums[end - time];
            nums[end - time] = temp;
        }
    }

}
