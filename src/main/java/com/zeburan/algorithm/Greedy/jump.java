package com.zeburan.algorithm.Greedy;

public class jump {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static boolean jump(int[] nums) {
        int maxDistance = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxDistance) {
                return false;
            }
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length) {
                return true;
            }
        }
        return true;
    }

    /**
     * 贪心算法，自己没做出来
     * @param nums
     * @return
     */
    public static int jumpII(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        boolean flag = jump(new int[]{2, 3, 0, 1, 4});
        int flag1 = jumpII(new int[]{5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8});
        System.out.println(flag);
        System.out.println(flag1);
    }
}