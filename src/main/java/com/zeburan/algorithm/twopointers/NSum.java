
package com.zeburan.algorithm.twopointers;

import java.util.*;

/**
 * N数之和的问题集
 */
class NSum {
    /**
     * 最接近的三数之和：https://leetcode.cn/problems/3sum-closest/description/
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int temp = 0;
        int index2;
        int index3;
        for (int index1 = 0; index1 < nums.length; index1++) {
            index2 = index1 + 1;
            index3 = nums.length - 1;
            while (index2 < index3) {
                temp = nums[index1] + nums[index2] + nums[index3];
                result = Math.abs(result - target) < Math.abs(temp - target) ? result : temp;
                if (temp > target) {
                    index3--;
                } else if (temp == target) {
                    return target;
                } else {
                    index2++;
                }
            }
        }
        return result;
    }

    /**
     * 三数之和：https://leetcode.cn/problems/3sum/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int index1 = 0; index1 < len - 2; index1++) {
            if (nums[index1] > 0) {
                break;
            }
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            int target = 0 - nums[index1];
            int index2 = index1 + 1;
            int index3 = len - 1;
            while (index2 != index3) {
                if (nums[index2] > target) {
                    break;
                }
                if ((index2 - 1 > index1) && (nums[index2 - 1] == nums[index2])) {
                    index2++;
                    continue;
                }
                if (nums[index2] + nums[index3] == target) {
                    List<Integer> item = new ArrayList();
                    item.add(nums[index1]);
                    item.add(nums[index2]);
                    item.add(nums[index3]);
                    result.add(item);
                    index2++;
                } else if (nums[index2] + nums[index3] > target) {
                    index3--;
                } else {
                    index2++;
                }
            }

        }
        return result;
    }

    /**
     * 两数之和
     * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                int[] result = new int[2];
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                return result;
            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        return null;
    }
}